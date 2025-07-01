/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.testbiblioteca;

/**
 *
 * @author jabue
 */
public interface LibroInterfaz {

    String getTitulo();

    String getAutor();

    int getAnioPublicacion();

    String getISBN();

    void mostrarInformacion();
}
