/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg11.cadenas;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Cadenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cadena = "Esto es una cadena";
        Scanner teclado = new Scanner(System.in);

        System.out.println(cadena);
        System.out.println("Ejercicio 11");
        System.out.println("Introduzca una cadena: ");
        //cadena = teclado.nextLine();
        System.out.println(cadena);
        System.out.println("");

        System.out.println("Ejercicio 12");
        for (int i = 0; i < cadena.length(); i++) {
            System.out.print(cadena.charAt(i) + " ");
        }
        System.out.println("");
        System.out.println("");

        System.out.println("Ejercicio 13");
        for (int i = cadena.length() - 1; i >= 0; i--) {
            System.out.print(cadena.charAt(i) + " ");
        }
        System.out.println("");
        System.out.println("");

        System.out.println("Ejercicio 14");
        int vocales = 0;
        for (int i = 0; i < cadena.length(); i++) {
            switch (cadena.toLowerCase().charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vocales++;
                    break;
            }
        }
        System.out.println("Total de vocales: " + vocales);
        System.out.println("");

        System.out.println("Ejercicio 15");
        int mayusculas = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                mayusculas++;
            }
        }
        System.out.println("Total de Mayúsculas: " + mayusculas);
        System.out.println("");

        System.out.println("Ejercicio 16");
        int espacios = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c == ' ') {
                espacios++;
            }
        }
        System.out.println("Total de espacios: " + espacios);
        System.out.println("");

        System.out.println("Ejercicio 17");
        int digitos = 0;
        cadena = "012345 casa 22";
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c >= '0' && c <= '9') {
                digitos++;
            }
        }
        if (digitos > 0) {
            System.out.println("Hay digitos");
        }
        System.out.println("Total de digitos: " + digitos);
        System.out.println("");

        System.out.println("Ejercicio 18");
        int numeros = 0;
        boolean esNumero = false;

        cadena = "Entre el número 1 y el número 20";
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c >= '0' && c <= '9') {
                if (!esNumero) {
                    numeros++;
                    esNumero = true;
                }
            }
            else {
                esNumero = false;
            }
        }
        System.out.println("Total de numeros: " + numeros);
        System.out.println("");
    }

}
