/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testtextoabinario;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//import TextoABinario.TextToBinary;
/**
 *
 * @author jabue
 */
public class TestTextoABinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int cont = 0;
        Scanner input = new Scanner(System.in);
        String textFile = "primos.txt";
        String binaryFile = "primos.bin";

        /*
        System.out.print("Nombre del fichero de Texto: ");
        String textFile = input.next();
        System.out.print("Nombre del Fichero Binario: ");
        String binaryFile = input.next();
        
        TextoABinario.crearFicheroBinario(textFile, binaryFile);
         */
        try (PrintWriter output = new PrintWriter(textFile)) {
            for (int i = 1000000; i < 10000000; i++) {
                if (esPrimo(i)) {
                    //System.out.print(i + "\t");
                    output.print(i+ " ");
                    cont++;
                    if (cont % 10 == 0) {
                        //System.out.print("\n");
                        output.println();
                    }
                }
            }
        }
        System.out.println("Total: " + cont);
        // Comprobar si existe el fichero         
        File sourceFile = new File(textFile);
        if (!sourceFile.exists()) {
            System.out.println("El archivo fuente " + textFile + " no existe");
            //System.exit(2);
        } else {
            TextoABinario.crearFicheroBinario("primos.txt", "primos.bin");
        }
        

    }

    public static boolean esPrimo(int numero) {
        int divisor;
        boolean puedeSerlo;
        if (numero == 2) {
            return true;
        } else if (numero % 2 == 0) {
            return false;           // <n> no es primo
        } else {                      // Se buscan posibles divisores impares de <n>
            puedeSerlo = true;      // <n> es candidato a primo
            divisor = 3;            // primer divisor a probar
            while (puedeSerlo && divisor * divisor <= numero) {     // menor que la raíz cuadrada 
                puedeSerlo = numero % divisor > 0;                  // ¿ aún sin divisores?
                divisor = divisor + 2; 			                    // sig. divisor a probar
            }
            return puedeSerlo;
        }
    }

}
