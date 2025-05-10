/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelo.ConfiguracionSistema;
import modelo.ConfiguracionSistemaDAO;


/**
 * FXML Controller class
 *
 * @author gp
 */
public class ConfiguracionDelSistemaControlador implements Initializable {
    
    @FXML
    private TextField textNombreEmpresa;
    @FXML
    private ComboBox listaIdiomas;
    @FXML
    private ComboBox listaZonaHoraria;
    @FXML
    private ListView listaVencimientoTickets;
    @FXML
    private ImageView imageLogoEmpresa;
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonCargarLogo;
    @FXML
    private Button buttonIngresarNombre;
    @FXML
    private Label labelError;
    @FXML
    private ConfiguracionSistema confiSistema;   
    @FXML
    private ObservableList<String> zonaHoraria;
    @FXML
    private ObservableList<String> idiomaPredeterminado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {     
    zonaHoraria = FXCollections.observableArrayList(ZoneId.getAvailableZoneIds());
    Collections.sort(zonaHoraria);
    listaZonaHoraria.setItems(zonaHoraria);
    
    // Agregar un listener para validar automáticamente cuando el usuario seleccione una zona
    listaZonaHoraria.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        validarZonaHoraria();
    });
    
    // Crear lista con los idiomas soportados
    idiomaPredeterminado = FXCollections.observableArrayList("Español");
    // Agregar los idiomas al ComboBox
    listaIdiomas.setItems(idiomaPredeterminado);
    // Validar automáticamente cuando se seleccione un idioma
    listaIdiomas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        validarIdioma();
    });
    
    
     // Cargar la configuración persistida desde la base de datos, si existe.
    ConfiguracionSistema cs = ConfiguracionSistemaDAO.obtenerConfiguracion();
    if (cs != null) {
        confiSistema = cs;
        textNombreEmpresa.setText(cs.getNombreEmpresa());
        // Seleccionar el idioma y la zona en los ComboBox, según corresponda:
        listaIdiomas.getSelectionModel().select(cs.getIdiomaPredeterminado());
        listaZonaHoraria.getSelectionModel().select(cs.getZonaHoraria());
        // Si el logo existe, cargar la imagen
        if (cs.getRutaLogo() != null && !cs.getRutaLogo().isEmpty()) {
            Image logo = new Image("file:///" + cs.getRutaLogo());
            imageLogoEmpresa.setImage(logo);
        }
    } else {
        // Si no existe configuración previa, puedes inicializar confiSistema.
        confiSistema = new ConfiguracionSistema();
    }
    
}

    
    @FXML
public void ingresarNombre(ActionEvent event) {
    // Obtener y limpiar el nombre
    String nombreEmpresa = textNombreEmpresa.getText().trim();
    // Validación de entrada
    if (nombreEmpresa.isEmpty() || nombreEmpresa.length() < 3 || nombreEmpresa.length() > 100) {
        labelError.setText("Error: ingrese un nombre válido de entre 3 y 100 caracteres.");
        return;
    }
    // Inicializar confiSistema si es necesario
    if (confiSistema == null) {
        confiSistema = new ConfiguracionSistema();
    }
    // Guardar el nombre en el modelo
    confiSistema.setNombreEmpresa(nombreEmpresa);
    // Actualizar el campo de texto con el nombre guardado
    textNombreEmpresa.setText(nombreEmpresa);
    System.out.println("Nombre de empresa guardado: " + confiSistema.getNombreEmpresa());
}


    @FXML
