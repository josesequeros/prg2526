/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roberto.biblioteca;

/**
 *
 * @author Roberto
 */
public class LibroFiccion extends Libroabrsatcta {
    
    String genero;

    public LibroFiccion(String titulo, String autor, int publicacion, String isbn, String portada, String contraportada, String genero) {
        super(titulo, autor, publicacion, isbn, portada, contraportada);
    }

    @Override
    public void mostrarInformacion() {
 System.out.println("LibroFiccion:");
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn);
        System.out.println("Portada: " + portada + ", Contraportada: " + contraportada + ", genero " + genero );    }

    @Override
    public int getAnioPublicacion() {
        System.out.println( " Año: " + publicacion );
        return 0;

    }

   
    
    
    
}
