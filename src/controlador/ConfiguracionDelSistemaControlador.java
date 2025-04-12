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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modelo.ConfiguracionSistema;


/**
 * FXML Controller class
 *
 * @author gp
 */
public class ConfiguracionDelSistemaControlador implements Initializable {
    
    @FXML
    private TextField textNombreEmpresa;
    @FXML
    private ListView listaIdiomas;
    @FXML
    private ListView listaZonaHoraria;
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
    private Label labelError;
    
    private ConfiguracionSistema confiSistema;
    
    private ObservableList<String> zonaHoraria ;
        
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        zonaHoraria = FXCollections.observableArrayList(ZoneId.getAvailableZoneIds());
        Collections.sort(zonaHoraria);
        listaZonaHoraria.setItems(zonaHoraria);
    }
    
    
    @FXML
    public void ingresarNombre(ActionEvent event){
        String nombreEmpresa = textNombreEmpresa.getText() ;
        
    if (nombreEmpresa == null || nombreEmpresa.isEmpty() || nombreEmpresa.length() < 3 || nombreEmpresa.length() > 100 ) {
        labelError.setText("Error ingrese un nombre distinto");
        return;
    } 
    confiSistema.setNombreEmpresa(nombreEmpresa);
    textNombreEmpresa.setText(nombreEmpresa);
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
             Image logo = new Image(archivoSeleccionado.toURI().toString());
            imageLogoEmpresa.setImage(logo);
            System.out.println("Logo cargado exitosamente");
        } else {
            labelError.setText("No se seleccionó ningún archivo");
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
