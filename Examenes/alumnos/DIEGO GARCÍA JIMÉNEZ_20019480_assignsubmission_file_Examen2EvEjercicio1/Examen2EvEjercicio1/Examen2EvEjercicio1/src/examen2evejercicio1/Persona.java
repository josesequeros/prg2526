package examen2evejercicio1;

import java.util.ArrayList;

public abstract class Persona implements Trabajador{

    private String nombre;
    private String apellido;
    private String correoElectronico;
    
    public Persona(String nombre, String apellido, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        if ((correoElectronico.indexOf("@contabilidad.es") < 1 && (correoElectronico.indexOf("@gestion.es") < 1)) || correoElectronico.matches("^[A-Za-z].*") == false)  {
            this.correoElectronico = "este correo no vale";
        }else{
            this.correoElectronico = correoElectronico;
        }
    }
    
    public abstract void mostrarDetalles();
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
}
