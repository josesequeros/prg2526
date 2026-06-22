/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.deportistaslistview;

/**
 *
 * @author carme
 */
public class JugadorBaloncesto extends DeportistaBaseAbstracta {

    private int triplesAnotados;

    public JugadorBaloncesto(String nombre, int edad, String deporte, Club club, String imagen, int triplesAnotados) {
        super(nombre, edad, deporte, club, imagen);
        this.triplesAnotados = triplesAnotados;
    }

    @Override
    public int calcularSalarioMensual() {
        int tarifaBase = 2000;
        int bonoPorTriple = 500;
        return tarifaBase + (triplesAnotados * bonoPorTriple);
    }

    public int getTriplesAnotados() {
        return triplesAnotados;
    }

}
