/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1002;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Practica1002 {

    private static ArrayList<Tarea> tareas = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opc;
        tareas = cargarTareas();
        mostrarTareas();
        do {

            opc = menu();
            switch (opc) {
                case 1:
                    mostrarTareas();
                    break;
                case 2:
                    nuevaTarea();
                    break;
                case 3:
                    editarTarea();
                    break;
                case 4:
                    empezarTarea();
                    break;
                case 5:
                    completarTarea();
                    break;
                case 6:
                    //guardarTareas();
                    System.out.println("Finalizado el programa");
                    break;
                default:
                    System.out.println("Opcion equivocada");
            }
        } while (opc != 6);

        System.out.println();
    }

    public static int menu() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("1.- Mostrar tareas");
        System.out.println("2.- Nueva tarea");
        System.out.println("3.- Editar tarea");
        System.out.println("4.- Empezar tarea");
        System.out.println("5.- Completar tarea");
        System.out.println("6.- Fin");

        opcion = sc.nextInt();

        return opcion;
    }

    public static void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("Todavia no hay tareas creadas");
        } else {
            System.out.println("Listado de tareas: ");
            for (int i = 0; i < tareas.size(); i++) {
                Tarea tarea = tareas.get(i);
                System.out.print((i + 1) + " - " + tarea.getTitulo());
                System.out.print(" " + tarea.getHoras());
                System.out.print(" " + tarea.verEstado());
                System.out.println("");
            }
            System.out.println("");
        }

    }

    private static ArrayList<Tarea> cargarTareas() {
        ArrayList<Tarea> tareas = new ArrayList<>();
        File fichero = new File("tareas.dat");

        if (!fichero.exists()) {
            //System.out.println("Todavia no hay tareas");
            return new ArrayList<Tarea>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./tareas.dat"))) {
            while (true) {
                Tarea tarea = (Tarea) ois.readObject();
                tareas.add(tarea);
            }
        } catch (EOFException e) {
            // Se alcanzó el final del archivo
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar las tareas: " + e.getMessage());
        }
        return tareas;
    }

    
    public static void nuevaTarea() {
        Scanner sc = new Scanner(System.in);
        String titulo;
        double horas;
        System.out.print("Introduzca el título de la tarea: ");
        titulo = sc.nextLine();
        System.out.print("Introduzca duración en horas: ");
        horas = sc.nextDouble();
        sc.nextLine();
        // Crear una nueva tarea
        Tarea nuevaTarea = new Tarea(titulo, horas);
        tareas.add(nuevaTarea);
        guardarTareas();
       
    }

    public static void editarTarea() {
        Scanner sc = new Scanner(System.in);
        double horas;
        int numeroTarea;
        do {
            System.out.println("Introduzca el nuevo número de referencia de la tarea a Editar: ");
            numeroTarea = sc.nextInt();
        } while (numeroTarea < 1 || numeroTarea > tareas.size());
        
        Tarea tarea = tareas.get(numeroTarea - 1);
        
        do {
            System.out.println("Introduzca el nuevo número de horas: ");
            horas = sc.nextDouble();
        } while (horas <= 0);
        
        tarea.setHoras(horas);
        System.out.println("Horas actualizadas");
        System.out.println("");
        guardarTareas();
    }

    public static void empezarTarea() {
        Scanner sc = new Scanner(System.in);
        double horas;
        int numeroTarea;
        do {
            System.out.println("Introduzca el nuevo número de referencia de la tarea a Empezar: ");
            numeroTarea = sc.nextInt();
        } while (numeroTarea < 1 || numeroTarea > tareas.size());
        
        Tarea tarea = tareas.get(numeroTarea - 1);
        
        tarea.setEstado(1);
        System.out.println("Estado de la Tarea actualizado");
        System.out.println("");
        guardarTareas();
    }

    public static void completarTarea() {
        Scanner sc = new Scanner(System.in);
        double horas;
        int numeroTarea;
        do {
            System.out.println("Introduzca el nuevo número de referencia de la tarea a Finalizar: ");
            numeroTarea = sc.nextInt();
        } while (numeroTarea < 1 || numeroTarea > tareas.size());
        
        Tarea tarea = tareas.get(numeroTarea - 1);
        
        tarea.setEstado(2);
        System.out.println("Estado de la Tarea actualizado");
        System.out.println("");
        guardarTareas();
    }

    public static void guardarTareas() {
        try {
            FileOutputStream fos = new FileOutputStream("./tareas.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Tarea tarea : tareas) {
                oos.writeObject(tarea);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar las tareas: " + e.getMessage());
        }
    }

}
