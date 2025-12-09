/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.antonherneha;

/**
 *
 * @author ryden
 */


import java.io.*;
import java.util.ArrayList;

public class Biblioteca {

    public static ArrayList<LibroFiccion> leerLibros(String nombre) {
        ArrayList<LibroFiccion> libros = new ArrayList<LibroFiccion>();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombre));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";");
                String titulo = partes[0];
                String autor = partes[1];
                int año = Integer.parseInt(partes[2]);
                String editorial = partes[3];
                LibroFiccion libro = new LibroFiccion(titulo, autor, año, editorial);
                libros.add(libro);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará al guardar.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        return libros;
    }

    public static void guardarLibros(String nombre, ArrayList<LibroFiccion> libros) {
        try {
            PrintWriter escritor = new PrintWriter(nombre);
            for (LibroFiccion libro : libros) {
                escritor.println(libro.titulo + ";" + libro.autor + ";" + libro.anyo + ";" + libro.editorial);
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al guardar.");
        }
    }
}
