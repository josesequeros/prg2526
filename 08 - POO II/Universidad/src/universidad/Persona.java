/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jabue
 */
public class Persona {
    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, int edad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Fecha de Nacimiento: " + getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
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
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the fechaNacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + '}';
    }
    
    
}
