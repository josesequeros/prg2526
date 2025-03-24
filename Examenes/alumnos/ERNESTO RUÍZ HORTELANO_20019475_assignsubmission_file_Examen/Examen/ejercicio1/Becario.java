package ejercicio1;

public class Becario extends Persona implements Trabajador{
    String universidad;

    public Becario(String universidad, String nombre, String apellidos, String correoElectronico) {
        super(nombre, apellidos, null);
        super.correoElectronico = (verificarCorreo(correoElectronico))? correoElectronico : "este correo no vale";
        this.universidad = universidad;
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
        System.out.println("Becario{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", correoElectronico=" + correoElectronico + ", universidad=" + universidad + '}');
    }
}
