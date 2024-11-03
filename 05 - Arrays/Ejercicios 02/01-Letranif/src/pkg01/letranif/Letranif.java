/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg01.letranif;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class Letranif {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char[] miLista = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        char letra;
        int dni;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduce el DNI: ");
        dni = entrada.nextInt();
        letra = miLista[dni%23];

        System.out.println("La letra correspondiente al DNI:" + dni + " es: " + letra);
    }
    
}
