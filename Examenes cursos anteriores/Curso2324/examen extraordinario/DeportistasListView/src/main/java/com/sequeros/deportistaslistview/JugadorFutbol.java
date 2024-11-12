/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.deportistaslistview;

/**
 *
 * @author carme
 */
public class JugadorFutbol extends DeportistaBaseAbstracta {

    private int golesMarcados;

    public JugadorFutbol(String nombre, int edad, String deporte, Club club, String imagen, int golesMarcados) {
        super(nombre, edad, deporte, club, imagen);
        this.golesMarcados = golesMarcados;
    }

    @Override
    public int calcularSalarioMensual() {
        int tarifaBase = 3000;
        int bonoPorGol = 500;
        return tarifaBase + (golesMarcados * bonoPorGol);
    }

    public int getGolesMarcados() {
        return golesMarcados;
    }

}
