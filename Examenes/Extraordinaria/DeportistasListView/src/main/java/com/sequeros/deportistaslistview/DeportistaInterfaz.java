/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sequeros.deportistaslistview;

/**
 *
 * @author jabue
 */
public interface DeportistaInterfaz {
    String getNombre();
    int getEdad();
    String getDeporte();
    Club getClub();
    String getImagen();
    int calcularSalarioMensual();
}
