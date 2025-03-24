
package examen2evejercicio1;

import java.util.ArrayList;

public class Examen2EvEjercicio1 {

    public static void main(String[] args) {
        ArrayList<persona> trabajadores = new ArrayList<>();

        Empleado trabajador1 = new Empleado(100, "Angel", "Martinez Lorenzo", "empleado1@contabilidad.es");
        Empleado trabajador2 = new Empleado(200, "Bernardo", "Alba Lopez", "2empleado@gestion.es");
        Becario becario1 = new Becario("Universidad de Alicante", "Becario1", "Apellido1 Apellido2", "becario1@contabilidad.es");
        Becario becario2 = new Becario("Universidad de Elche", "Becario2", "Segundo Becario", "2becario@gestion.es");

        trabajadores.add(trabajador1);
        trabajadores.add(trabajador2);
        trabajadores.add(becario1);
        trabajadores.add(becario2);

        for (persona persona : trabajadores) {
            System.out.println("Información de la persona:");
            persona.mostrarInfo();
            
            if (persona instanceof Empleado) {
                Empleado empleado = (Empleado) persona;
                empleado.trabajarActo();
                empleado.sueldoGanado();
            } else if (persona instanceof Becario) {
                Becario becario = (Becario) persona;
                becario.universidadIda();
            }
        }
    }
}
