package examen2evejercicio1;

public class Becario extends Persona {
    private String universidad;

    public Becario(String universidad, String nombre, String apellidos, String email) {
        super(nombre, apellidos, email);
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
        System.out.println("Becario: " + nombre + " " + apellidos + ", Email: " + email + ", Universidad: " + universidad);
    }
}
