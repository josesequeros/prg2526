/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.comicteca;

/**
 *
 * @author jabue
 */
public class ComicEuropeo extends ComicAbstracta {

    private String editorial;

    public ComicEuropeo(String titulo, String autor, int publicacion, String isbn, String portada, String portadaAlternativa, String editorial) {
        super(titulo, autor, publicacion, isbn, portada, portadaAlternativa);
        this.editorial = editorial;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("📗 Comic Manga:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + publicacion);
        System.out.println("ISBN: " + isbn);
        System.out.println("Portada: " + portada);
        System.out.println("Trasera: " + portadaAlternativa);
        System.out.println("Editorial: " + editorial);
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    
}
