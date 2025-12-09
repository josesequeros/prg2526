/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autores_sanaekassari;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
/**
 *
 * @author sankas
 */
public class Autor {

    private String dni;
    private String nombre;
    private String apellidos;
    private String nacimiento;
    private String pathImagen;

    public Autor(String dni, String nombre, String apellidos, String nacimiento, String pathImagen) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.pathImagen = pathImagen;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the nacimiento
     */
    public String getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento the nacimiento to set
     */
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * @return the pathImagen
     */
    public String getPathImagen() {
        return pathImagen;
    }

    /**
     * @param pathImagen the pathImagen to set
     */
    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }
    
}
