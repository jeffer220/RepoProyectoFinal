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


public class GestionDepartamentoDAO {

    public static boolean guardarDepartamento(GestionDepartamentos departamento) {
        Connection conexion = ConexionBD.conectar();
        String sql = "INSERT INTO tb_departamento (nombre, descripcion) VALUES (?, ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, departamento.getNombreDepartamento());
            ps.setString(2, departamento.getDescDepartamento());

            int filasAfectadas = ps.executeUpdate();
            ps.close();
            conexion.close();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar el departamento: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    
    public static ObservableList<GestionDepartamentos> obtenerDepartamentos() {
    ObservableList<GestionDepartamentos> lista = FXCollections.observableArrayList();
    Connection conexion = ConexionBD.conectar();
    String sql = "SELECT nombre, descripcion FROM tb_departamento";

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            lista.add(new GestionDepartamentos(rs.getString("nombre"), rs.getString("descripcion")));
        }

        rs.close();
        ps.close();
        conexion.close();
    } catch (SQLException e) {
        System.out.println("Error al obtener los departamentos: " + e.getMessage());
        e.printStackTrace();
    }

    return lista;
}

    
    public static boolean eliminarDepartamento(String nombreDepartamento) {
    Connection conexion = ConexionBD.conectar();
    String sql = "DELETE FROM tb_departamento WHERE nombre = ?";

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, nombreDepartamento);

        int filasAfectadas = ps.executeUpdate();
        ps.close();
        conexion.close();

        return filasAfectadas > 0;  // Retorna true si la eliminación fue exitosa
    } catch (SQLException e) {
        System.out.println("Error al eliminar el departamento: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
    
    
    
}

