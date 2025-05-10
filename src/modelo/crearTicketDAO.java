/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gp
 */
public class crearTicketDAO {
    public static boolean guardarTicket(String titulo, String descripcion, String nombreDepartamento) {
    Connection conexion = ConexionBD.conectar();
    String sql = "INSERT INTO tb_tickets (titulo, descripcion, id_departamento) VALUES (?, ?, ?)";

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, titulo);
        ps.setString(2, descripcion);
        ps.setString(3, nombreDepartamento);

        int filasAfectadas = ps.executeUpdate();
        ps.close();
        conexion.close();

        return filasAfectadas > 0;
    } catch (SQLException e) {
        System.out.println("Error al guardar el ticket: " + e.getMessage());
        return false;
    }
}

}
