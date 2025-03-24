package examen2evejercicio1;

public class Becario extends Persona implements Trabajador {
    private String universidad;

    public Becario(String universidad, String nombre, String apellidos, String correo) {
        super(nombre, apellidos, correo);
        this.universidad = universidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Nombre: " + getNombre() + " " + getApellidos() + " Correo: " + getCorreo() + " Universidad: " + getUniversidad());
    }

    @Override
    public void tarabajar() {
        System.out.println("El becario " + getNombre() + " " + getApellidos() + " está trabajando");
    }

    @Override
    public void validarCorreo() {
        String correo = getCorreo();
        if ((correo.indexOf("@contabilidad.es") != -1 || correo.indexOf("@gestion.es") != -1) && Character.isLetter(correo.charAt(0))) {
        } else {
            setCorreo("este correo no vale");
        }
    }
}
