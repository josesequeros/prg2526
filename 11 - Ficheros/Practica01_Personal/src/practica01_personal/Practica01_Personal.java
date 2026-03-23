/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica01_personal;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ja.buenoseva
 */
public class Practica01_Personal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner teclado = new Scanner(System.in);

        ArrayList<Persona> listaPersonas;
        Personal personal;
        personal = Auxiliar.leerPersonas("personal.csv");
        listaPersonas = personal.getPersonal();
        System.out.println(listaPersonas.size());
        System.out.println(listaPersonas.get(0));
        //Auxiliar.grabarPersonas("personal.csv", listaPersonas);

        boolean repetir = false;
        do {
            repetir = true;
            int opcion = menu(teclado);
            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el nombre del país: ");
                    String pais = teclado.nextLine();
                    Personal personasPais = new Personal();
                    personasPais.setPersonal(personal.personaPais(pais));
                    for (Persona persona : personasPais.getPersonal()) {
                        System.out.println(persona);
                    }
                    break;
                case 3:
                    int dia = EntradaCorrecta.nextInt(teclado, "Día de Nacimiento: ", 1, 31);
                    int mes = EntradaCorrecta.nextInt(teclado, "Mes de Nacimiento: ", 1, 12);
                    ArrayList<Persona> lista = personal.personasCumple(dia, mes);
                    for (Persona persona : lista) {
                        System.out.println(persona);
                    }
                    break;                
                case 0:
                    repetir = false;
                    break;
            }
        } while (repetir);

    }

    public static int menu(Scanner teclado) {
        int opcion = 0;
        boolean error = true;

        class ExcepcionFueraDeRango extends Exception {

            public ExcepcionFueraDeRango(String par) {
                super(par);
            }
        }

        do {
            try {
                System.out.println(" Menú de Personal ");
                System.out.println("--------------------------");
                System.out.println("1.- Nombre del País");
                System.out.println("2.- Borrar Persona por email");
                System.out.println("3.- Personas por Cumpleaños");
                System.out.println("4.- Insertar Nuevo Nombre");
                System.out.println("5.- Mostrar las personas mas jovenes");
                System.out.println("0.- Salir");
                System.out.print("Seleccione [0..5]: ");

                opcion = teclado.nextInt();
                if (opcion < 0 || opcion > 5) {
                    throw new ExcepcionFueraDeRango("La opción elegida ha sido: " + opcion);
                }
                error = false;
            } catch (ExcepcionFueraDeRango ex) {
                System.out.println(ex.getMessage());
                System.out.println("Número fuera de rango");
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Número no válido");
                teclado.nextLine();
            }
        } while (error);
        teclado.nextLine();
        return opcion;
    }

}
