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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gp
 */
public class GestionDeFlujosDeTrabajoControlador implements Initializable {
    
    
    @FXML
    private ListView listaFlujosExistentes;
    @FXML
    private Button buttonCrearFlujo;
    @FXML
    private Button buttonModFlujo;
    @FXML
    private Button buttonEliminarFlujo;
    @FXML
    private Button buttonRegresar;
    

    @FXML
    private void handleCrearFlujoDeTrabajo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/CrearFlujoDeTrabajoVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionDeFlujosDeTrabajoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    @FXML
    private void handleModificarFlujoDeTrabajo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ModificarFlujoDeTrabajoVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionDeFlujosDeTrabajoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void handleBtnRegresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OpcionesVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionDeFlujosDeTrabajoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    @FXML
    private void handleEliminarFlujoDeTrabajo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EliminarFlujoDeTrabajoVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionDeFlujosDeTrabajoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
