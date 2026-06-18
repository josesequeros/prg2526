/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package directoriotamano;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ja.buenoseva
 */
public class DirectorioTamano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Introduzca el nombre de un Directorio (Carpeta) o Fichero: ");
        Scanner input = new Scanner(System.in);
        String directorio = input.nextLine();

        // Display the size
        System.out.println(obtenerTamano(new File(directorio)) + " bytes");
    }

    private static Long obtenerTamano(File file) {
        long size = 0; 

        if (file.isDirectory()) {   // Caso Recursivo, tiene una llamada Recursiva
            File[] files = file.listFiles(); 
            for (int i = 0; i < files.length; i++) {
                size += obtenerTamano(files[i]); // Llamada Recursiva
            }
        } else { // Caso Base
            size += file.length();
        }

        return size;
    }

}
