/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.testbiblioteca;

/**
 *
 * @author jabue
 */
public abstract class LibroAbstracta implements LibroInterfaz {

    protected String titulo;
    protected String autor;
    protected int publicacion;
    protected String isbn;
    protected String portada;
    protected String contraportada;
    protected String sinopsis;

    public LibroAbstracta(String titulo, String autor, int publicacion, String isbn, String portada, String contraportada, String sinopsis) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.isbn = isbn;
        this.portada = portada;
        this.contraportada = contraportada;
        this.sinopsis = sinopsis;
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

    public String getContraportada() {
        return contraportada;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return publicacion;
    }

    public String getISBN() {
        return isbn;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public abstract void mostrarInformacion();
}
