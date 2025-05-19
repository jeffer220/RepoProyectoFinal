/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConfiguracionSistemaDAO {

    /**
     * Persiste la configuración en la base de datos.
     * Puedes definir aquí si realizarás un INSERT o un UPDATE, según la lógica de tu aplicación.
     */
    public static boolean guardarConfiguracion(ConfiguracionSistema cs) {
        Connection conexion = ConexionBD.conectar();
        // Por simplicidad, usaremos una sentencia INSERT.
        // Si la configuración ya existe, podrías usar UPDATE o hacer una lógica condicional.
        String sql = "INSERT INTO tb_confi_empresa (nombre_empresa, logo_empresa, idioma, zona_horaria) VALUES (?, ?, ?, ?)";
        
        try {
            conexion.setAutoCommit(true);
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cs.getNombreEmpresa());
            ps.setString(2, cs.getRutaLogo());
            ps.setString(3, cs.getIdiomaPredeterminado());
            ps.setString(4, cs.getZonaHoraria());
            
            int filasAfectadas = ps.executeUpdate();
            ps.close();
           // conexion.close();
            
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar configuracion: " + e.getMessage());
           e.printStackTrace(); // Imprime el stack trace completo del error.
            return false;
        }
                   
    }
    
    // Método para obtener la configuración registrada
    public static ConfiguracionSistema obtenerConfiguracion() {
        ConfiguracionSistema cs = null;
        Connection conexion = ConexionBD.conectar();
        String sql = "SELECT nombre_empresa, logo_empresa, idioma, zona_horaria FROM tb_confi_empresa LIMIT 1";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cs = new ConfiguracionSistema();
                cs.setNombreEmpresa(rs.getString("nombre_empresa"));
                cs.setRutaLogo(rs.getString("logo_empresa"));
                cs.setIdiomaPredeterminado(rs.getString("idioma"));
                cs.setZonaHoraria(rs.getString("zona_horaria"));
         
            }
            
            rs.close();
            ps.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener configuración: " + e.getMessage());
            e.printStackTrace();
        }
        
        return cs;
    }
}

