package examen2evejercicio1;

public abstract class mostrarDetalles {
    private String nombre;
    private String apellido;
    private String correo;
    
     public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Correo: " + correo);
    }

}
