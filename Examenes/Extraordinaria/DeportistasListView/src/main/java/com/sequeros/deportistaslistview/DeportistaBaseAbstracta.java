/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.deportistaslistview;

/**
 *
 * @author jabue
 */
public abstract class DeportistaBaseAbstracta implements DeportistaInterfaz {

    private String nombre;
    private int edad;
    private String deporte;
    private Club club;
    private String imagen;

    public DeportistaBaseAbstracta(String nombre, int edad, String deporte, Club club, String imagen) {
        this.nombre = nombre;
        this.edad = edad;
        this.deporte = deporte;
        this.club = club;
        this.imagen = imagen;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getEdad() {
        return this.edad;
    }

    @Override
    public String getDeporte() {
        return this.deporte;
    }

    @Override
    public Club getClub() {
        return this.club;
    }

    @Override
    public String getImagen() {
        return this.imagen;
    }

    @Override
    public abstract int calcularSalarioMensual();

}
