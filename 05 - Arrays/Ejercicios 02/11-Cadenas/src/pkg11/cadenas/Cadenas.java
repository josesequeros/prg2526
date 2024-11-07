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

        // Ejercicio 11
        System.out.println(cadena);
        System.out.println("Ejercicio 11");
        System.out.println("Introduzca una cadena: ");
        //cadena = teclado.nextLine();
        System.out.println(cadena);
        System.out.println("");

        // Ejercicio 12
        System.out.println("Ejercicio 12");
        for (int i = 0; i < cadena.length(); i++) {
            System.out.print(cadena.charAt(i) + " ");
        }
        System.out.println("");
        System.out.println("");

        // Ejercicio 13
        System.out.println("Ejercicio 13");
        for (int i = cadena.length() - 1; i >= 0; i--) {
            System.out.print(cadena.charAt(i) + " ");
        }
        System.out.println("");
        System.out.println("");

        // Ejercicio 14
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

        // Ejercicio 15
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

        // Ejercicio 16
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

        // Ejercicio 17
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

        // Ejercicio 18
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
            } else {
                esNumero = false;
            }
        }
        System.out.println("Total de numeros: " + numeros);
        System.out.println("");

        // Ejercicio 19
        System.out.println("Ejercicio 19");
        numeros = 0;
        boolean bienFormado = true;

        cadena = "202";
        for (int i = 0; i < cadena.length() && bienFormado; i++) {
            char c = cadena.charAt(i);
            bienFormado = bienFormado && (c >= '0' && c <= '9' || (i == 0 && (c == '+' || c == '-')));
        }
        if (bienFormado) {
            System.out.println(cadena + " Es un Entero");
        } else {
            System.out.println(cadena + " No es un entero");
        }
        System.out.println("");

        // Ejercicio 20
        System.out.println("Ejercicio 20");
        cadena = "1000000001";
        int decimal = 0;
        int digito = 0;
        int posicion = 0;
        for (int i = cadena.length() - 1; i >= 0; i--) {
            char c = cadena.charAt(i);
            digito = c - '0';
            decimal = decimal + digito * (int) (Math.pow(2, posicion));
            posicion++;
        }
        System.out.println(cadena + " = " + decimal);
        System.out.println("");

        // Ejercicio 21
        System.out.println("Ejercicio 21");
        cadena = "77";
        decimal = 0;
        digito = 0;
        posicion = 0;
        for (int i = cadena.length() - 1; i >= 0; i--) {
            char c = cadena.charAt(i);
            digito = c - '0';
            decimal = decimal + digito * (int) (Math.pow(8, posicion));
            posicion++;
        }
        System.out.println(cadena + " = " + decimal);
        System.out.println("");

        // Ejercicio 22
        System.out.println("Ejercicio 22");
        cadena = "AA";
        decimal = 0;
        digito = 0;
        posicion = 0;
        for (int i = cadena.length() - 1; i >= 0; i--) {
            char c = cadena.charAt(i);
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    digito = c - '0';
                    decimal = decimal + digito * (int) (Math.pow(16, posicion));
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                    digito = c - 'A' + 10;
                    decimal = decimal + digito * (int) (Math.pow(16, posicion));
                    break;
            }
            posicion++;
        }
        System.out.println(cadena + " = " + decimal);
        System.out.println("");

        // Ejercicio 23
        System.out.println("Ejercicio 23");
        cadena = "immu";
        boolean esAlfabetica = true;

        posicion = 0;
        while (posicion < cadena.length() - 1 && esAlfabetica){
            esAlfabetica = cadena.charAt(posicion) <= cadena.charAt(posicion+1);
            posicion++;
        }
        if (esAlfabetica){
            System.out.println(cadena + " es Alfabetica");
        } else {
            System.out.println(cadena + " No es Alfabetica");
        }
    }
}
