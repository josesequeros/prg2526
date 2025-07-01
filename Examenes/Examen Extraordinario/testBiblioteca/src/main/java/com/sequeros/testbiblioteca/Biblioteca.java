/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.testbiblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Biblioteca {

    private ArrayList<LibroFiccion> biblioteca;

    public Biblioteca() {
        biblioteca = new ArrayList<>();
    }

    public ArrayList<LibroFiccion> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(ArrayList<LibroFiccion> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void setComics(ArrayList<LibroFiccion> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void addComic(LibroFiccion libro) {
        biblioteca.add(libro);
    }

    public void borrarComic(String isbn) {
        biblioteca.removeIf(c -> c.getISBN().equals(isbn));
    }

    public Biblioteca buscarComic(String titulo) {
        //ArrayList<LibroFiccion> aux = new ArrayList<LibroFiccion>();
        Biblioteca aux = new Biblioteca();
        for (LibroFiccion c : biblioteca) {
            System.out.println(c.getTitulo() + " -> " + titulo);
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                //return c;
                System.out.println(c);
                aux.addComic(c);
                System.out.println(aux.getBiblioteca().size());
            }
        }
        //biblioteca = (Biblioteca) aux;
        return aux;
    }

    public void mostrarComicteca() {
        if (biblioteca.isEmpty()) {
            System.out.println("La comicteca está vacía.");
            return;
        }
        for (LibroFiccion c : biblioteca) {
            c.mostrarInformacion();
            System.out.println("----------------------");
        }
    }

    public void leerBiblioteca(String nomFich) {
        //ArrayList<ComicAbstracta> comics = new ArrayList<>();
        // Declarando el Scanner en el try tenemos el cierre automático del mismo
        try (Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US)) {
            while (f.hasNext()) {
                String linea = f.nextLine();
                String[] partes = linea.split(",");
                String titulo = partes[0];
                String autor = partes[1];
                int publicacion = Integer.valueOf(partes[2]);
                String isbn = partes[3];
                String portada = partes[4];
                String portadaAlternativa = partes[5];
                String genero = partes[6];
                String sinopsis = partes[7];
                LibroFiccion libro;

                libro = new LibroFiccion(titulo, autor, publicacion, isbn, portada, portadaAlternativa, genero, sinopsis);

                biblioteca.add(libro);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error leyendo datos");
            System.out.println(ex.getMessage());
        }
    }

    public void grabarBiblioteca(String archivo) {
        ArrayList<LibroFiccion> lista;// = new ArrayList<>();
        lista = this.biblioteca;
        try {
            // Intentamos abrir el fichero
            File f = new File(archivo);
            FileWriter fw = new FileWriter(f);
            for (LibroFiccion libro : lista) {
                fw.write(libro.getTitulo());
                fw.write(",");
                fw.write(libro.getAutor());
                fw.write(",");
                fw.write(libro.getPublicacion() + "");
                fw.write(",");
                fw.write(libro.getISBN());
                fw.write(",");
                fw.write(libro.getPortada());
                fw.write(",");
                fw.write(libro.getContraportada());
                fw.write(",");
                fw.write(libro.getGenero());
                fw.write(",");                
                fw.write(libro.getSinopsis());
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
        }
    }
}
