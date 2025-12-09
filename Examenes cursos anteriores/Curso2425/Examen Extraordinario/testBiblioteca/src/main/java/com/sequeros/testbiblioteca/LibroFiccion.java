/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.testbiblioteca;

/**
 *
 * @author jabue
 */
public class LibroFiccion extends LibroAbstracta{
    private String genero;

    public LibroFiccion(String titulo, String autor, int publicacion, String isbn, String portada, String portadaAlternativa, String genero, String sinopsis) {
        super(titulo, autor, publicacion, isbn, portada, portadaAlternativa, sinopsis);
        this.genero = genero;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("📘 Libro de Ficción:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + publicacion);
        System.out.println("ISBN: " + isbn);
        System.out.println("Portada: " + portada);
        System.out.println("Contraportada: " + contraportada);
        System.out.println("Género: " + genero);
        System.out.println("Sinopsis" + sinopsis);
    }    

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
