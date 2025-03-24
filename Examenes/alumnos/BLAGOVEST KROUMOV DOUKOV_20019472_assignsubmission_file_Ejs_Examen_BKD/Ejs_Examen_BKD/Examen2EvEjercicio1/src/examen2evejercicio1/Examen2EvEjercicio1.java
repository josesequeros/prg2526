/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2evejercicio1;

import java.util.Scanner;
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
        ArrayList<Persona> personas = new ArrayList<>();

        personas.add(new Empleado("Angel", "Martinez Lorenzo", "empleado1@contabilidad.es", 100));
        personas.add(new Empleado("Bernardo", "Alba Lopez", "2empleado@gestion.es", 200));
        personas.add(new Empleado("Trabajador3", "Tercer Trabajador", "empleado3@gestion.es", 300)); // Correo inválido
        personas.add(new Becario("Becario1", "Apellido1 Apellido2", "becario1@contabilidad.es", "Universidad de Alicante"));
        personas.add(new Becario("Becario2", "Segundo Becario", "2becario@gestion.es", "Universidad de Elche"));
        
        //para mostrar
        for (Persona p : personas) {
            p.mostrarDetalles();
        }
        
        // para buscar
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un correo para buscar: ");
        String emailBuscado = sc.nextLine();
        boolean encontrado = false;

        for (Persona p : personas) {
            if (p.getCorreo().equalsIgnoreCase(emailBuscado)) {
                p.mostrarDetalles();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró una persona con ese correo.");
        }
    }

}