public void validarZonaHoraria() {
    // Obtener la zona horaria seleccionada
    String zonaSeleccionada = (String) listaZonaHoraria.getSelectionModel().getSelectedItem();
    // Verificar si la zona seleccionada es válida
    if (zonaSeleccionada == null || zonaSeleccionada.isEmpty()) {
        labelError.setText("Error: seleccione una zona horaria válida.");
        return;
    }
    if (!zonaHoraria.contains(zonaSeleccionada)) {
        labelError.setText("Error: la zona horaria seleccionada no es valida.");
        return;
    }
    if (!zonaHoraria.contains(zonaSeleccionada)) {
        labelError.setText("Error: la zona horaria seleccionada no es valida.");
        return;
    }
    if (confiSistema == null) {
        confiSistema = new ConfiguracionSistema();
    }
    confiSistema.setZonaHoraria(zonaSeleccionada);
    System.out.println("Zona horaria seleccionada: " + zonaSeleccionada);
}


    @FXML
    public void validarIdioma() {
    // Obtener el idioma seleccionado
    String idiomaSeleccionado = (String) listaIdiomas.getSelectionModel().getSelectedItem();
    // Verificar que la selección sea válida
    if (idiomaSeleccionado == null || idiomaSeleccionado.isEmpty()) {
        labelError.setText("Error: seleccione un idioma válido.");
        return;
    }
    if (!idiomaSeleccionado.contains(idiomaSeleccionado)) {
        labelError.setText("Error: el idioma seleccionado no es válido.");
        return;
    }
    if (confiSistema == null) {
        confiSistema = new ConfiguracionSistema();
    }
    confiSistema.setIdiomaPredeterminado(idiomaSeleccionado);
    
    System.out.println("Idioma seleccionado: " + idiomaSeleccionado);
}
    
    
  
    @FXML
    public void cargarLogo(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        
         fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Imágenes JPG o PNG", "*.jpg", "*.png")
        );
         
          File archivoSeleccionado = fileChooser.showOpenDialog(null);

        if (archivoSeleccionado != null) {
            // Validar el tamaño del archivo (máximo 2MB)
            if (archivoSeleccionado.length() > 2 * 1024 * 1024) {
                labelError.setText("Error: El archivo excede el tamaño máximo de 2MB");
                return;
            }
            if (confiSistema == null) {
            confiSistema = new ConfiguracionSistema();
        }
        confiSistema.setRutaLogo(archivoSeleccionado.getAbsolutePath());
            
             Image logo = new Image(archivoSeleccionado.toURI().toString());
            imageLogoEmpresa.setImage(logo);
            System.out.println("Logo cargado exitosamente");
        } else {
            labelError.setText("No se seleccionó ningún archivo");
        }
    }
    
    @FXML
    public void guardarConfiguraciones(ActionEvent event){
        ingresarNombre(event);
        validarZonaHoraria();
        validarIdioma();
        cargarLogo(event);
        
         // Verificar que todas las configuraciones sean válidas antes de guardar
    if (confiSistema.getNombreEmpresa() == null || confiSistema.getNombreEmpresa().isEmpty()) {
        labelError.setText("Error: ingrese un nombre válido antes de guardar.");
        return;
    }

    if (confiSistema.getIdiomaPredeterminado() == null || confiSistema.getIdiomaPredeterminado().isEmpty()) {
        labelError.setText("Error: seleccione un idioma antes de guardar.");
        return;
    }

    if (confiSistema.getZonaHoraria() == null || confiSistema.getZonaHoraria().isEmpty()) {
        labelError.setText("Error: seleccione una zona horaria antes de guardar.");
        return;
    }

    if (confiSistema.getRutaLogo() == null || confiSistema.getRutaLogo().isEmpty()) {
        labelError.setText("Error: cargue un logo antes de guardar.");
        return;
    }

    //labelError.setText("Configuraciones guardadas correctamente.");
        // Persistir la configuración en la base de datos utilizando el DAO
    boolean guardado = modelo.ConfiguracionSistemaDAO.guardarConfiguracion(confiSistema);
    if (guardado) {
        labelError.setText("Configuraciones guardadas correctamente en la base de datos.");
    } else {
        labelError.setText("Error al guardar la configuración en la base de datos.");
    }
    
    }

    
        @FXML
    private void handleBotonCancelar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OpcionesVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConfiguracionDelSistemaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}