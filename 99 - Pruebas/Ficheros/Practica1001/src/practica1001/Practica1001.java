/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1001;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author jabue
 */
public class Practica1001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opc;
        do {
            opc = menu();
            switch (opc) {
                case 1:
                    entradaDiario();
                    break;
                case 2:
                    verEntradas();
                    break;
                case 3:
                    System.out.println("Finalizado el programa");
                    break;
                default:
                    System.out.println("Opcion equivocada");
            }
        } while (opc != 3);

        System.out.println();
    }

    public static int menu() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("BIENVENIDO AL DIARIO DE Cristian");
        System.out.println("1.- Nueva entrada del diario");
        System.out.println("2.- Ver entradas");
        System.out.println("3.- Salir");

        opcion = sc.nextInt();

        return opcion;
    }

    public static void entradaDiario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el texto de la entrada: ");
        String entrada = sc.nextLine();

        try {
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
            String archivo = ahora.format(formato) + ".txt";
            PrintWriter salida = new PrintWriter("./ficheros/" + archivo);
            salida.println(entrada);
            salida.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void verEntradas() {
        File origen = new File("./ficheros/");
        String[] lista = new String[1];
        if (origen.isDirectory()) {
            lista = origen.list();
            for (int i = 0; i < lista.length; i++) {
                System.out.println(i + " " + lista[i]);
            }
        } else {
            System.out.println("Origen no encontrado");
        }

        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Introduce numero de fichero a visualizar: ");
            opcion = sc.nextInt();
        } while (opcion > lista.length || opcion < 0);
        
        
        try {
            FileReader fr = new FileReader(origen + "/" + lista[opcion]);
            Scanner entrada = new Scanner(fr);
            while (entrada.hasNext()) {
                String cadena = entrada.nextLine();
                System.out.println(cadena);
            }
            System.out.println("");
            entrada.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
