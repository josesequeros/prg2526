/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quijotereves;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class QuijoteReves {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nombre de fichero: ");
        String nombreFichero = teclado.nextLine().trim();

        Pila<String> pila = new Pila<>();
        ListaGenerica<Pila> lista = new ListaGenerica<>();
        int palabras = leerFichero(nombreFichero, pila, lista);
        //int palabras = leerFicheroPila(nombreFichero, pila, lista);
        System.out.println("Total de palabras: " + palabras);
        //pila.leerPila();
        lista.mostrarLista();
        //pila.mostrarPila();

    }

    public static int leerFichero(String nomFich, Pila pila, ListaGenerica lista) throws FileNotFoundException {
        // A COMPLETAR POR EL ALUMNO ...
        int total = 0;
        Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
        while (f.hasNext()) {
            String linea = f.nextLine();
            String[] partes = linea.split(" ");
            total += partes.length;
            for (String parte : partes) {
                //System.out.print(parte+" ");
                pila.apilar(parte);
            }
            //lista.addNodo(pila);
            lista.encolar(pila);
            //pila.apilar("\n");
            //pila.apilar("\n");
            pila = new Pila<>();
            //System.out.println("");
        }
        f.close();
        return total;
    }
    
    public static int leerFicheroPila(String nomFich, Pila pila, ListaGenerica lista) throws FileNotFoundException {
        // A COMPLETAR POR EL ALUMNO ...
        int total = 0;
        Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
        while (f.hasNext()) {
            String linea = f.nextLine();
            String[] partes = linea.split(" ");
            total += partes.length;
            for (String parte : partes) {
                //System.out.print(parte+" ");
                pila.apilar(parte);
            }
            //lista.addNodo(pila);
            //lista.encolar(pila);
            pila.apilar("\n");
            //pila.apilar("\n");
            //pila = new Pila<>();
            //System.out.println("");
        }
        f.close();
        return total;
    }
}
