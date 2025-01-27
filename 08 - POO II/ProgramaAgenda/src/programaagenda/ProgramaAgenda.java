/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programaagenda;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class ProgramaAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
    }

    public static void menu() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        Agenda agendaContactos = new Agenda();
        Contacto contacto;

        Contacto c = new Contacto("jose", "1234");
        agendaContactos.addContactos(c);
        Contacto c2 = new Contacto("pepe", "2345");
        agendaContactos.addContactos(c2);
        Contacto c3 = new Contacto("ana", "3333");
        agendaContactos.addContactos(c3);
        Contacto c4 = new Contacto("luis", "4321");
        agendaContactos.addContactos(c4);
        
        do {
            System.out.println("Elija una opción");
            System.out.println("1. Añadir Contacto");
            System.out.println("2. Eliminar Contacto");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Listar Contactos");
            System.out.println("5. Salir.");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    contacto = pedirDatosContacto();
                    if (!agendaContactos.addContactos(contacto)) {
                        //if (agendaContactos.existeContacto(contacto)) {
                        System.out.println("El contacto ya existe");
                    } 
                    System.out.println("");
                }
                case 2 -> {
                }
                case 3 -> {
                    System.out.println("");
                    System.out.println("Introduzca el nombre del Contacto a buscar: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    contacto = agendaContactos.buscarContacto(nombre);
                    System.out.println("Datos de: " + nombre);
                    System.out.println(contacto);
                    System.out.println("");
                }
                case 4 -> agendaContactos.listarContactos();
                case 5 -> System.out.println("GRACIAS POR USAR NUESTRA APLICACION");
                default -> System.out.println("Opción elegida incorrecta.");
            }
        } while (opcion != 5);
    }

    public static Contacto pedirDatosContacto() {
        Scanner sc = new Scanner(System.in);
        Contacto contacto;

        System.out.print("Introduzca Nombre del Contacto: ");
        String nombre = sc.nextLine();
        System.out.print("Introduzca Teléfono del Contacto: ");
        String telefono = sc.nextLine();
        contacto = new Contacto(nombre, telefono);

        return contacto;
    }

}
