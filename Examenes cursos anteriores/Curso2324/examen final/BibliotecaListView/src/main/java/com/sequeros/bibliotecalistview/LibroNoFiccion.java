/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.bibliotecalistview;

/**
 *
 * @author jabue
 */
public class LibroNoFiccion extends LibroAbstracta {
    private String tema;

    public LibroNoFiccion(String titulo, String autor, int fechaPublicacion, String isbn, String portada, String tema) {
        super(titulo, autor, fechaPublicacion, isbn, portada);
        this.tema = tema;
    }

    @Override
    public void mostrarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getTema() {
        return tema;
    }
    
    
    
}
