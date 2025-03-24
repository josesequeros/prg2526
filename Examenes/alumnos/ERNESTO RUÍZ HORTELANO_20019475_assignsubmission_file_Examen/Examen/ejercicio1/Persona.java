package ejercicio1;

public abstract class Persona {
    String nombre;
    String apellidos;
    String correoElectronico;

    public Persona(String nombre, String apellidos, String correoElectronico) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
    }
    
    
    
    public abstract void mostrarDetalles();
}
