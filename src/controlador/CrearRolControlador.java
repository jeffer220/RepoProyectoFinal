/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.awt.Button;
import java.awt.TextField;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gp
 */
public class CrearRolControlador implements Initializable {
    
    @FXML
    private TextField textNombreRol;
    @FXML
    private TextField textDecRol;
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonCancelar;
    
    
    @FXML
    private void handleBotonCancelar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PermisosyRolesVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CrearRolControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
