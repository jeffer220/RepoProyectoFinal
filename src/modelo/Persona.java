/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gp
 */
public class Persona {
   private String nombreCompleto;
   private String correoElectronico;
   private String nombreUsuario;
   private String contraseña;
   

    public Persona(String nombreCompleto, String correoElectronico, String nombreUsuario, String contraseña) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    
       
    }
    
    public Persona (){}

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

           @Override
    public String toString() {
        return nombreCompleto + " - " + correoElectronico + " - " + nombreUsuario + " - " + contraseña; // Esto mostrará el nombre y descripción en el ListView
    }
}
