/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.roberto.biblioteca;

/**
 *
 * @author Roberto
 */
public class LibroNoFiccion extends Libroabrsatcta {
    String tema;
  public LibroNoFiccion(String titulo, String autor, int publicacion, String isbn, String portada, String contraportada, String tema) {
        super(titulo, autor, publicacion, isbn, portada, contraportada);
    }
    @Override
    public void mostrarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAnioPublicacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
