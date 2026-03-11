/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio04_salarios;

import java.io.Serializable;

/**
 *
 * @author ja.buenoseva
 */
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L; // Necesario para la serialización 

    private String nombre;
    private String apellido;
    private String categoria;
    private double salario;

    public Profesor() {
    }

    public Profesor(String nombre, String apellido, String categoria, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Profesor{" + "nombre=" + nombre + ", apellido=" + apellido + ", categoria=" + categoria + ", salario=" + salario + '}';
    }
    

}
