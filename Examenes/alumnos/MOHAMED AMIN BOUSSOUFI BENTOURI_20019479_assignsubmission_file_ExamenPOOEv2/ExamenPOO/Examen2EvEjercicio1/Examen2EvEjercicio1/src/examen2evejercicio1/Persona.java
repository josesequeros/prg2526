package examen2evejercicio1;

public abstract class Persona {
    protected String nombre;
    protected String apellidos;
    protected String email;

    public Persona(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = validarEmail(email);
    }

    private String validarEmail(String email) {
        String[] dominiosValidos = {"@contabilidad.es", "@gestion.es"};
        boolean valido = false;
        for (String dominio : dominiosValidos) {
            if (email.endsWith(dominio)) {
                valido = true;
                break;
            }
        }
        if (valido && Character.isLetter(email.charAt(0)) && email.indexOf('@') == email.lastIndexOf('@')) {
            return email;
        } else {
            return "este correo no vale";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = validarEmail(email);
    }

    public abstract void mostrarDetalles();
}
