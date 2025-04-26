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
import modelo.GestionPermisos;

/**
 * FXML Controller class
 *
 * @author gp
 */
public class GestionDePermisosControlador implements Initializable {
    
    
    @FXML
    private Button buttonRegresar;
     @FXML
    private TextField textNombrePermiso;
    @FXML
    private TextField textDescPermiso;
    @FXML
    private Label labelError;
    @FXML
    private Button buttonGuardar;
    @FXML
    private Button buttonCrearPermiso;
    @FXML
    private ListView listaPermisosExistentes;
    
    
    private static ObservableList<GestionPermisos> listaPermisos;
    
    
         @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (listaPermisos == null) { // Si la lista es null, inicializarla
        listaPermisos = FXCollections.observableArrayList();
    }
       
       if (listaPermisos.isEmpty()) { listaPermisos.addAll(
        new GestionPermisos("Crear tickets", "Permiso para crear nuevos tickets"),
        new GestionPermisos("Ver tickets", "Permiso para visualizar tickets"),
        new GestionPermisos("Editar tickets", "Permiso para modificar detalles de tickets"),
        new GestionPermisos("Eliminar tickets", "Permiso para borrar tickets"),
        new GestionPermisos("Asignar tickets", "Permiso para asignar tickets a usuarios"),
        new GestionPermisos("Cambiar estado de tickets", "Permiso para modificar el estado de tickets"),
        new GestionPermisos("Agregar notas a tickets", "Permiso para incluir comentarios en tickets"),
        new GestionPermisos("Gestionar usuarios", "Permiso para administrar cuentas de usuario"),
        new GestionPermisos("Gestionar departamentos", "Permiso para organizar departamentos"),
        new GestionPermisos("Gestionar flujos de trabajo", "Permiso para configurar flujos de trabajo"),
        new GestionPermisos("Configurar parámetros del sistema", "Permiso para ajustar configuraciones")
    );
       }
       listaPermisosExistentes.setItems(listaPermisos); // Vincular la lista con el ListView
    }
    
     // Método público para acceder a la lista desde otro controlador
    public static ObservableList<GestionPermisos> getListaPermisos() {
        return listaPermisos;
    }  
    
    @FXML
    public void CrearPermiso(ActionEvent event){
        String nombrePermiso = textNombrePermiso.getText();
        String descripcionPermiso = textDescPermiso.getText();
        
        if (nombrePermiso == null || nombrePermiso.isEmpty() || nombrePermiso.length() < 3 || nombrePermiso.length() > 50) {
        labelError.setText(" aaah Error");
        return;
    }   
        GestionPermisos permiso1 = new GestionPermisos(nombrePermiso, descripcionPermiso);
        listaPermisos.add(permiso1);
        listaPermisosExistentes.setItems(listaPermisos); // Actualizar la vista

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
            Logger.getLogger(GestionDePermisosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
}

  
