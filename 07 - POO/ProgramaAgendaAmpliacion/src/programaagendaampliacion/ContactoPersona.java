/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programaagendaampliacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



/**
 *
 * @author IEUser
 */
public class ContactoPersona extends Contacto {
    private LocalDate fechaNacimiento;

    public ContactoPersona(LocalDate fechaNacimiento, String nombre, String telefono) {
        super(nombre, telefono);
        this.fechaNacimiento = fechaNacimiento;
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
        return super.toString() + "\n" + "ContactoPersona{" + "fechaNacimiento = " 
                + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + '}';
    }
    
    
    
    
}
