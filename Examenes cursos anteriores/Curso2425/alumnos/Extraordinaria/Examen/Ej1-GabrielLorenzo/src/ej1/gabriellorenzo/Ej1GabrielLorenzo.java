/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej1.gabriellorenzo;

/**
 *
 * @author gablorber
 */
public class Ej1GabrielLorenzo {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        int[] a = {3, 6, 12, 24,48};
        System.out.println(esProgresion(a, 0, 2));  
        int[] b = {3, 6, 12, 33,48};
        System.out.println(esProgresion(b, 0, 2));  
    }
    public static boolean esProgresion(int[] numeros, int pos, int x) {
        if (pos >= numeros.length - 1) {
            return true;
        }

        if (numeros[pos + 1] != numeros[pos]*x) {
            return false;
        }

        return esProgresion(numeros, pos + 1, x);
    }

    
}
