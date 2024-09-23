/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlestructurasa3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class ControlEstructurasA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduzca Letra: ");
        String letra = teclado.nextLine();

        System.out.println("");
        System.out.println("Variante 2");
        //System.out.println(letra.charAt(0) - 'A');
        switch (letra) {
            case "A", "B", "C" ->
                System.out.println("Le corresponde el 2");
            case "D", "E", "F" ->
                System.out.println("Le corresponde el 3");
            case "G", "H", "I" ->
                System.out.println("Le corresponde el 4");
            case "J", "K", "L" ->
                System.out.println("Le corresponde el 5");
            case "M", "N", "O" ->
                System.out.println("Le corresponde el 6");
            case "P", "Q", "R", "S" ->
                System.out.println("Le corresponde el 7");
            case "T", "U", "V" ->
                System.out.println("Le corresponde el 8");
            case "W", "X", "Y", "Z" ->
                System.out.println("Le corresponde el 9");
            default ->
                System.out.println("Letra no valida");
        }
        /*
        switch (letra) {
            case "A":
            case "B":
            case "C":
                System.out.println("Le corresponde el 2");
                break;
            case "D":
            case "E":
            case "F":
                System.out.println("Le corresponde el 3");
                break;
            case "G":
            case "H":
            case "I":
                System.out.println("Le corresponde el 4");
                break;
            case "J":
            case "K":
            case "L":
                System.out.println("Le corresponde el 5");
                break;
            case "M":
            case "N":
            case "O":
                System.out.println("Le corresponde el 6");
                break;
            case "P":
            case "Q":
            case "R":
            case "S":
                System.out.println("Le corresponde el 7");
                break;
            case "T":
            case "U":
            case "V":
                System.out.println("Le corresponde el 8");
                break;
            case "W":
            case "X":
            case "Y":
            case "Z":
                System.out.println("Le corresponde el 9");
                break;
            default:
                System.out.println("Letra no valida");
                break;
        }
         */
        // Variante1.2
        System.out.println("");
        System.out.println("Variante 2");
        int numero = (int) ((letra.charAt(0) - 'A') / 3) + 2;
        if (numero > 1 && numero < 10) {
            System.out.println("Numero: " + numero);
        } else {
            System.out.println("Letra no valida");
        }
    }

}
