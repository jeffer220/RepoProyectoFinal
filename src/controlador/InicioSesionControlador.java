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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class InicioSesionControlador {
    
    
    @FXML
    private PasswordField passwordContraseña;
    @FXML
    private Button buttonContinuar;
    

    @FXML
    private void handleAceptarButton(ActionEvent event) {

        try {
            // Cargar el archivo FXML del menú de opciones
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OpcionesVista.fxml"));
            Parent root = loader.load();

            // Cambiar de escena
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InicioSesionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
