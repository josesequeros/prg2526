package examen2evejercicio1;

public class Becario extends Persona implements Trabajador {
    
    private String universidad;

    public Becario(String nombre, String apellidos, String correo, String universidad) {
        super(nombre, apellidos, correo);
        this.universidad = universidad;
    }

    @Override
    public void trabajar() {
        System.out.println(nombre + " está realizando prácticas.");
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Becario: " + nombre + " " + apellidos + ", Email: " + correo + ", Universidad: " + universidad);
    }
}
