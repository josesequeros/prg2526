/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.joaquinparedesgomez;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MSI
 */
public class Persona {
    
    public static final DateTimeFormatter FORMATO_CSV = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public static final DateTimeFormatter FORMATO_DISPLAY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private String nombre;
    private String apellidos;
    private String correo;
    private String genero;
    private LocalDate fechaNacimiento;
    private String pais;
    
    public Persona(String nombre, String apellidos, String correo, String genero, LocalDate fechaNacimiento, String pais) {
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @Override
    public String toString() {
        return apellidos + ", " + nombre + " - " + pais;
    }
    
}
