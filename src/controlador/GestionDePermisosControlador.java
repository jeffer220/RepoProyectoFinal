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
    private ListView listaPermisosExistentes;
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
    
    
    private static ObservableList<GestionPermisos> listaPermisos;
    
    
         @Override
    public void initialize(URL url, ResourceBundle rb) {
       listaPermisos = FXCollections.observableArrayList();
       
        listaPermisos.addAll(
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
       listaPermisosExistentes.setItems(listaPermisos); // Vincular la lista con el ListView
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

    public static ObservableList<GestionPermisos> getListaPermisos() {
        return listaPermisos;
    }
    
    
   
    
    
    /*
    
    private void permisosExistentes() {
    String[] permisos2 = {
        "Crear tickets", "Ver tickets", "Editar tickets", "Eliminar tickets",
        "Asignar tickets", "Cambiar estado de tickets", "Agregar notas a tickets",
        "Gestionar usuarios", "Gestionar departamentos", "Gestionar flujos de trabajo",
        "Configurar parámetros del sistema"
    };

    listaPermisosExistentes.getItems().addAll(permisos2);
}    
       
     @FXML
    public void asignarPermisos() {
        // Obtener los permisos seleccionados
        var seleccionados = listaPermisosExistentes.getSelectionModel().getSelectedItems();
        
        System.out.println("Permisos asignados: " + seleccionados);
        // Aquí puedes guardar estos permisos en el modelo de datos o base de datos
    }
    */
    
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
    
    
    
    
   /* @FXML
    public void ingresarNombrePermiso(){
        String nombrePermiso = textNombrePermiso.getText() ;
        
    if (nombrePermiso == null || nombrePermiso.isEmpty()) {
        labelError.setText("Error: El nombre del permisono puede estar vacio.");
        return;
    } 
    if (nombrePermiso.length() < 3 || nombrePermiso.length() > 50) {
        labelError.setText("Error: El nombre del permiso debe tener entre 3 y 50caracteres");
        return;
    } 
        gestionPermiso.setNombrePermiso(nombrePermiso);
        textNombrePermiso.setText(nombrePermiso);
    }
    */
}

  
