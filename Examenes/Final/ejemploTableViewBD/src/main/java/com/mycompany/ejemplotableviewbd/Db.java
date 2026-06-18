/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplotableviewbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
            conn.setAutoCommit(false);
            for (Persona p : lista) {
                ps.setString(1, p.getNombre());
                ps.setString(2, p.getApellidos());
                ps.setString(3, p.getEmail());
                ps.setString(4, p.getGenero());
                ps.setString(5, p.getNacimiento().toString()); // LocalDate → TEXT
                ps.setString(6, p.getPais());

                ps.executeUpdate();
                //System.out.println(p);
            }

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static ListaPersonas leerPersonas() {
        ListaPersonas personal = new ListaPersonas();
        ArrayList<Persona> lista = new ArrayList<>();
        String sql = "Select * from persona";

        //try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            //conn.setAutoCommit(false); // TRANSACTION ✅
            //ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String genero = rs.getString("genero");

                LocalDate nacimiento = null;
                String fecha = rs.getString("nacimiento");
                if (fecha != null) {
                    nacimiento = LocalDate.parse(fecha);
                }

                String pais = rs.getString("pais");
                int id = rs.getInt("id");
                Persona p = new Persona(
                        id,
                        nombre,
                        apellidos,
                        email,
                        genero,
                        nacimiento,
                        pais
                );

                personal.addPersona(p);
                //System.out.println(p.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personal;
    }

    public static boolean existeTabla(String nombreTabla) {

        String sql = """
            SELECT name
            FROM sqlite_master
            WHERE type = 'table' AND name = ?
        """;

        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreTabla);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // true si existe
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void actualizarPersona(Persona p) {

        String sql = """
        UPDATE persona
        SET nombre = ?, 
            apellidos = ?, 
            email = ?, 
            genero = ?, 
            nacimiento = ?, 
            pais = ?
        WHERE id = ?
    """;

        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellidos());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getGenero());

            ps.setString(5, p.getNacimiento() != null
                    ? p.getNacimiento().toString()
                    : null);

            ps.setString(6, p.getPais());

            ps.setInt(7, p.getId());

            int filas = ps.executeUpdate();

            // comprobar si se actualizó
            if (filas == 0) {
                System.out.println("No se encontró la persona con id = " + p.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarPersona(Persona p) {

        String sql = """
            INSERT INTO persona
            (nombre, apellidos, email, genero, nacimiento, pais)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // RETURN_GENERATED_KEYS Es necesario para recuperar el id autoincremental

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellidos());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getGenero());

            ps.setString(5, p.getNacimiento() != null
                    ? p.getNacimiento().toString()
                    : null);

            ps.setString(6, p.getPais());

            ps.executeUpdate();

            // Obtener el ID generado automáticamente
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                p.setId(idGenerado); // lo asignas al objeto
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void borrarPersona(int id) {

        String sql = "DELETE FROM persona WHERE id = ?";

        try (Connection conn = conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            // Opcional: comprobar resultado
            if (filas == 0) {
                System.out.println("No se encontró la persona con id = " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
