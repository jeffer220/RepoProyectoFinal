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
import modelo.GestionRolesDAO;

/**
 * FXML Controller class
 *
 * @author gp
 */
public class GestionDeRolesControlador implements Initializable {
    
    

    @FXML
    private ListView<GestionRoles> listRolesExistentes;
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
        listRolesExistentes.setItems(listaRoles);
       
    // Recupera la lista de roles que ya están guardados en la BD.
    listaRoles = GestionRolesDAO.obtenerRoles();
    listRolesExistentes.setItems(listaRoles);
        
        //Visualizar elemtos de la lista de permisos creada
        GestionDePermisosControlador.getListaPermisos();
        ObservableList<GestionPermisos> permisos = GestionDePermisosControlador.getListaPermisos();
        if (permisos == null || permisos.isEmpty()) {
            System.out.println("Error: La lista de permisos está vacía o no inicializada.");
            return;
        }
        listPermisosExistentes.setItems(permisos); // Vincular permisos con la nueva ListView 
    }
    
    
    @FXML
public void CrearRol(ActionEvent event) {
    String nombreRol = textNombreRol.getText();

    if (nombreRol == null || nombreRol.isEmpty() || nombreRol.length() < 3 || nombreRol.length() > 50) {
        labelError.setText("Error: Ingrese un nombre válido.");
        return;
    }

    // Creamos un nuevo rol
    GestionRoles nuevoRol = new GestionRoles(nombreRol);

    // Guardamos el rol en la base de datos
    boolean guardado = GestionRolesDAO.guardarRol(nuevoRol);

    if (guardado) {
        // Se asignó el ID en el método guardarRol().
        listaRoles.add(nuevoRol); // Se agrega a la lista en memoria
        listRolesExistentes.setItems(listaRoles);
        labelError.setText("Rol guardado correctamente.");
    } else {
        labelError.setText("Error al guardar el rol en la base de datos.");
    }
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
public void handleBTNEliminarRol(ActionEvent event) {
    // Se obtiene el rol seleccionado en la interfaz
    GestionRoles rolSeleccionado = listRolesExistentes.getSelectionModel().getSelectedItem();
    
    if (rolSeleccionado == null) {
        labelError.setText("Seleccione un rol para borrar.");
        return;
    }
    
    // Llamamos al método del DAO pasándole el ID del rol seleccionado
    boolean borrado = GestionRolesDAO.borrarRol(rolSeleccionado.getId());
    
    if (borrado) {
        // Si se borró en la BD, también se quita de la lista en memoria y se actualiza el ListView
        listaRoles.remove(rolSeleccionado);
        listRolesExistentes.setItems(listaRoles);
        labelError.setText("Rol borrado correctamente.");
    } else {
        labelError.setText("Error al borrar el rol en la base de datos.");
    }
}
       
    
}
