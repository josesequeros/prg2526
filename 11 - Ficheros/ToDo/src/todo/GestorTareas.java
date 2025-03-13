/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class GestorTareas {

    private ArrayList<Tarea> tareas;

    public GestorTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    public void creaTareas() {
        String numerosLetra[] = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};
        Tarea tarea;    // = new Tarea("Tarea uno", 10);
        //ArrayList<Tarea> listaTareas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            tarea = new Tarea("Tarea " + numerosLetra[i], 10 * (i + 1));
            this.tareas.add(tarea);
            System.out.println(tarea);
        }
        // Descomentar la línea siguiente la primera vez para tener 10 tareas creadas
        guardarTareas();
    }

    public void guardarTareas() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("./tareas.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Tarea tarea : this.tareas) {
                oos.writeObject(tarea);
                System.out.println("Tarea --> " + tarea);
            }
            fos.close();
        } catch (IOException e) {
            System.err.println("Error al guardar las tareas: " + e.getMessage());
        }
    }

    public void mostrarTareas() {
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

    public void cargarTareas() {
        ArrayList<Tarea> tareas = new ArrayList<>();
        File fichero = new File("tareas.dat");

        if (!fichero.exists()) {
            //System.out.println("Todavia no hay tareas");
        } else {
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
        }
        this.tareas = tareas;
    }

    public void empezarTarea() {
        mostrarTareas();
        int opcion = Utiles.nextInt("Seleccione numero de tarea a comenzar: ", 1, tareas.size());
        tareas.get(opcion - 1).setEstado(TipoEstado.ENPROCESO);
        mostrarTareas();
        guardarTareas();
    }

    public void editarTarea() {
        Scanner sc = new Scanner(System.in);
        double horas;
        int numeroTarea;

        numeroTarea = Utiles.nextInt("Introduzca el número de la tarea a Editar: ", 1, tareas.size());

        Tarea tarea = tareas.get(numeroTarea - 1);
        horas = Utiles.nextDoublePositivo("Introduzca el nuevo número de horas: ");

        tarea.setHoras(horas);
        System.out.println("Horas actualizadas");
        System.out.println("");
        guardarTareas();
    }

    public void nuevaTarea() {
        Scanner sc = new Scanner(System.in);
        String titulo;
        double horas;
        System.out.print("Introduzca el título de la tarea: ");
        titulo = sc.nextLine();
        
        horas = Utiles.nextDoublePositivo("Introduzca número de horas: ");
        sc.nextLine();
        // Crear una nueva tarea
        Tarea nuevaTarea = new Tarea(titulo, horas);
        tareas.add(nuevaTarea);
        mostrarTareas();
        guardarTareas();
    }

    public void completarTarea() {
        mostrarTareas();
        int opcion = Utiles.nextInt("Seleccione numero de tarea a completar: ", 1, tareas.size());
        tareas.get(opcion - 1).setEstado(TipoEstado.FINALIZADA);
        mostrarTareas();
        guardarTareas();
    }
}
