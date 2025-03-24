/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2evejercicio1;

import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public class Examen2EvEjercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Persona> trabajadores = new ArrayList();

        Empleado trabajador1 = new Empleado(100, "Angel", "Martinez Lorenzo", "empleado1@contabilidad.es");
        Empleado trabajador2 = new Empleado(200, "Bernardo", "Alba Lopez", "2empleado@gestion.es");
        Empleado trabajador3 = new Empleado(300, "Trabajador3", "Tercer Trabajador", "empleado3@gestion.es");
        Becario becario = new Becario("Universidad de Alicante", "Becario1", "Apellido1 Apellido2",
                "becario1@contabilidad.es");
        Becario becario2 = new Becario("Universidad de Elche", "Becario2", "Segundo Becario", "2becario@gestion.es");

        trabajadores.add(trabajador1);
        trabajadores.add(trabajador2);
        trabajadores.add(trabajador3);
        trabajadores.add(becario);
        trabajadores.add(becario2);

        // Mostrar los detalles de todos los trabajadores. Usar un blucle para recorrer
        // el arraylist
        for (Persona trabajador : trabajadores) {
            trabajador.mostrarDetalles();
        }
        System.out.println("----------------");
        for (Persona trabajador : trabajadores) {
            trabajador.validarCorreo();
        }
        System.out.println("----------------");
        for (Persona trabajador : trabajadores) {
            trabajador.mostrarDetalles();
        }
        System.out.println("----------------");
        // Buscar un trabajador con un correo que no exista y otro que si.
        // si existe mostrar los detalles del trabajador,
        // si no existe mostrar un mensaje que diga correo no encontrado
        buscarTrabajador(trabajadores, "empleado1@contabilidad.es");
        buscarTrabajador(trabajadores, "patata@patatafuerte.com");

    }

    public static void buscarTrabajador(ArrayList<Persona> trabajadores, String correo) {
        boolean encontrado = false;
        for (Persona trabajador : trabajadores) {
            if (trabajador.getCorreo().equals(correo)) {
                trabajador.mostrarDetalles();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Correo no encontrado");
        }
    }
}
