/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpcionesControlador {
    
    
    @FXML
    private Button buttonconfgSistema;
    
    @FXML
    private Button buttonGestionDep;
    
    @FXML
    private Button buttonGestionUsuarios;
    
    @FXML
    private Button buttonGestionTickets;
    
    @FXML
    private Button buttonGestionRolesPermisos;
    
    @FXML
    private Button buttonGestionEstadoTickets;
    
    @FXML
    private Button buttonGestionFlujos;
    
    

    @FXML
    private void handleConfiguracionSistema(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ConfiguracionDelSistemaVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleGestionPermisosRoles(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PermisosyRolesVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleGestionDepartamentos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionDepartamentosVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML 
    private void handleGestionDeEstadoTickets (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionDeEstadoDeTicketsVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleBotonRegresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InicioSesionVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       @FXML
    private void handleGestionUsuarios(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionDeUsuariosVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       @FXML
    private void handleGestionFlujosDeTrabajo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionDeFlujosDeTrabajoVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
       @FXML
    private void handleGestionDeTickets(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionDeTicketsVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(OpcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}