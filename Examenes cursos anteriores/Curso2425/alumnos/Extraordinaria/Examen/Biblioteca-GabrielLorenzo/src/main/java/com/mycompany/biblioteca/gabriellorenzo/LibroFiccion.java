/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.gabriellorenzo;

/**
 *
 * @author gablorber
 */
public class LibroFiccion extends LibroAbstracta {
 private String genero;

    public LibroFiccion(String titulo, String autor, int publicacion, String isbn, String portada, String contraportada, String sinopsis, String genero) {
        super(titulo, autor, publicacion, isbn, portada, contraportada, sinopsis);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
    public int getAnioPublicacion() {
        return publicacion;
    }

    @Override
    public String getISBN() {
        return isbn;
    }

     @Override
    public void mostrarInformacion() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getPublicacion());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Portada: " + getPortada());
        System.out.println("Contraportada: " + getContraportada());
        System.out.println("Genero: " + genero);
    }
@Override
public String toString() {
    return getTitulo() + " - " + getAutor() + " (" + getPublicacion() + ")";
}
    
}
