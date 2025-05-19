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

public class GestionPermisosDAO {

    public static boolean guardarPermiso(GestionPermisos permiso) {
        Connection conexion = ConexionBD.conectar();
        String sql = "INSERT INTO tb_permisos (nombre, descripcion) VALUES (?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, permiso.getNombrePermiso());
            ps.setString(2, permiso.getDescripcionPermiso());

            int filasAfectadas = ps.executeUpdate();
            ps.close();
            conexion.close();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar el permiso: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public static ObservableList<GestionPermisos> obtenerPermisos() {
    ObservableList<GestionPermisos> lista = FXCollections.observableArrayList();
    Connection conexion = ConexionBD.conectar();
    String sql = "SELECT nombre, descripcion FROM tb_permisos";

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            lista.add(new GestionPermisos(rs.getString("nombre"), rs.getString("descripcion")));
        }

        rs.close();
        ps.close();
        //conexion.close();
    } catch (SQLException e) {
        System.out.println("Error al obtener los permisos: " + e.getMessage());
    }

    return lista;
}

}

