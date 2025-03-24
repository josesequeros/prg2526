package examen2evejercicio1;

abstract class Persona {
    
    protected String nombre;
    protected String apellidos;
    protected String correo;

    public Persona(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = validarCorreo(correo);
    }

    private String validarCorreo(String correo) {
        if (correo.matches("^[a-zA-Z][a-zA-Z0-9_.-]*@(contabilidad.es|gestion.es)$")) {
            return correo;
        } else {
            return "Este correo no vale";
        }
    }

    public String getCorreo() {
        return correo;
    }

    public abstract void mostrarDetalles();

}

