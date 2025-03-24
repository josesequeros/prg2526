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
        ArrayList<Persona> trabajadores = new ArrayList<>();
        
        Empleado trabajador1 = new Empleado("Angel", "Martinez Lorenzo", "empleado1@contabilidad.es", 100);
        Empleado trabajador2 = new Empleado("Bernardo", "Alba Lopez", "2empleado@gestion.es", 200);
        trabajador2 = new Empleado("Trabajador3", "Tercer Trabajador", "empleado3@gestion.es", 300);
        Becario becario = new Becario("Becario1", "Apellido1 Apellido2", "becario1@contabilidad.es", "Universidad de Alicante");
        becario = new Becario("Becario2", "Segundo Becario", "2becario@gestion.es", "Universidad de Elche");
        
        trabajadores.add(trabajador1);
        trabajadores.add(trabajador2);
        trabajadores.add(becario);
        trabajadores.add(becario);
        trabajadores.add(trabajador2);

        // Mostrar los detalles de todos los trabajadores. Usar un blucle para recorrer el arraylist
        System.out.println("Lista de trabajadores:");
        for (Persona trabajador : trabajadores) {
            System.out.println(trabajador);
        }
        // Buscar un trabajador con un correo que no exista y otro que si.
        buscarPorCorreo(trabajadores, "empleado3@gestion.es");
        buscarPorCorreo(trabajadores, "noexiste@empresa.com");


        // si existe mostrar los detalles del trabajador,
        // si no existe mostrar un mensaje que diga correo no encontrado
    }
    public static void buscarPorCorreo(ArrayList<Persona> trabajadores, String correo) {
        boolean encontrado = false;
        for (Persona trabajador : trabajadores) {
            if (trabajador.getEmail().equalsIgnoreCase(correo)) {
                System.out.println("Trabajador encontrado: " + trabajador);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Correo no encontrado: " + correo);
        }
    }
}

