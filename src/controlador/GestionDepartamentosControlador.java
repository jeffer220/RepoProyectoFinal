/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;
import modelo.GestionDepartamentoDAO;
import modelo.GestionDepartamentos;

/**
 * FXML Controller class
 *
 * @author gp
 */
public class GestionDepartamentosControlador implements Initializable {
    
    
    @FXML
    private ListView<GestionDepartamentos> listDepartamentosExistentes;
    @FXML
    private Button buttonRegrear;
    @FXML
    private Button buttonCrearDepartamento;
    @FXML
    private TextField textNombreDepartamento;
    @FXML
    private TextField textDescripcionDepartamento;
    @FXML
    private ListView listaTecnicosDisponibles;
    @FXML
    private Label labelError;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button buttonEliminarDepartamento;
    
    
    private static ObservableList<GestionDepartamentos> listaDepartamentos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaDepartamentos = FXCollections.observableArrayList();
        listDepartamentosExistentes.setItems(listaDepartamentos);
        
        listaDepartamentos = GestionDepartamentoDAO.obtenerDepartamentos();
        listDepartamentosExistentes.setItems(listaDepartamentos);
    }
    
   @FXML
    public void crearDepartamentos (ActionEvent event){
        String nombreDepartamento = textNombreDepartamento.getText();
        String descDepartamento = textDescripcionDepartamento.getText();
        
        if (nombreDepartamento == null || nombreDepartamento.isEmpty() || nombreDepartamento.length() < 3 || nombreDepartamento.length() > 50) {
        labelError.setText("Error ingrese un nuevo nombre");
        return;
        }
        GestionDepartamentos gestion = new GestionDepartamentos(nombreDepartamento, descDepartamento);
        listaDepartamentos.add(gestion);
        listDepartamentosExistentes.setItems(listaDepartamentos);
    }   
    
  @FXML
public void guardarConfiguraciones(ActionEvent event) {
    String nombreDepartamento = textNombreDepartamento.getText();
    String descDepartamento = textDescripcionDepartamento.getText();

    if (nombreDepartamento == null || nombreDepartamento.isEmpty() || nombreDepartamento.length() < 3 || nombreDepartamento.length() > 50) {
        labelError.setText("Error: ingrese un nombre válido.");
        return;
    }

    GestionDepartamentos gestion = new GestionDepartamentos(nombreDepartamento, descDepartamento);
    
    // Guardar en la base de datos
    boolean guardado = GestionDepartamentoDAO.guardarDepartamento(gestion);

    if (guardado) {
        listaDepartamentos.add(gestion);  // Agregarlo también a la lista en la interfaz
        listDepartamentosExistentes.setItems(listaDepartamentos);
        labelError.setText("Departamento guardado correctamente.");
    } else {
        labelError.setText("Error al guardar el departamento en la base de datos.");
    }
}

    @FXML
public void eliminarDepartamento(ActionEvent event) {
    GestionDepartamentos seleccionado = listDepartamentosExistentes.getSelectionModel().getSelectedItem();

    if (seleccionado == null) {
        labelError.setText("Seleccione un departamento para eliminar.");
        return;
    }

    boolean eliminado = GestionDepartamentoDAO.eliminarDepartamento(seleccionado.getNombreDepartamento());

    if (eliminado) {
        listaDepartamentos.remove(seleccionado);  // También elimi narlo de la lista en la interfaz
        labelError.setText("Departamento eliminado correctamente.");
    } else {
        labelError.setText("Error al eliminar el departamento.");
    }
}

    
    
    
    
    @FXML
    private void handleBotonRegresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OpcionesVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionDepartamentosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ObservableList<GestionDepartamentos> getListaDepartamentos() {
        return listaDepartamentos;
    }

   
    
    
    
}
