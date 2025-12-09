/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roberto.biblioteca;

import java.util.*;
/**
 *
 * @author Roberto
 */
public class BibliotecaGestion {
     private List<Libroabrsatcta> coleccion;

    public BibliotecaGestion() {
        this.coleccion = new ArrayList<>();
    }

    public void addLibro(Libroabrsatcta libro) {
        coleccion.add(libro);
    }
    
    public boolean borrarLibro(String isbn) {
        return coleccion.removeIf(libro -> libro.getISBN().equals(isbn));
    }

    public Libroabrsatcta buscarLibroISBN(String isbn) {
        for (Libroabrsatcta libro : coleccion) {
            if (libro.getISBN().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }
    
    
    public BibliotecaGestion buscarComicTitulo(String titulo) {
        BibliotecaGestion resultado = new BibliotecaGestion();
        for (Libroabrsatcta libro : coleccion) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.addLibro(libro);
            }
        }
        return resultado;
    }

    public void mostrarBiblioteca() {
        if (coleccion.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
        } else {
            for (Libroabrsatcta libro : coleccion) {
                libro.mostrarInformacion();
                System.out.println();
            }
        }
    }
}
