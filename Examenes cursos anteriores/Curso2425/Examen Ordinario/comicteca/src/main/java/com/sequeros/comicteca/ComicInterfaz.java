/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.comicteca;

/**
 *
 * @author jabue
 */
public interface ComicInterfaz {

    String getTitulo();

    String getAutor();

    int getFechaPublicacion();

    String getISBN();

    void mostrarInformacion();
}
