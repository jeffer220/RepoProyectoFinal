/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gp
 */
public class Tecnico extends Persona {
    private String departamento;
    
    public Tecnico(String nombreCompleto, String correoElectronico, String nombreUsuario, String contraseña, String rolAsignado, String departamento) {
        super(nombreCompleto, correoElectronico, nombreUsuario, contraseña, rolAsignado);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
 
    
}
