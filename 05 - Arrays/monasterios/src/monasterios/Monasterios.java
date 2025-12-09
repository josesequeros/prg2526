/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package monasterios;

import java.util.Arrays;

/**
 *
 * @author ja.buenoseva
 */
public class Monasterios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int total = 10;
        int totalMonasterios = 0;

        int alturas[] = new int[total];

        for (int i = 0; i < total; i++) {
            alturas[i] = (int) (Math.random()*1000+500);
        }
        for (int i = 0; i < total; i++) {
            boolean vistaLibre = true;
            for (int j = i; j < total; j++) {
                if (alturas[j] > alturas[i]) {
                    vistaLibre = false;
                    break;
                }
            }
            if (vistaLibre) {
                totalMonasterios++;
            }
        }
        System.out.println(Arrays.toString(alturas));
        System.out.println("");
        System.out.println("Total de Monasterios: " + totalMonasterios);
        
    }

}
