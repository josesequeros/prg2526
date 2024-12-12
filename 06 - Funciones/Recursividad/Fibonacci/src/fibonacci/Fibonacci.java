/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        System.out.println("Serie de Fibonacci");

        System.out.println("Introduce el número de término a mostrar de la sucesion de Fibonacci: ");
        int termino = entrada.nextInt();

        fibonacci(termino);
        System.out.println("");
        int valor = fibonacciTermino(termino);
        System.out.println("Valor del término: " + termino + " = " + valor);
        valor = fibonacciTerminoRecursiva(termino);
        System.out.println("Valor del término: " + termino + " = " + valor);

    }

    public static void fibonacci(int termino) {
        int a1 = 1, a2 = 1;
        System.out.print(a1 + " ");
        System.out.print(a2 + " ");
        int n = 2;
        while (n < termino) {
            int an = a1 + a2;
            System.out.print(an + " ");
            a1 = a2;
            a2 = an;
            n++;
        }

    }

    public static int fibonacciTerminoRecursiva(int termino) {
        if (termino <= 2) {
            return 1;
        }
        return fibonacciTerminoRecursiva(termino - 1) + fibonacciTerminoRecursiva(termino - 2);
    }

    public static int fibonacciTermino(int termino) {
        int a1 = 1, a2 = 1;
        int an = 0;
        //System.out.println(a1);
        //System.out.println(a2);
        int n = 2;
        while (n < termino) {
            //System.out.println(an);
            an = a1 + a2;
            a1 = a2;
            a2 = an;
            n++;
        }
        return an;
    }

}
