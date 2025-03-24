/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2evejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

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
        trabajador2 = new Empleado(300, "Trabajador3", "Tercer Trabajador", "empleado3@gestion.es");
        Becario becario = new Becario("Universidad de Alicante", "Becario1", "Apellido1 Apellido2", "becario1@contabilidad.es");
        becario = new Becario("Universidad de Elche", "Becario2", "Segundo Becario", "2becario@gestion.es");
        Becario becario5 = new Becario("Universidad de Murcia", "Rosa", "Melano Murcia", "becario@gmail.com");
        
        trabajadores.add(trabajador1);
        trabajadores.add(trabajador2);
        trabajadores.add(becario);
        trabajadores.add(trabajador2);
        trabajadores.add(becario5);

        // Mostrar los detalles de todos los trabajadores. Usar un blucle para recorrer el arraylist
        for (int i = 0; i < trabajadores.size(); i++) {
            trabajadores.get(i).mostrarDetalles();
            trabajadores.get(i).trabajar();
        }
        
        System.out.print("Dime el correo buscado: ");
        Scanner esc = new Scanner(System.in);
        String correoBuscado = esc.nextLine();
        
        buscarPorEmail(correoBuscado, trabajadores);
        // Buscar un trabajador con un correo que no exista y otro que si.
        // si existe mostrar los detalles del trabajador, 
        // si no existe mostrar un mensaje que diga correo no encontrado

    }
    
    public static void buscarPorEmail(String email, ArrayList<Persona> trabajadores) {
        int contador = 0;
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getCorreoElectronico().indexOf(email) == 0) {
                System.out.println("LA PERSONA CON ESE EMAIL ES:");
                trabajadores.get(i).mostrarDetalles();
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("Nadie tiene es correo");
        }
    }
    
}
