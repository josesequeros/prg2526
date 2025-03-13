/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class ToDo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        GestorTareas listaTareas = new GestorTareas();

        //listaTareas.creaTareas();
        listaTareas.cargarTareas();
        System.out.println("Tareas");
        System.out.println("------");
        listaTareas.mostrarTareas();

        int opcion = 0;

        do {
            opcion = menu(teclado);
            switch (opcion) {
                case 1:
                    listaTareas.mostrarTareas();
                    break;
                case 2:
                    listaTareas.nuevaTarea();
                    break;
                case 3:
                    listaTareas.editarTarea();
                    break;
                case 4:
                    listaTareas.empezarTarea();
                    break;
                case 5:
                    listaTareas.completarTarea();
                    break;
                case 6:
                    //guardarTareas();
                    System.out.println("Finalizado el programa");
                    break;
                default:
                    System.out.println("Opcion equivocada");
            }
        } while (opcion != 6);
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
                System.out.println("  Menu Tareas");
                System.out.println("  -----------");
                System.out.println("1.- Mostrar tareas");
                System.out.println("2.- Nueva tarea");
                System.out.println("3.- Editar tarea");
                System.out.println("4.- Empezar tarea");
                System.out.println("5.- Completar tarea");
                System.out.println("6.- Fin");
                System.out.print("Seleccione [1..6]: ");

                opcion = Utiles.nextInt("Elija opción de menu: ", 1, 6);
                if (opcion < 0 || opcion > 6) {
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
