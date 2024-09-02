package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQuery {
    public static void main(String[] args) {
        String dbPort = "3306"; // Valor predeterminado
        if (args.length > 0) {
            dbPort = args[0];
        }
        // Configuración de la base de datos
        String url = "jdbc:mysql://localhost:" + dbPort + "/mibase1"; // Usa el puerto proporcionado
        String user = "root";
        String password = "Canada";
        System.out.println("Puerto: " + dbPort);

        // Conexión y consulta a la base de datos
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM medidas2"; // Consulta SQL
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Versión 1.0");
            while (rs.next()) {
                int idd = rs.getInt("idd");
                String tipo = rs.getString("tipo");
                int cantidad = rs.getInt("cantidad");
                //String t_cambio = rs.getString("tipo_cambio");
                System.out.println("ID: " + idd + ", Tipo: " + tipo + ", Cantidad: " + cantidad );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
