/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    // URL de conexión original con puerto, base de datos y parámetro sslmode
    private String url = "jdbc:postgresql://ep-plain-scene-a4jbvjto-pooler.us-east-1.aws.neon.tech/bd_proyectoProgramacion";
    //jdbc:postgresql://ep-plain-scene-a4jbvjto-pooler.us-east-1.aws.neon.tech:5432/bd_proyectoProgramacion?sslmode=require
    private Properties properties = new Properties();
    private static Connection conn = null;
    
    // Constructor privado para implementar el patrón Singleton
    private ConexionBD() {
        properties.setProperty("user", "neondb_owner");
        properties.setProperty("password", "npg_9OM2VHoIZkpF");
        
        try {
            
            conn = DriverManager.getConnection(url, properties);
            System.out.println("Conexión exitosa a PostgreSQL.");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método estático que retorna la conexión única
    public static Connection conectar() {
        if (conn == null) {
            ConexionBD conexion = new ConexionBD();
            return conexion.conn;
        }
        else{ return conn;}
    }
}



/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
*/