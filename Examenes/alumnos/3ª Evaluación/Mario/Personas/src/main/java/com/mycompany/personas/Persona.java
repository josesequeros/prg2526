/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personas;

/**
 *
 * @author mario
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private String correo;
    private String genero;
    private String nacimiento;
    private String pais;

    public Persona(String nombre, String apellidos, String correo, String genero, String nacimiento, String pais) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.genero = genero;
        this.nacimiento = nacimiento;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return  nombre + " " + apellidos + " " + correo + " " + genero + " " + nacimiento + " " + pais ;
    }
    
    
    
}
