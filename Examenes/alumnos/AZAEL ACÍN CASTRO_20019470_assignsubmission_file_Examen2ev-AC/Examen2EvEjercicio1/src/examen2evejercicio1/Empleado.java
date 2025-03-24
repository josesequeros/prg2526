package examen2evejercicio1;

public class Empleado extends persona{
    
    private int sueldo;

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    public Empleado(String nombre, String apellido, String correo) {
        super(nombre, apellido, correo);
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Correo: " + correo);
    }
    
    public void sueldoGanado() {
        System.out.println("La persona a ganado " + sueldo);
    }

    public Empleado(int sueldo, String nombre, String apellido, String correo) {
        super(nombre, apellido, correo);
        this.sueldo = sueldo;
    }
    
}
