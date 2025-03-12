/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class TestPersonal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        ArrayList<Persona> listaPersonas;
        Personal personal;
        personal = Auxiliar.leerPersonas("personal.csv");

        do {
            opcion = menu();

            switch (opcion) {
                case 0:
                    grabarPersonal(personal);
                    break;
                case 1:
                    clientesPais(personal);
                    break;
                case 2:
                    borrarPersona(personal);
                    personal.mostrarPersonal();
                    break;
                case 3:
                    personal.mostrarPersonal();
                    break;                    
                default:
                    break;

            }
        } while (opcion != 0);
    }

    private static int menu() {
        boolean correcto = true;
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            try {
                System.out.println("");
                System.out.println("0. Salir");;
                System.out.println("1. Mostar gente de un pais determinado");
                System.out.println("2. Borrar persona con su email");
                System.out.println("");
                System.out.print("Selecciona el número de opción: ");
                opcion = teclado.nextInt();
                if (opcion < 0 || opcion > 3) {
                    correcto = false;
                    throw new ExcepcionFueraDeRango("La opción elegida ha sido: " + opcion);
                }
                correcto = true;
            } catch (ExcepcionFueraDeRango e) {
                System.out.println(e.getMessage());
                System.out.println("Número fuera de rango");
            } catch (InputMismatchException e) {
                teclado.nextLine();
                System.out.println(e.getMessage());
                System.out.println("Introduce un número válido");
                correcto = false;
            }
        } while (!correcto);

        return opcion;
    }

    public static void clientesPais(Personal personal) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el nombre d eun pais: ");
        String pais = teclado.nextLine();
        Personal personalPais = new Personal(personal.personaPais(pais));
        int i = 1;

        if (personalPais.getPersonal() != null) {
            for (Persona persona : personalPais.getPersonal()) {
                System.out.print(i++ + " ");
                System.out.println(persona);

                //LocalDate fecha = LocalDate.parse(persona.getNacimiento());
                //LocalDate fecha = LocalDate.parse(persona.getNacimiento(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                //System.out.println(fecha);
                //System.out.println(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
            
        } else {
            System.out.println("No existe personas de ese pais");
        }
    }

    public static void borrarPersona(Personal personal) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el correo de la Persona a borrar: ");
        String email = teclado.nextLine();
        personal.borrarPorEmail(email);
    }
    
    public static void grabarPersonal(Personal personal) {
        Auxiliar.grabarPersonas("personal", personal.getPersonal());
    }
}
