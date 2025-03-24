package examen2evejercicio1;

import java.util.ArrayList;

public class Examen2EvEjercicio1 {

    public static void main(String[] args) {
        ArrayList<Persona> trabajadores = new ArrayList<>();

        Empleado trabajador1 = new Empleado(100, "Angel", "Martinez Lorenzo", "empleado1@contabilidad.es");
        Empleado trabajador2 = new Empleado(200, "Bernardo", "Alba Lopez", "2empleado@gestion.es");
        trabajador2 = new Empleado(300, "Trabajador3", "Tercer Trabajador", "empleado3@gestion.es");
        Becario becario1 = new Becario("Universidad de Alicante", "Becario1", "Apellido1 Apellido2", "becario1@contabilidad.es");
        Becario becario2 = new Becario("Universidad de Elche", "Becario2", "Segundo Becario", "2becario@gestion.es");

        trabajadores.add(trabajador1);
        trabajadores.add(trabajador2);
        trabajadores.add(becario1);
        trabajadores.add(becario2);
        trabajadores.add(trabajador2);

        for (Persona trabajador : trabajadores) {
            trabajador.mostrarDetalles();
        }


        buscarPorEmail(trabajadores, "empleado4@gestion.es");
        buscarPorEmail(trabajadores, "empleado1@contabilidad.es");
    }

    private static void buscarPorEmail(ArrayList<Persona> trabajadores, String email) {
        boolean encontrado = false;
        for (Persona trabajador : trabajadores) {
            if (trabajador.getEmail().equals(email)) {
                trabajador.mostrarDetalles();
                encontrado = true;
                break;
            }

        }
        if (!encontrado) {
            System.out.println("Correo no encontrado: " + email);
        }
    }
}
