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
import modelo.GestionDepartamentos;

/**
 * FXML Controller class
 *
 * @author gp
 */
public class GestionDepartamentosControlador implements Initializable {
    
    
    @FXML
    private ListView listDepartamentosExistentes;
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
    
    private ObservableList<GestionDepartamentos> listaDepartamentos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaDepartamentos = FXCollections.observableArrayList();
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
    
    
    
}
