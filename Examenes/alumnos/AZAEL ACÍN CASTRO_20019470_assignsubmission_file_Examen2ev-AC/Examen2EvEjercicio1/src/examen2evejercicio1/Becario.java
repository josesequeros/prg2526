package examen2evejercicio1;

public class Becario extends persona {
    
    private String universidad;
    
    public Becario(String nombre, String apellido, String correo) {
        super(nombre, apellido, correo);
    }
    public String getUniversidad() {
        return universidad;
    }
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    public void universidadIda() {
        System.out.println("La persona a ganado " + universidad);
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Correo: " + correo);
    }

    public Becario(String universidad, String nombre, String apellido, String correo) {
        super(nombre, apellido, correo);
        this.universidad = universidad;
    }
}
