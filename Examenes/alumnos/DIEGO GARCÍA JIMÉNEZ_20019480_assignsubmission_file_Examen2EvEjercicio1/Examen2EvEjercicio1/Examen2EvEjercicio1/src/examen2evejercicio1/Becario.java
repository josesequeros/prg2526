package examen2evejercicio1;

public class Becario extends Persona implements Trabajador{

    private String universidad;

    public Becario(String universidad, String nombre, String apellido, String correoElectronico) {
        super(nombre, apellido, correoElectronico);
        this.universidad = universidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Becario");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellidos: " + getApellido());
        System.out.println("Email: " + getCorreoElectronico());
        System.out.println("Universidad: " + getUniversidad());
        System.out.println("");
    }

    @Override
    public void trabajar() {
        System.out.println(getNombre() + " " + getApellido() + " esta tranajando");
        System.out.println("");
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

}
