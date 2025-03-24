package examen2evejercicio1;

public class Empleado extends Persona implements Trabajador {
    private int sueldo;

    public Empleado(String nombre, String apellidos, String email, int sueldo) {
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
    public void trabajar() {
        System.out.println(getNombre() + " " + getApellidos() + " está trabajando");
    }

    @Override
    public String toString() {
        return super.toString() + ", Sueldo: " + sueldo;
    }
}
