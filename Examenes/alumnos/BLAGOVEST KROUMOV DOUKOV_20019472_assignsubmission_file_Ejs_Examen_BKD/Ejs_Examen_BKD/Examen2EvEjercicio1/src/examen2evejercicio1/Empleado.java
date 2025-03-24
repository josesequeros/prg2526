package examen2evejercicio1;

public class Empleado extends Persona implements Trabajador {
    
    private double sueldo;

    public Empleado(String nombre, String apellidos, String correo, double sueldo) {
        super(nombre, apellidos, correo);
        this.sueldo = sueldo;
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + " está trabajando.");
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado: " + nombre + " " + apellidos + ", Email: " + correo + ", Sueldo: " + sueldo);    
    }
}