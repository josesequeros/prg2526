/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.deportistaslistview;

import java.util.ArrayList;

/**
 *
 * @author carme
 */
public class Club {

    private String nombre;
    private String imagen;
    private ArrayList<DeportistaBaseAbstracta> deportistas;

    public Club(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.deportistas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public ArrayList<DeportistaBaseAbstracta> getDeportistas() {
        return deportistas;
    }

    public void addDeportista(DeportistaBaseAbstracta deportista) {
        this.deportistas.add(deportista);
    }

    public int calcularNomina() {
        int nomina = 0;
        for (DeportistaBaseAbstracta deportista : deportistas) {
            nomina += deportista.calcularSalarioMensual();
        }
        return nomina;
    }
}
