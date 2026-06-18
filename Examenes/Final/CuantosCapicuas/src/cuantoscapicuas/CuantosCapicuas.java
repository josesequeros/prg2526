/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuantoscapicuas;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class CuantosCapicuas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        int digitos;
        int minimo, maximo;
        ArrayList<Integer> capicuas = new ArrayList<>();

        digitos = pedirdigitos();

        while (digitos > 0) {
            minimo = (int) Math.pow(10, digitos - 1);
            maximo = (int) Math.pow(10, digitos) - 1;
            System.out.println("Capicúas entre: " + minimo + " y " + maximo);
            capicuas = obtenerCapicuas(minimo, maximo);
            imprimirCapicuas(capicuas);
            System.out.println("Capicúas de " + digitos + " cifras: " + capicuas.size());

            digitos = pedirdigitos();
        }
        System.out.println("\nFin del programa.");

    }

    public static int pedirdigitos() {
        Scanner entrada = new Scanner(System.in);
        int digitos = 0;
        boolean error = true;
        while (error) {
            try {
                System.out.println("Introduzca el número de dígitos: ");
                digitos = entrada.nextInt();
                if (digitos > 9 || digitos < 0) {
                    throw new InputMismatchException();
                }
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Inroduzca un numero entre 0 y 9");
                entrada.nextLine();
            }
        }
        return digitos;
    }

    public static boolean esCapicual(int numero) {
        return numero == invertir(numero);
    }

    public static int invertir(int numero) {
        int cifra;
        int reves = 0;
        while (numero > 0) {
            cifra = numero % 10;
            reves = (int) (cifra + reves * 10);
            numero = (int) numero / 10;
        }
        return reves;
    }

    private static ArrayList<Integer> obtenerCapicuas(int minimo, int maximo) {
        ArrayList<Integer> capicuas = new ArrayList<>();

        for (int i = minimo; i <= maximo; i++) {
            if (esCapicual(i)) {
                capicuas.add(i);
            }
        }
        return capicuas;
    }

    private static void imprimirCapicuas(ArrayList<Integer> capicuas) {

        for (int i = 0; i < 5; i++) {
            if (i < capicuas.size()) {
                System.out.println(capicuas.get(i));
            }
        }
        if (capicuas.size() > 10) {
            System.out.println("...");
        }
        int pos = capicuas.size()-5;
        for (int i = 0; i < 5; i++) {
            if (pos+i > 4 && pos+i < capicuas.size()) {
                System.out.println(capicuas.get(pos+i));
            }
        }
    }

}
