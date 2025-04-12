/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gp
 */
public class GestionDepartamentos {
    private String nombreDepartamento;
    private String descDepartamento;

    public GestionDepartamentos(String nombreDepartamento, String descDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
        this.descDepartamento = descDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getDescDepartamento() {
        return descDepartamento;
    }

    public void setDescDepartamento(String descDepartamento) {
        this.descDepartamento = descDepartamento;
    }
    
        @Override
    public String toString() {
        return nombreDepartamento + " - " + descDepartamento; // Esto mostrará el nombre y descripción en el ListView
    }
}
