package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQuery {
    public static void main(String[] args) {
        // Leer la variable de entorno para el puerto de la base de datos
        String port = System.getenv("DB_PORT");
        if (port == null) {
            port = "3306"; // Puerto por defecto si la variable no está definida
        }

        // Configuración de la base de datos
        String url = "jdbc:mysql://localhost:" + port + "/mibase1"; // Usa el puerto dinámico
        String user = "root";
        String password = "Canada";

        // Conexión y consulta a la base de datos
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM medidas2"; // Consulta SQL
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Versión 1.1");
            while (rs.next()) {
                int idd = rs.getInt("idd");
                String tipo = rs.getString("tipo");
                int cantidad = rs.getInt("cantidad");
                String t_cambio = rs.getString("tipo_cambio");
                System.out.println("ID: " + idd + ", Tipo: " + tipo + ", Cantidad: " + cantidad + ", Tipo cambio: " + t_cambio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
