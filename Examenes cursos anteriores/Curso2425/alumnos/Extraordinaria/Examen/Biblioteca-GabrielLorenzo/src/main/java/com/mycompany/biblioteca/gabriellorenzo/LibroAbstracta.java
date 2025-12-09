/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.gabriellorenzo;

/**
 *
 * @author gablorber
 */
public abstract class LibroAbstracta implements LibroInterfaz {
    String titulo;
    String autor;
    int publicacion;
    String isbn;
    String portada;
    String contraportada;
    String sinopsis;

    public LibroAbstracta(String titulo, String autor, int publicacion, String isbn, String portada, String contraportada, String sinopsis) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.isbn = isbn;
        this.portada = portada;
        this.contraportada = contraportada;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getContraportada() {
        return contraportada;
    }

    public void setContraportada(String contraportada) {
        this.contraportada = contraportada;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    @Override
    public abstract void mostrarInformacion();
}
    

