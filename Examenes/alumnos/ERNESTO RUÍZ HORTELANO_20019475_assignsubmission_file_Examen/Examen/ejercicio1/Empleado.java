package ejercicio1;

public class Empleado extends Persona implements Trabajador{
    
    int sueldo;

    public Empleado(int sueldo, String nombre, String apellidos, String correoElectronico) {
        super(nombre, apellidos, correoElectronico);
        this.sueldo = sueldo;
    }
    
    @Override
    public void trabajar(){
        System.out.println(super.nombre + " " + super.apellidos + " esta trabajando");
    }
    
    public boolean verificarCorreo(String correoElectronico){
        int index = correoElectronico.indexOf('@');
        String dominio = correoElectronico.substring(index);
        
        if(dominio.equals("@contabilidad.es") || dominio.equals("@gestion.es")){
            if(correoElectronico.matches("^[A-Za-z].*")){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", correoElectronico=" + correoElectronico + ", sueldo=" + sueldo + '}');
    }
 
    
    
}
