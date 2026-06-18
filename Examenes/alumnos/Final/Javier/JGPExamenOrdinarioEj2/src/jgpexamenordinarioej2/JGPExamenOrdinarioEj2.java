/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jgpexamenordinarioej2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author javgarper6
 */
public class JGPExamenOrdinarioEj2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduce una ruta:");
        String ruta = entrada.nextLine();
        
        System.out.println("Tamaño total: " + calcularTamaño(ruta));
        
        System.out.println("-------------------------------------------------");
        
        int[] matriz = {0, 1 , 2, 3, 2, 1 ,0};
        System.out.println("");
        
        System.out.println("Obteniendo...");
        System.out.println("Maximo de la matriz: " + obtenerMaximo(matriz, 0));
        
    }
    
    public static long calcularTamaño(String ruta) {
        File fichero = new File(ruta);
        System.out.println("Fichero leido: " + fichero.getAbsolutePath());
        
        long total = 0;
        
        if (fichero.isDirectory()) {
            File[] hijos = fichero.listFiles();
            
            for (File hijo : hijos) {
                total += calcularTamaño(hijo.getAbsolutePath());
            }
        } else {
            total = fichero.length();
        }
        
        System.out.println(total);
        return total;
        
    }
    
    public static int obtenerMaximo(int[] matriz, int i) {
        // se saldria del array si llega al final, pero no llegaría al ser parabolico
        if (matriz[i] > matriz[i+1]) {
            return matriz[i];
        } else {
            i++;
            return obtenerMaximo(matriz, i);
        }
    }
            
}
