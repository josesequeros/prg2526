/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roberto.biblioteca;

/**
 *
 * @author Roberto
 */
abstract class Libroabrsatcta implements LibroInterfaz {
    
     protected String titulo;
    protected String autor;
    protected int publicacion;
    protected String isbn;
    protected String portada;
    protected String contraportada;

    public Libroabrsatcta(String titulo, String autor, int publicacion, String isbn, String portada, String contraportada) {
        if (publicacion < 1450 || publicacion > 2025) {
            throw new IllegalArgumentException("Año de publicación no válido");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.isbn = isbn;
        this.portada = portada;
        this.contraportada = contraportada;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getFechaPublicacion() { return publicacion; }
    public String getISBN() { return isbn; }

    public abstract void mostrarInformacion();
    
    
    
    
}
