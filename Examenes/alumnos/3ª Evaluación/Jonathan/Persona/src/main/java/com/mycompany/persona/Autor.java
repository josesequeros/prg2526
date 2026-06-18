/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persona;

import java.io.Serializable;
import java.time.LocalDate;

public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate nacimiento;
    private String imagen;

    public Autor(String dni, String nombre, String apellidos, LocalDate nacimiento, String imagen) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.imagen = imagen;
    }

    // Getters
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public LocalDate getNacimiento() { return nacimiento; }
    public String getImagen() { return imagen; }

    // Setters
    public void setDni(String dni) { this.dni = dni; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setNacimiento(LocalDate nacimiento) { this.nacimiento = nacimiento; }
    public void setImagen(String imagen) { this.imagen = imagen; }
}