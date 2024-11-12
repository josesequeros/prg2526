/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.bibliotecalistview;

/**
 *
 * @author jabue
 */
public class LibroFiccion extends LibroAbstracta {

    private String genero;

    public LibroFiccion(String titulo, String autor, int fechaPublicacion, String isbn, String portada, String genero) {
        super(titulo, autor, fechaPublicacion, isbn, portada);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public void mostrarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
