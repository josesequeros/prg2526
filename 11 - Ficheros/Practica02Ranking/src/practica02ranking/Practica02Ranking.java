/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica02ranking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author jabue
 */
public class Practica02Ranking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        ArrayList<Persona> boys = new ArrayList<>();
        ArrayList<Persona> girls = new ArrayList<>();
        ArrayList<String> lineas = new ArrayList<>();

        do {
            opcion = menu();

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    buscarRankingPersona(boys, girls);
                    break;
                case 2:
                    mostrarTabla(boys, girls);
                    break;
                case 3:
                    mostrarClasificacion();
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
                System.out.println("1. Mostar ranking del un nombre en un año");
                System.out.println("2. Mostrar tabla resumida cinco primeros");
                System.out.println("3. Mostrar tabla acumulada de los 10 años");
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

    public static void leerNombres(String nomFich, ArrayList<Persona> boys, ArrayList<Persona> girls) {
        //ArrayList<Persona> personal = new ArrayList<>();
        //Personal personal = new Personal();
        // Declarando el Scanner en el try tenemos el cierre automático del mismo
        try (Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US)) {
            //Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
            while (f.hasNext()) {
                String linea = f.nextLine();
                String[] partes = linea.split("\t");
                String posicion = partes[0];
                String nombreBoy = partes[1];
                Integer ctdBoy = Integer.valueOf(partes[2].trim());
                String nombreGirl = partes[3].trim();
                Integer ctdGirl = Integer.valueOf(partes[4].trim());
                //System.out.println("Posicion: " + posicion + " Chico: " + nombreBoy + " Chica: " + nombreGirl);
                //Persona persona = new Persona(nombre, apellido, email, genero, nacimiento, pais);
                boys.add(new Persona(nombreBoy, ctdBoy));
                girls.add(new Persona(nombreGirl, ctdGirl));
                //personal.addPersona(persona);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error leyendo datos");
            //personal = null;
        }
        // f.close
        //return personal;
    }

    private static void buscarRankingPersona(ArrayList<Persona> boys, ArrayList<Persona> girls) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el año: ");
        int year = EntradaCorrecta.nextInt(teclado, "Introduzca periodo (2001-2010): ", 2001, 2010);
        String nombreFichero = "./src/practica02ranking/" + "babynamesranking" + year + ".txt";
        leerNombres(nombreFichero, boys, girls);
        System.out.println("Introduzca sexo: ");
        String sexo = teclado.nextLine();
        System.out.println("Introduzca nombre: ");
        String nombre = teclado.nextLine();
        Persona p;
        int posicion;
        if (sexo.equals("F")) {
            p = buscarPersona(girls, nombre);
            posicion = girls.indexOf(p);

        } else {
            p = buscarPersona(boys, nombre);
            posicion = boys.indexOf(p);
        }
        if (p != null) {
            System.out.println(p + " posicion: " + ++posicion);
        } else {
            System.out.println("No existe Ese nombre");
        }
    }

    private static Persona buscarPersona(ArrayList<Persona> listaPersonas, String persona) {
        Persona aux = null;
        for (Persona p : listaPersonas) {
            if (p.getNombre().equals(persona)) {
                aux = p;
                break;
            }
        }
        return aux;
    }

    /**
     * Displays table data
     */
    public static void printLineaDatos(int year, ArrayList<Persona> b, ArrayList<Persona> g) {
        System.out.printf("%5d  ", year);
        for (int i = 0; i < 5; i++) {
            System.out.print(g.get(i).getNombre());
            relleno(g.get(i).getNombre());
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(b.get(i).getNombre() + "  ");
            relleno(b.get(i).getNombre());
        }
        System.out.println();
    }

    /**
     * Add space padding between data in table
     */
    public static void relleno(String str) {
        int space = 10 - str.length();
        for (int j = 0; j < space; j++) {
            System.out.print(" ");
        }
    }

    /**
     * Displays table header
     */
    public static void cabecera() {
        System.out.println(
                "--------------------------------------------------------"
                + "-------------------------------------------------------------\n"
                + " Year  Rank 1    Rank 2    Rank 3    Rank 4    Rank 5    "
                + "Rank 1      Rank 2      Rank 3      Rank 4      Rank 5\n"
                + "--------------------------------------------------------"
                + "-------------------------------------------------------------");
    }

    private static void mostrarTabla(ArrayList<Persona> b, ArrayList<Persona> g) {
        ArrayList<Persona> boys = new ArrayList<>();
        ArrayList<Persona> girls = new ArrayList<>();
        cabecera();
        // Testear el error de lectura, ¿donde colocar el tratamiento de las excepciones?
        for (int year = 2010; year >= 2001; year--) {
            String nombreFichero = "./src/practica02ranking/" + "babynamesranking" + year + ".txt";
            leerNombres(nombreFichero, boys, girls);
            printLineaDatos(year, boys, girls);
            boys.clear();
            girls.clear();
        }
    }

    private static void mostrarClasificacion() {
        ArrayList<Persona> boys = new ArrayList<>();
        ArrayList<Persona> girls = new ArrayList<>();
        Map<String, Integer> boysMap = new HashMap<>();
        Map<String, Integer> girlsMap = new HashMap<>();
        // Testear el error de lectura, ¿donde colocar el tratamiento de las excepciones?
        for (int year = 2010; year >= 2001; year--) {
            String nombreFichero = "./src/practica02ranking/" + "babynamesranking" + year + ".txt";
            leerNombres(nombreFichero, boys, girls);
            for (Persona girl : girls) {
                String clave = girl.getNombre();
                Integer valor = girl.getTotal();
                if (!girlsMap.containsKey(clave)) {
                    girlsMap.put(clave, valor);
                } else {
                    Integer valorAnterior = girlsMap.get(clave);
                    girlsMap.put(clave, valorAnterior + valor);
                }
                // otra forma
                // girlsMap.put(clave, girlsMap.getOrDefault(clave, 0) + valor);
            }
            for (Persona boy : boys) {
                String clave = boy.getNombre();
                Integer valor = boy.getTotal();
                if (!boysMap.containsKey(clave)) {
                    boysMap.put(clave, valor);
                } else {
                    Integer valorAnterior = boysMap.get(clave);
                    boysMap.put(clave, valorAnterior + valor);
                }
                // otra forma
                // girlsMap.put(clave, girlsMap.getOrDefault(clave, 0) + valor);
            }
        }
        // visualizar el mapa
        //girlsMap.forEach((k, v) −> System.out.println(k + "\t" + v));
        //for (String key : girlsMap.keySet()) {
        //    System.out.println(key + "\t" + girlsMap.get(key));
        //}

        // Ordenamos las chicas
        List<Map.Entry<String, Integer>> listaChicas = new ArrayList<>(girlsMap.entrySet());
        // Ordenar la lista utilizando un comparador personalizado
        Collections.sort(listaChicas, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // Orden ascendente (o1.getValue() - o2.getValue())
                // Orden descendente (o2.getValue() - o1.getValue())
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // Ordenar la lista con una expresión lambda
        // listaChicas.sort((o1,o2)->o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, Integer> sortedMapChicas = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : listaChicas) {
            sortedMapChicas.put(entry.getKey(), entry.getValue());
        }

        // Imprimir el HashMap ordenado
        System.out.println("\n10 Primeros Nombres de chicas:");
        int i = 1;
        for (Map.Entry<String, Integer> entry : sortedMapChicas.entrySet()) {
            System.out.println(i++ + " --> \t" + entry.getKey() + ":    \t" + entry.getValue());
            if (i > 10) {
                break;
            }
        }
        
        // Ordenamos las chicos
        List<Map.Entry<String, Integer>> listaChicos = new ArrayList<>(boysMap.entrySet());
        // Ordenar la lista utilizando un comparador personalizado
        Collections.sort(listaChicos, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // Orden ascendente (o1.getValue() - o2.getValue())
                // Orden descendente (o2.getValue() - o1.getValue())
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // Ordenar la lista con una expresión lambda
        // listaChicos.sort((o1,o2)->o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, Integer> sortedMapChicos = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : listaChicos) {
            sortedMapChicos.put(entry.getKey(), entry.getValue());
        }

        // Imprimir el HashMap ordenado
        System.out.println("\n10 Primeros Nombres de chicos:");
        i = 1;
        for (Map.Entry<String, Integer> entry : sortedMapChicos.entrySet()) {
            System.out.println(i++ + " --> \t" + entry.getKey() + ":   \t" + entry.getValue());
            if (i > 10) {
                break;
            }
        }
        /*
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "\t - \t" + entry.getValue());
        }
         */
    }
}
