/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lingo;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ja.buenoseva
 */
public class Lingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String palabra = "cinco";
        String palabraOculta = "-----";
        int totalIntentos = 5;
        int intento = 0;
        Scanner entrada = new Scanner(System.in);
        String linea;
        boolean acertada = false;

        while (intento < totalIntentos && !acertada) {
            intento++;
            System.out.println("Intento: " + intento);
            System.out.print("Introduzca palabra: ");
            linea = entrada.nextLine();
            if (palabra.equals(linea)) {
                System.out.println("Acertada");
                acertada = true;
            } else {
                System.out.println(Arrays.toString(linea.toCharArray()));
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == linea.charAt(i)) {
                        System.out.println(linea.charAt(i) + " esta en la posicion correcta");
                    } else {
                        boolean esta = false;
                        for (int j = 0; j < palabra.length(); j++) {
                            if (palabra.charAt(j) == linea.charAt(i)) {
                                esta=true;
                            }
                        }
                        if (esta) {
                            System.out.println(linea.charAt(i) + " esta en la otra posicion");
                        } else {
                            System.out.println(linea.charAt(i) + " No esta en la palabra");
                        }
                    }
                }
            }
            
        }

    }

}
