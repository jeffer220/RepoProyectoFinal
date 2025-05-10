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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author gp
 */
public class RegistrarNuevoUsuarioControlador implements Initializable {
    
    @FXML
    private TextField textNombreCompleto;
    @FXML
    private TextField textCorreo;
    @FXML
    private TextField textNombreUsuario;
    @FXML
    private TextField textContraseña;
    @FXML
    private ComboBox ComboRoles;
    @FXML
    private TextField textDepartamento;
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonCrearUsuario;
    @FXML
    private ListView listaUsuarios;
    
    private static ObservableList<Usuario> usuarios;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarios = FXCollections.observableArrayList();
        listaUsuarios.setItems(usuarios);
    }
    
    
    @FXML
    public void crearUsuarios (ActionEvent event){
        String nombreCompleto = textNombreCompleto.getText(); 
        String correoElectronico = textCorreo.getText();
        String nombreUsuario = textNombreUsuario.getText();
        String contraseña = textContraseña.getText();
        
        if (nombreCompleto == null || nombreCompleto.isEmpty()){
            System.out.println("Error ingrese un nombre");
        }
        
         Usuario usua = new Usuario(nombreCompleto, correoElectronico, nombreUsuario, contraseña);
        usuarios.add(usua);
        listaUsuarios.setItems(usuarios); // Actualizar la vista
    }      
    
    @FXML
    private void handleBtnRegresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionDeUsuariosVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RegistrarNuevoUsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

}