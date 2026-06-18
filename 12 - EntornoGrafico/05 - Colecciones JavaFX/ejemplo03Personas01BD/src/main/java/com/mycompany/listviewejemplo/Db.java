/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listviewejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ja.buenoseva
 */
public class Db {

    private static final String URL = "jdbc:sqlite:personas.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void crearTablaSiNoExiste() {

        String sql = """
            CREATE TABLE IF NOT EXISTS persona (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT,
                apellidos TEXT,
                email TEXT,
                genero TEXT,
                nacimiento TEXT,
                pais TEXT
            );
        """;

        try (Connection conn = conectar(); Statement st = conn.createStatement()) {

            st.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void guardarPersonas(ArrayList<Persona> lista) {

        String sql = """
            INSERT INTO persona
            (nombre, apellidos, email, genero, nacimiento, pais)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false); // TRANSACTION ✅

            for (Persona p : lista) {
                ps.setString(1, p.getNombre());
                ps.setString(2, p.getApellidos());
                ps.setString(3, p.getEmail());
                ps.setString(4, p.getGenero());
                ps.setString(5, p.getNacimiento().toString()); // LocalDate → TEXT
                ps.setString(6, p.getPais());

                ps.executeUpdate();
            }

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
