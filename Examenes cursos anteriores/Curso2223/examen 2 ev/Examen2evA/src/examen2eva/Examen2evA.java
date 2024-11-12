/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2eva;

import examen2eva.clases.Personal;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class Examen2evA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Personal> lista = new ArrayList<>();

        System.out.println("COMPROBACIÓN DE NOMBRES Y CORREOS:");
        System.out.println("----------------------------------");
        lista = leerPersonal(".\\src\\examen2eva\\archivos\\personal.txt");

        Personal aux;
        System.out.println("");
        System.out.println("COMPROBACIÓN DE CORREOS:");
        System.out.println("------------------------");
        aux = Personal.buscarPersonal(lista, "vdykaro@pbs.org");
        if (aux != null) {
            System.out.println("Localizado: " + aux);
        } else {
            System.out.println("null");
        }
        aux = Personal.buscarPersonal(lista, "pedro@cdbaby.com");
        if (aux != null) {
            System.out.println(aux.toString());
        } else {
            System.out.println("null");
        }
        aux = Personal.buscarPersonal(lista, "csabynd@vk.com");
        if (aux != null) {
            System.out.println(aux.toString());
        } else {
            System.out.println("null");
        }

        System.out.println("");
        System.out.println("CINCO OBJETOS PERSONAL ALEATORIOS:");
        System.out.println("----------------------------------");
        ArrayList<Personal> lista5 = Personal.aleatorios5(lista);
        for (int i = 0; i < lista5.size(); i++) {
            System.out.println(lista.get(i));
        }

    }

    public static ArrayList<Personal> leerPersonal(String nomFich) {
        ArrayList<Personal> lista = new ArrayList<>();
        // Declarando el Scanner en el try tenemos el cierre automático del mismo
        try ( Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US)) {
            //Scanner f = new Scanner (new File("archivos/personal.txt"));
            while (f.hasNext()) {
                String linea = f.nextLine();
                String[] partes = linea.split("\\t");
                String email = partes[0];
                String apellidos = partes[1];
                Personal personal = new Personal(apellidos, email);
                if (personal.getApellidos() != null) {
                    lista.add(personal);
                }
            }
            //f.close();      
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            return lista;
        }
    }

}
