/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;

public class GestionRolesDAO {

    
    public static boolean guardarRol(GestionRoles rol) {
    Connection conexion = ConexionBD.conectar();
    // Usamos "RETURNING id" para obtener el ID generado por la base de datos.
    String sql = "INSERT INTO tb_roles (nombre) VALUES (?) RETURNING id_rol"; 

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, rol.getNombreRol());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int idRol = rs.getInt("id_rol");
            rol.setId(idRol); // Asignamos el ID al objeto de modelo.
        }
        rs.close();
        ps.close();
        conexion.close();

        return true;
    } catch (SQLException e) {
        System.out.println("Error al guardar el rol: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
 
    
    public static ObservableList<GestionRoles> obtenerRoles() {
    ObservableList<GestionRoles> lista = FXCollections.observableArrayList();
    Connection conexion = ConexionBD.conectar();
    String sql = "SELECT nombre FROM tb_roles";

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            // Usamos el constructor con id y nombre
            lista.add(new GestionRoles(rs.getString("nombre")));
        }

        rs.close();
        ps.close();
        conexion.close();
    } catch (SQLException e) {
        System.out.println("Error al obtener los roles: " + e.getMessage());
    }

    return lista;
}

    
 public static boolean borrarRol(int idRol) {
    Connection conexion = ConexionBD.conectar();
    String sql = "DELETE FROM tb_roles WHERE id_rol = ?";


    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idRol);
        int filasAfectadas = ps.executeUpdate();
        ps.close();
        conexion.close();
        return filasAfectadas > 0;
    } catch (SQLException e) {
        System.out.println("Error al borrar el rol: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}


    
    /*
    public static ObservableList<GestionRoles> obtenerRoles() {
    ObservableList<GestionRoles> lista = FXCollections.observableArrayList();
    Connection conexion = ConexionBD.conectar();
    String sql = "SELECT nombre FROM tb_roles";

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            lista.add(new GestionRoles(rs.getString("nombre")));
        }

        rs.close();
        ps.close();
        conexion.close();
    } catch (SQLException e) {
        System.out.println("Error al obtener los roles: " + e.getMessage());
    }

    return lista;
} */

    
}

