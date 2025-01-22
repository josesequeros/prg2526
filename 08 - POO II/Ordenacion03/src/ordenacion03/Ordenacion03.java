/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordenacion03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ordenacion03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        ArrayList<Amigo> agenda = new ArrayList<>();
        agenda = leerAmigos("nombreTelefonosCorreos.txt");
        Amigo[] agendaArray = agenda.toArray(new Amigo[agenda.size()]);
        listar(agenda);
        //ordenar un arraylist
        insercion(agenda);
        System.out.println("\nOrdenado por telefono");
        listar(agenda);
        // ordenar un array
        insercion(agendaArray);
        listar(agendaArray);
    }

    // método
    public static ArrayList<Amigo> leerAmigos(String nomFich) throws FileNotFoundException {
        // Definición de la colección “lista”
        ArrayList<Amigo> lista = new ArrayList<>();
        // Declarando el Scanner en el try tenemos el cierre automático del mismo

        Scanner f = new Scanner(new File(nomFich));
        while (f.hasNext()) {
            String linea = f.nextLine();
            // separar la línea leída usando como separador el tabulador (“\\t”)
            String[] partes = linea.split(";");
            String nombre = partes[0];
            String telefono = partes[1];
            String correo = partes[2];

            Amigo amigo = new Amigo(nombre, telefono, correo);
            lista.add(amigo);

            // añadir objeto creado a la colección
        }
        f.close();
        return lista;
    }

    public static void listar(ArrayList<Amigo> agenda) {
        for (Amigo amigo : agenda) {
            System.out.println(amigo);
        }
    }

    public static void insercion(Amigo[] a) {
        int i, j;
        Amigo aux;

        //Recorrido del array 
        for (i = 1; i < a.length; i++) {
            aux = a[i];
            for (j = i - 1; j >= 0 && aux.compareTo(a[j]) < 0; j--) {
                a[j + 1] = a[j];
                a[j] = aux; //inserción del elemento analizado en cada iteración
            }
        }
    }

    public static void insercion(ArrayList<Amigo> a) {
        int i, j;
        Amigo aux;

        //Recorrido del array 
        for (i = 1; i < a.size(); i++) {
            aux = a.get(i);
            for (j = i - 1; j >= 0 && aux.compareTo(a.get(j)) < 0; j--) {
                a.set(j + 1, a.get(j));
                a.set(j, aux); //inserción del elemento analizado en cada iteración
            }
        }
        //return a;
    }

    private static void listar(Amigo[] agendaArray) {
        for (Amigo amigo : agendaArray) {
            System.out.println(amigo);
        }
    }

}
