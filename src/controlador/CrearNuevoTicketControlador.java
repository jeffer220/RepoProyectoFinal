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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.GestionDepartamentos;
import controlador.GestionDepartamentosControlador;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import modelo.GestionDepartamentoDAO;
import modelo.crearTicketDAO;
/**
 * FXML Controller class
 *
 * @author gp
 */
public class CrearNuevoTicketControlador implements Initializable {
    
    @FXML
    private TextField textTituloTicket;
    @FXML
    private TextField textDescTicket;
    @FXML
    private ComboBox<GestionDepartamentos> comboDepartamentos;
    @FXML
    private ListView listaNivelPrioridadTicket;
    @FXML
    private Button buttonGuadar;
    @FXML
    private Button buttonCancelar;
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<GestionDepartamentos> listaDepartamentos = GestionDepartamentoDAO.obtenerDepartamentos();
        comboDepartamentos.setItems(listaDepartamentos);
        
     
    }
    
    @FXML
public void crearTicket(ActionEvent event) {
    String titulo = textTituloTicket.getText();
    String descripcion = textDescTicket.getText();
    GestionDepartamentos departamentoSeleccionado = comboDepartamentos.getSelectionModel().getSelectedItem();

    if (titulo == null || titulo.isEmpty()) {
        System.out.println("Error: El título no puede estar vacío.");
        return;
    }

    if (descripcion == null || descripcion.isEmpty()) {
        System.out.println("Error: La descripción no puede estar vacía.");
        return;
    }

    if (departamentoSeleccionado == null) {
        System.out.println("Error: Debe seleccionar un departamento.");
        return;
    }

    // Guardar el ticket en la base de datos
    boolean guardado = crearTicketDAO.guardarTicket(titulo, descripcion, departamentoSeleccionado.getNombreDepartamento());

    if (guardado) {
        System.out.println("Ticket creado con éxito.");
    } else {
        System.out.println("Error al crear el ticket.");
    }
}

    
    @FXML
    private void handleBtnCancelar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionDeTicketsVista.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CrearNuevoTicketControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
