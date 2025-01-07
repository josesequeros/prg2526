/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programaagendaampliacion;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class ProgramaAgendaAmpliacion {

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
        ContactoPersona contactoPersona;
        ContactoEmpresa contactoEmpresa;

        Contacto contacto;

        LocalDate hoy = LocalDate.now();
        ContactoPersona c = new ContactoPersona(LocalDate.of(2000, Month.MARCH, 01), "jose", "1234");
        agendaContactos.addContactos(c);
        ContactoPersona c2 = new ContactoPersona(LocalDate.of(2000, Month.MARCH, 02), "pepe", "2345");
        agendaContactos.addContactos(c2);
        ContactoPersona c3 = new ContactoPersona(LocalDate.of(2000, Month.MARCH, 03), "ana", "3333");
        agendaContactos.addContactos(c3);
        ContactoPersona c4 = new ContactoPersona(LocalDate.of(2000, Month.MARCH, 04), "luis", "4321");
        agendaContactos.addContactos(c4);

        ContactoEmpresa ce1 = new ContactoEmpresa("www.banda.es", "Almoradi", "123456789");
        agendaContactos.addContactos(ce1);
        ce1 = new ContactoEmpresa("www.bandalmoradi.es", "Banda", "223344");
        agendaContactos.addContactos(ce1);

        do {
            System.out.println("Elija una opción");
            System.out.println("1. Añadir Contacto Persona");
            System.out.println("2. Añadir Contacto Empresa");
            System.out.println("3. Eliminar Contacto");
            System.out.println("4. Buscar Contacto");
            System.out.println("5. Listar Contactos");
            System.out.println("6. Salir.");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    contactoPersona = pedirDatosContactoPersona();
                    if (!agendaContactos.addContactos(contactoPersona)) {
                        System.out.println("El contacto ya existe");
                    } else {
                        agendaContactos.addContactos(contactoPersona);
                        System.out.println("Contacto Añadido");
                    }
                    System.out.println("");
                }
                case 2 -> {
                    contactoEmpresa = pedirDatosContactoEmpresa();
                    if (!agendaContactos.addContactos(contactoEmpresa)) {
                        //if (agendaContactos.existeContacto(contacto)) {
                        System.out.println("El contacto ya existe");
                    } else {
                        agendaContactos.addContactos(contactoEmpresa);
                        System.out.println("Contacto Añadido");
                    }
                    System.out.println("");
                }
                case 3 -> {
                    System.out.println("");
                    System.out.println("Introduzca el nombre del Contacto a borrar: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    if (agendaContactos.borrarContactos(nombre)) {
                        System.out.println("Contacto Borrado");
                    } else {
                        System.out.println("No ha sido posible borrar el Contacto");
                    }

                }
                case 4 -> {
                    System.out.println("");
                    System.out.println("Introduzca el nombre del Contacto a buscar: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    System.out.println("");
                    System.out.println("Datos de: " + nombre);

                    if ((contacto = agendaContactos.buscarContacto(nombre)) != null) {
                        System.out.println(contacto);
                    } else {
                        System.out.println("No existe el contacto.\n");
                    }
                    /*
                    if (agendaContactos.buscarContacto(nombre) instanceof ContactoPersona) {
                        contactoPersona = (ContactoPersona) agendaContactos.buscarContacto(nombre);
                        System.out.println(contactoPersona);
                    } else {
                        contactoEmpresa = (ContactoEmpresa) agendaContactos.buscarContacto(nombre);
                        System.out.println(contactoEmpresa);
                    }
                    System.out.println("");
                     */
                }
                case 5 ->
                    agendaContactos.listarContactos();
                case 6 ->
                    System.out.println("GRACIAS POR USAR NUESTRA APLICACION");
                case 7 -> {
                    System.out.println("");
                    System.out.println("Introduzca el nombre del Contacto a buscar: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    System.out.println("");
                    System.out.println("Datos de: " + nombre);

                    if ((contacto = agendaContactos.buscarContacto(nombre)) != null) {
                        System.out.println(contacto);
                    } else {
                        System.out.println("No existe el contacto.\n");
                    }
                }
            default ->
                    System.out.println("Opción elegida incorrecta.");
            }
        } while (opcion != 6);
        }

    public static ContactoPersona pedirDatosContactoPersona() {
        Scanner sc = new Scanner(System.in);
        ContactoPersona contacto;

        System.out.print("Introduzca Nombre del Contacto: ");
        String nombre = sc.nextLine();
        System.out.print("Introduzca Teléfono del Contacto: ");
        String telefono = sc.nextLine();
        System.out.print("Introduzca Fecha Nacimiento del Contacto: ");
        String fecha = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fecha, formatter);
        contacto = new ContactoPersona(fechaNac, nombre, telefono);

        return contacto;
    }

    public static ContactoEmpresa pedirDatosContactoEmpresa() {
        Scanner sc = new Scanner(System.in);
        ContactoEmpresa contacto;

        System.out.print("Introduzca Nombre del Contacto: ");
        String nombre = sc.nextLine();
        System.out.print("Introduzca Teléfono del Contacto: ");
        String telefono = sc.nextLine();
        System.out.print("Introduzca Página Web del Contacto: ");
        String web = sc.nextLine();

        contacto = new ContactoEmpresa(web, nombre, telefono);

        return contacto;
    }
}
