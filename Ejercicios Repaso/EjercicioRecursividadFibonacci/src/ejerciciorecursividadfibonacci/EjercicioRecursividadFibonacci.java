/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciorecursividadfibonacci;

/**
 *
 * @author ja.buenoseva
 */
public class EjercicioRecursividadFibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 20;
        System.out.println("El elemento " + n + " de la serie de Fibonacci es: " + fibonacci(n));
        System.out.println("Los elementos hasta " + n + " son: ");
        for (int i = 0; i <= n; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println("");
        for (int i = 0; i <= n; i++) {
            System.out.printf("%5d", fibonacci(i));
        }
        System.out.println("");
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}
