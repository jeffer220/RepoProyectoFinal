/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author gp
 */
public class GestionRoles {
    private String nombreRol;
    private int id;

    public GestionRoles(){}
    
    public GestionRoles(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
        @Override
    public String toString() {
        return nombreRol; // Esto mostrará el nombre y descripción en el ListView
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
