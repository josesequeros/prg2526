/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jabue
 */
public class Ejercicio_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String origen = "origen.txt";
        String destino = "destino.txt";
        String oldStr = "que";
        String newStr = "para";
        
        reemplazarTexto(origen, destino, oldStr, newStr);
    }
    
    
    public static void reemplazarTexto(String entrada, String salida, String textoOriginal, String textoReemplazado) {
        // Comprobar si existe el fichero fuente        
        File sourceFile = new File(entrada);
        if (!sourceFile.exists()) {
            System.out.println("El archivo fuente " + entrada + " no existe");
            //System.exit(2);
        }

        // Comprobar si existe el archivo de destino
        File targetFile = new File(salida);
        if (targetFile.exists()) {
            System.out.println("El archivo de destino " + salida + " ya existe");
            //System.exit(3);
        }

        try (   // Crear archivos de entrada y salida
                Scanner input = new Scanner(sourceFile); 
                PrintWriter output = new PrintWriter(targetFile);
                ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replace(textoOriginal, textoReemplazado);
                output.println(s2);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Excep.: " + ex.getMessage());
        }
    }
}
