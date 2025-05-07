/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploficherotexto_reemplazartexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class EjemploFicheroTexto_ReemplazarTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String origen = "origen.txt";
        String destino = "destino.txt";
        String oldStr = "que";
        String newStr = "para";

        // Comprobar si existe el fichero fuente        
        File sourceFile = new File(origen);
        if (!sourceFile.exists()) {
            System.out.println("El archivo fuente " + origen + " no existe");
            System.exit(2);
        }

        // Comprobar si existe el archivo de destino
        File targetFile = new File(destino);
        if (targetFile.exists()) {
            System.out.println("El archivo de destino " + destino + " ya existe");
            System.exit(3);
        }

        try (
                // Crear archivos de entrada y salida
                Scanner input = new Scanner(sourceFile); PrintWriter output = new PrintWriter(targetFile);) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(oldStr, newStr);
                output.println(s2);
            }
        }
    }

}
