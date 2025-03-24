package ejercicio1;

import java.util.ArrayList;

public class Ejercicio1 {

    public static void main(String[] args) {
        ArrayList<Persona> trabajadores = new ArrayList();
        
        Empleado trabajador1 = new Empleado(100, "Angel", "Martinez Lorenzo", "empleado1@contabilidad.es");
        Empleado trabajador2 = new Empleado(200, "Bernardo", "Alba Lopez", "2empleado@gestion.es");
        trabajador2 = new Empleado(300, "Trabajador3", "Tercer Trabajador", "empleado3@gestion.es");
        Becario becario = new Becario("Universidad de Alicante", "Becario1", "Apellido1 Apellido2", "becario1@contabilidad.es");
        becario = new Becario("Universidad de Elche", "Becario2", "Segundo Becario", "2becario@gestion.es");
        
        trabajadores.add(trabajador1);
        trabajadores.add(trabajador2);
        trabajadores.add(becario);
        trabajadores.add(becario);
        trabajadores.add(trabajador2);
        
        for (int i = 0; i < trabajadores.size(); i++){
            trabajadores.get(i).mostrarDetalles();
        }
        
        EncontrarCorreo("empleado1@contabilidad.es", trabajadores);
        EncontrarCorreo("becario1@contabilidad.es", trabajadores);
        
        // Buscar un trabajador con un correo que no exista y otro que si.
        // si existe mostrar los detalles del trabajador, 
        // si no existe mostrar un mensaje que diga correo no encontrado
        
    }
    public static void EncontrarCorreo(String correo, ArrayList<Persona> trabajadores){
        for (int i = 0; i < trabajadores.size(); i++){
            if(correo == trabajadores.get(i).correoElectronico){
                System.out.println("Correo encontrado");
                trabajadores.get(i).mostrarDetalles();
                return;
            }
        }
        System.out.println("Correo no encontrado");
    }
    
}
