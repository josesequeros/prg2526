/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioexcepciones01;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class EjercicioExcepciones01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);

        int opcion = menu(tec);
        switch (opcion) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;

        }
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
                System.out.println(" Menú de Agenda ");
                System.out.println("--------------------------");
                System.out.println("1.- Cargar Fichero Agenda");
                System.out.println("2.- Guardar Fichero Agenda");
                System.out.println("3.- Buscar Nombre");
                System.out.println("4.- Insertar Nuevo Nombre");
                System.out.println("5.- Eliminar Nombre");
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
            }
        } while (error);
        return opcion;
    }

}
