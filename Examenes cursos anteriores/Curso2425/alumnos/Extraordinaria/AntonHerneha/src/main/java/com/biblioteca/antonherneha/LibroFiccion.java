/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.antonherneha;

/**
 *
 * @author anton
 */
public class LibroFiccion {

    
    private String titulo;
    private String autor;
    private int anyo;
    private String editorial;

   
    
    
    public LibroFiccion(String titulo, String autor, int anio, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anio;
        this.editorial = editorial;
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

    public int getAnio() {
        return anyo;
    }

    public void setAnio(int anio) {
        this.anyo = anio;
    }

    
    
    public String getEditorial() {
        return editorial;
    }
    
    

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    
    
    
    @Override
    public String toString() {
        return titulo + " (" + anyo + ")";
    }

    
    
 
    public static LibroFiccion fromArchivo  (String linea) {
        String[] partes = linea.split(";");
        String titulo = partes[0];
        String autor = partes[1];
        int anio = Integer.parseInt(partes[2]);
        String editorial = partes[3];
        return new LibroFiccion(titulo, autor, anio, editorial);
    }

   
    
    
    public String aTexto() {
        return titulo + ";" + autor + ";" + anyo + ";" + editorial;
    }
}

