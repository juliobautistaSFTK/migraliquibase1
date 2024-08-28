package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQuery {
    public static void main(String[] args) {
        // Configuración de la base de datos
        String url = "jdbc:mysql://localhost:3308/mibase1"; // Cambia el nombre de la base de datos si es necesario
        String user = "root";
        String password = "Canada";

        // Conexión y consulta a la base de datos
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM medidas2"; // Consulta SQL
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int idd = rs.getInt("idd");
                String tipo = rs.getString("tipo");
                int cantidad = rs.getInt("cantidad");
                System.out.println("ID: " + idd + ", Tipo: " + tipo + ", Cantidad: " + cantidad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

