
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    public class Persona{
    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        private String nombre;
        private String apellido;
        private String email;
        private String genero;
        private LocalDate nacimiento;
        private String pais;
    public Persona(String nombre, String apellido, String email, String genero, LocalDate nacimiento, String pais){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.nacimiento = nacimiento;
        this.pais = pais;
        }
//Pongo los getters y los setters

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getGenero(){
        return genero;
    
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public LocalDate getNacimiento(){
        return nacimiento;
    }
    
    public void setLocalDate(LocalDate nacimiento){
        this.nacimiento = nacimiento;
    }

    public String getPais(){
        return  pais;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public String getNacimientoTexto(){
        return nacimiento.format(FORMATO_FECHA);
    }

    public String pasarAcsv(){
        return nombre + ", " + apellido + ", " + email + ", " + genero + ", " + getNacimientoTexto();
    }

    @Override
    public String toString(){
        return apellido + ", " + nombre + " - " + pais;
    }
}
    




