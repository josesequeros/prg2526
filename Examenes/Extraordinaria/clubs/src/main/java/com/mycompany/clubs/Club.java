/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clubs;

import java.util.ArrayList;

/**
 *
 * @author 
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setDeportistas(ArrayList<DeportistaBaseAbstracta> deportistas) {
        this.deportistas = deportistas;
    }
    
    
}
