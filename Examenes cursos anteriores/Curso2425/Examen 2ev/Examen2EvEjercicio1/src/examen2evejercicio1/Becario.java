/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2evejercicio1;

/**
 *
 * @author jabue
 */
public class Becario extends Persona implements Trabajador {
    private String universidad;

    public Becario(String universidad, String nombre, String apellidos, String correo) {
        super(nombre, apellidos, correo);
        this.universidad = universidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Datos del Becario: ");
        System.out.println("\t Nombre: " + this.getNombre()+" "+this.getApellidos());
        System.out.println("\t\t Correo: " + this.getCorreo());
        System.out.println("\t\t Universidad: " + this.getUniversidad());
    }

    @Override
    public void trabajar() {
        System.out.print("El becario: ");
        System.out.print(this.getNombre()+" "+this.getApellidos());
        System.out.println(" está trabajando");
    }
    
    
}
