package examen2evejercicio1;

public class Empleado extends Persona implements Trabajador{
    private int salario;


    public Empleado(int salario ,String nombre, String apellidos, String correo) {
        super(nombre, apellidos, correo);
        this.salario = salario;
    }


    public int getSalario() {
        return salario;
    }


    public void setSalario(int salario) {
        this.salario = salario;
    }


    @Override
    public void mostrarDetalles() {
        System.out.println("Nombre: " + getNombre() + " " + getApellidos() + " Correo: " + getCorreo() + " Salario: " + getSalario() + "€");
    }
    
    @Override
    public void tarabajar() {
        System.out.println("El epleado " + getNombre() + " " + getApellidos() + " está trabajando");
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