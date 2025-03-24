package examen2evejercicio1;

public class Empleado extends Persona {
    private int sueldo;

    public Empleado(int sueldo, String nombre, String apellidos, String email) {
        super(nombre, apellidos, email);
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado: " + nombre + " " + apellidos + ", Email: " + email + ", Sueldo: " + sueldo);
    }
}
