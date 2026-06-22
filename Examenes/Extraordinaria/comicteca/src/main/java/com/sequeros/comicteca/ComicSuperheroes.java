/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.comicteca;

/**
 *
 * @author jabue
 */
public class ComicSuperheroes extends ComicAbstracta{
    private String universo;

    public ComicSuperheroes(String titulo, String autor, int publicacion, String isbn, String portada, String portadaAlternativa, String universo) {
        super(titulo, autor, publicacion, isbn, portada, portadaAlternativa);
        this.universo = universo;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("📘 Comic de Superhéroes:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + publicacion);
        System.out.println("ISBN: " + isbn);
        System.out.println("Portada: " + portada);
        System.out.println("Trasera: " + portadaAlternativa);
        System.out.println("Universo: " + universo);
    }    

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }
    
}
