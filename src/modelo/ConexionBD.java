/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
public class ConexionBD {
    private static final String URL = "jdbc:postgresql://ep-plain-scene-a4jbvjto-pooler.us-east-1.aws.neon.tech:5432/bd_proyectoProgramacion?sslmode=require";
    private static final String USUARIO = "neondb_owner";
    private static final String PASSWORD = "npg_9OM2VHoIZkpF";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");  // Cargar el driver JDBC
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexion exitosa a PostgreSQL.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return conexion;
    }
}*/