/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.gabriellorenzo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gablorber
 */
public class Biblioteca {

    private List<LibroAbstracta> listaLibros;

    public Biblioteca() {
        listaLibros = new ArrayList<>();
    }

    public void addLibro(LibroAbstracta libro) {
        listaLibros.add(libro);
    }

    public boolean borrarLibro(String isbn) {
        return listaLibros.removeIf(c -> c.getISBN().equals(isbn));
    }

    public Biblioteca buscarLibroTitulo(String titulo) {
        Biblioteca resultado = new Biblioteca();
        for (LibroAbstracta l : listaLibros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.addLibro(l);
            }
        }
        return resultado;

    }

    public LibroAbstracta buscarLibroISBN(String isbn) {
        for (LibroAbstracta l : listaLibros) {
            if (l.getISBN().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public void mostrarBiblioteca() {
        for (LibroAbstracta l : listaLibros) {
            l.mostrarInformacion();
            System.out.println("--------");
        }
    }

    //Getter para acceder a la lista desde JavaFX
    public List<LibroAbstracta> getListaLibros() {
        return listaLibros;
    }

    public void leerLibros(String fichero) throws IOException {
    listaLibros.clear();  
    try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(";");
            if (partes.length >= 8) {
                String genero = partes[0];
                String titulo = partes[1];
                String autor = partes[2];
                int publicacion = Integer.parseInt(partes[3]);
                String isbn = partes[4];
                String portada = partes[5];
                String contraportada = partes[6];
                String sinopsis = partes[7];

                LibroFiccion libro = new LibroFiccion(
                    genero, titulo, publicacion, autor, isbn, portada, contraportada, sinopsis
                );
                listaLibros.add(libro);
            } else {
                System.err.println("Línea mal formateada: " + linea);
            }
        }
    }
}

   public void guardarLibros(String fichero) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(fichero))) {
        for (LibroAbstracta l : listaLibros) {
            if (l instanceof LibroFiccion) {
                LibroFiccion lf = (LibroFiccion) l;
                pw.println(lf.getTitulo() + ";" + lf.getAutor() + ";" + lf.getPublicacion() + ";" +
                           lf.getISBN() + ";" + lf.getPortada() + ";" + lf.getContraportada() + ";" +
                           lf.getGenero());
            }
        }
        System.out.println("Archivo guardado correctamente.");
    } catch (IOException e) {
        System.out.println("Error al guardar: " + e.getMessage());
    }
}
}
