/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2evejercicio1;

/**
 *
 * @author jabue
 */
public abstract class Persona {

    private String nombre;
    private String apellidos;
    private String correo;

    public Persona(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        if (validarCorreo(correo)) 
            this.correo = correo;
        else
            this.correo = "este correo no vale";
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + '}';
    }

    public abstract void mostrarDetalles();

    public boolean validarCorreo(String email) {
        boolean valido = true;
        valido = Character.isLetter(email.charAt(0));
        int posicion = email.indexOf("@");
        if (posicion > 0) {
            valido = valido && (email.substring(posicion).equals("@contabilidad.es") || email.substring(posicion).equals("@gestion.es"));
        } else {
            valido = false;
        }
        return valido;
    }

}
