/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg02.buscar;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class Buscar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] b;
        int elementos = 10;
        b = new int[elementos];
        int numero; 
        int total = 0;
        Scanner entrada = new Scanner(System.in);
        
        
        System.out.print("Introduce el número a buscar en el array: ");
        numero = entrada.nextInt();
        
        for (int i = 0; i < elementos; i++) { 
            b[i] = (int) (1 + Math.random() * 10);
        }
        for (int i = 0; i < elementos; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < elementos; i++) {
            if (b[i] == numero) {
                total++;
            }
        }
        System.out.println(total);
        System.out.println("El número: " + numero + " Aparece: " + total);
    }
    
}
