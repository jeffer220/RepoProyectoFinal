/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gp
 */
public class GestionPermisos {
    
    private String nombrePermiso;
    private String descripcionPermiso;

    public GestionPermisos(String nombrePermiso, String descripcionPermiso) {
        this.nombrePermiso = nombrePermiso;
        this.descripcionPermiso = descripcionPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }
    
    @Override
    public String toString() {
        return nombrePermiso + " - " + descripcionPermiso; // Esto mostrará el nombre y descripción en el ListView
    }
    
}
