package examen2evejercicio1;

public class Becario extends Persona implements Trabajador {
    private String universidad;

    public Becario(String nombre, String apellidos, String email, String universidad) {
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
    public void trabajar() {
        System.out.println(getNombre() + " " + getApellidos() + " está en prácticas");
    }

    @Override
    public String toString() {
        return super.toString() + ", Universidad: " + universidad;
    }
}
