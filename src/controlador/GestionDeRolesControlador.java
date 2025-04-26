/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import controlador.GestionDePermisosControlador;
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
import modelo.GestionPermisos;
import modelo.GestionRoles;

/**
 * FXML Controller class
 *
 * @author gp
 */
public class GestionDeRolesControlador implements Initializable {
    
    

    @FXML
    private ListView listRolesExistentes;
    @FXML
    private Button buttonModRol;
    @FXML
    private Button buttonEliminarRol;
    @FXML
    private ListView listPermisosExistentes;
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonCancelar;
    
    @FXML
    private TextField textNombreRol;
    @FXML
    private Button buttonCrearRol;
    @FXML
    private Label labelError;
    
    private ObservableList<GestionRoles> listaRoles;
   
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (listaRoles == null) {
        listaRoles = FXCollections.observableArrayList();
        }
        
        if (listaRoles.isEmpty()){ listaRoles.addAll(
        new GestionRoles("Administrador"),
        new GestionRoles("Tecnico"),
        new GestionRoles("Usuario")
        );     
    }
        listRolesExistentes.setItems(listaRoles);
       
        
        
        
        GestionDePermisosControlador.getListaPermisos();
        ObservableList<GestionPermisos> permisos = GestionDePermisosControlador.getListaPermisos();
        if (permisos == null || permisos.isEmpty()) {
            System.out.println("Error: La lista de permisos está vacía o no inicializada.");
            return;
        }
        listPermisosExistentes.setItems(permisos); // Vincular permisos con la nueva ListView 
    }
     
    
    public void CrearRol(ActionEvent event){
        String nombreRol = textNombreRol.getText();
        if (nombreRol == null || nombreRol.isEmpty() || nombreRol.length() < 3 || nombreRol.length() > 50 ){
        labelError.setText("Error ingrese un nuevo nombre");
        }
        GestionRoles rol = new GestionRoles(nombreRol);
        listaRoles.add(rol);
        listRolesExistentes.setItems(listaRoles);
    }
    
    
    
        @FXML
    private void handlebtnRegresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PermisosyRolesVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionDeRolesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
            @FXML
    private void handleBTNModificarRol(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ModificarRolVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionDeRolesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        @FXML
    private void handleBTNEliminarRol(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EliminarRolVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionDeRolesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    
}
