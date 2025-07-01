/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.comicteca;

/**
 *
 * @author jabue
 */
public abstract class ComicAbstracta implements ComicInterfaz {

    protected String titulo;
    protected String autor;
    protected int publicacion;
    protected String isbn;
    protected String portada;
    protected String portadaAlternativa;

    public ComicAbstracta(String titulo, String autor, int publicacion, String isbn, String portada, String portadaAlternativa) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.isbn = isbn;
        this.portada = portada;
        this.portadaAlternativa = portadaAlternativa;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPortada() {
        return portada;
    }

    public String getPortadaAlternativa() {
        return portadaAlternativa;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getFechaPublicacion() {
        return publicacion;
    }

    public String getISBN() {
        return isbn;
    }

    public abstract void mostrarInformacion();
}
