/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notasmateria;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class NotasMateria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // número máximo de alumnos
        int numeroAlumnos = 5;

        String alumnos[];// = new String[numeroAlumnos];
        alumnos = new String[]{"Pepe", "Juan", "", "", ""};
        int notas[] = new int[numeroAlumnos];
        int opc = 0;
        do {
            opc = menu();
            switch (opc) {
                case 1 ->
                    addAlumno(alumnos);
                case 2 -> {
                    int posicion = buscarAlumno(alumnos);
                    if (posicion >= 0) {
                        System.out.println("");
                        System.out.println("Datos del alumno: " + alumnos[posicion]);
                        System.out.println("Nota: " + notas[0]);
                        System.out.println("");
                    }
                }
                case 3 -> {
                    deleteAlumno(alumnos, notas);
                }
                case 4 ->
                    listarAlumnos(alumnos);
                case 5 -> {
                    listarNotas(alumnos, notas);
                }
                case 6 -> {
                    establecerNota(alumnos, notas);
                }
            }
        } while (opc != 0);

    }

    private static int menu() {
        Scanner entrada = new Scanner(System.in);
        int opc = 0;
        boolean primera = true;

        String opciones[] = {
            "Salir",
            "Insertar Alumno",
            "Buscar Alumno",
            "Borrar Alumno",
            "Listar Alumnos",
            "Listar Notas",
            "Establecer Nota"
        };
        System.out.println("Menu - Opciones disponibles");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 0) + ".- " + opciones[i]);
        }
        do {
            if (!primera) {
                System.out.print("\nOpcion no valida");
            }
            primera = false;
            System.out.println("");
            System.out.println("Seleccione una opcion: ");
            opc = entrada.nextInt();
        } while (opc > opciones.length || opc < 0);
        return opc;
    }

    private static void listarAlumnos(String[] alumnos) {
        System.out.printf("%-20s %-6s", "Nombre", "");
        System.out.println("");
        for (int i = 0; i < 20; i++) {
            System.out.print("-");
        }
        System.out.println("");
        for (int i = 0; i < alumnos.length; i++) {
            if (!alumnos[i].equals("")) {
                System.out.printf("%-20s", alumnos[i]);
                System.out.println("");
            }
        }
        System.out.println("");
    }

    private static int buscarAlumno(String[] alumnos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nBuscar Alumno");
        System.out.println("=============");
        System.out.print("Introduzca el nombre del alumno: ");
        String nombre = entrada.nextLine();

        int posicion = buscarAlumno(alumnos, nombre);

        return posicion;
    }

    private static void addAlumno(String[] alumnos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nInsertando Alumno");
        System.out.println("=================");
        System.out.print("Introduzca el nombre del alumno: ");
        String nombre = entrada.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("");
            System.out.println("El nombre no puede estar en blanco");
            System.out.println("");
        } else {
            if (buscarAlumno(alumnos, nombre) >= 0) {
                System.out.println("Ya existe el alumno: " + nombre);
                System.out.println("");
            } else {
                insertarAlumno(alumnos, nombre);
            }
        }
    }

    private static int buscarAlumno(String[] alumnos, String nombre) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    private static void insertarAlumno(String[] alumnos, String nombre) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].equals("")) {
                alumnos[i] = nombre;
                System.out.println("Alumno insertado");
                System.out.println("");
                break;
            }
        }
    }

    private static void deleteAlumno(String[] alumnos, int[] notas) {
        Scanner entrada = new Scanner(System.in);
        int posicion = -1;
        System.out.println("\nBorrar Alumno");
        System.out.println("=============");
        System.out.print("Introduzca el nombre del alumno a borrar: ");
        String nombre = entrada.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("");
            System.out.println("El nombre no puede estar en blanco");
            System.out.println("");
        } else {
            if ((posicion = buscarAlumno(alumnos, nombre)) < 0) {
                System.out.println("No existe el alumno: " + nombre);
                System.out.println("");
            } else {
                alumnos[posicion] = "";
                notas[posicion] = 0;
                System.out.println("Alumno borrado");
                System.out.println("");
            }
        }
    }

    private static void listarNotas(String[] alumnos, int[] notas) {
        System.out.println("\nListar Notas");
        System.out.println("=============");
        System.out.printf("%-20s %-4s\n", "Nombre", "Nota");
        for (int i = 0; i < 25; i++) {
            System.out.print("-");
        }
        System.out.println("");
        for (int i = 0; i < alumnos.length; i++) {
            if (!alumnos[i].equals("")) {
                System.out.printf("%-20s %4d", alumnos[i], notas[i]);
                System.out.println("");
            }
        }
        System.out.println("");
    }

    private static void establecerNota(String[] alumnos, int[] notas) {
        Scanner entrada = new Scanner(System.in);
        int posicion = -1;
        System.out.print("Introduzca el nombre del alumno a modificar nota: ");
        String nombre = entrada.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("");
            System.out.println("El nombre no puede estar en blanco");
            System.out.println("");
        } else {
            if ((posicion = buscarAlumno(alumnos, nombre)) < 0) {
                System.out.println("No existe el alumno: " + nombre);
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("Nota actual: "+ notas[posicion]);
                System.out.print("Introducir nota: ");
                int nota = entrada.nextInt();

                notas[posicion] = nota;
                System.out.println("Nota modificada");
                System.out.println("");
            }
        }
    }

}
