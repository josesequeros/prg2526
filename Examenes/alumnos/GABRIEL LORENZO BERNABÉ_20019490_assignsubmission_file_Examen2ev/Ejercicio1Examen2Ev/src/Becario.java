public class Becario extends Persona{
    String universidad;
    public Becario(String universidad,String nombre, String apellidos, String correo) {
        super(nombre, apellidos, correo);
        this.universidad = universidad;
    }
}
