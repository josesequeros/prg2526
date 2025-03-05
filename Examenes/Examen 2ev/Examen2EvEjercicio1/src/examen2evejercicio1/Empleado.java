/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2evejercicio1;

/**
 *
 * @author jabue
 */
public class Empleado extends Persona implements Trabajador{
    private double sueldo;

    public Empleado(double sueldo, String nombre, String apellidos, String correo) {
        super(nombre, apellidos, correo);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "sueldo=" + sueldo + '}';
    }
    
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Datos del empleado: ");
        System.out.println("\t Nombre: " + this.getNombre()+" "+this.getApellidos());
        System.out.println("\t\t Correo: " + this.getCorreo());
        System.out.println("\t\t Sueldo: " + this.getSueldo());
    }

    @Override
    public void trabajar() {
        System.out.print("El empleado: ");
        System.out.print(this.getNombre()+" "+this.getApellidos());
        System.out.println(" está trabajando");
    }
    
}
