package examen2evejercicio1;

public class Empleado extends Persona implements Trabajador{
    private int sueldo;

    public Empleado(int sueldo, String nombre, String apellido, String correoElectronico) {
        super(nombre, apellido, correoElectronico);
        this.sueldo = sueldo;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellidos: " + getApellido());
        System.out.println("Email: " + getCorreoElectronico());
        System.out.println("Sueldo: " + getSueldo());
        System.out.println("");
    }
    
    @Override
    public void trabajar() {
        System.out.println(getNombre() + " " + getApellido() + " esta tranajando");
        System.out.println("");
    }
    
    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
}
