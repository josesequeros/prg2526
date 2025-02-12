/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaquijote;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class PruebaQuijote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.print("Nombre de fichero: ");
        String nombreFichero = teclado.nextLine().trim();

        int palabras = leerFichero(nombreFichero);
        System.out.println("Total de palabras: " + palabras);
    }

    public static int leerFichero(String nomFich) throws FileNotFoundException {
        // A COMPLETAR POR EL ALUMNO ...
        int total = 0;
        Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
        while (f.hasNext()) {
            String linea = f.nextLine();
            String[] partes = linea.split(" ");
            total += partes.length;
            for (String parte : partes) {
                System.out.print(parte+" ");
            }
            System.out.println("");
        }
        f.close();
        return total;
    }
}
