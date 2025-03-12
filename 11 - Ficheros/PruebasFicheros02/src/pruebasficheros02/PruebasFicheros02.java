/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasficheros02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jabue
 */
public class PruebasFicheros02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File f = new File("Enteros.txt");
            FileWriter fw = new FileWriter(f,false);

            int valor = 1;
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    valor = i*j;
                    fw.write("" + valor);   // escribimos valor
                    fw.write(" ");       // escribimos espacio en blanco
                    //valor = valor * 2;      // calculamos próximo valor
                }
                fw.write("\n"); // escribimos nueva línea
            }
            fw.close(); // cerramos el FileWriter
            System.out.println("Fichero escrito correctamente");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
