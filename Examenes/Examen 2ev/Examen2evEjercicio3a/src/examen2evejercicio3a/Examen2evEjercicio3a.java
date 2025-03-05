/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2evejercicio3a;

/**
 *
 * @author jabue
 */
public class Examen2evEjercicio3a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // maximo 3 y 12 --> la n no puede ser mayor de 3
        long n = ackerman(3, 12);
        System.out.println(n);
        System.out.println("");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(decimaABinario(Integer.MAX_VALUE));
    }

    private static long ackerman(long m, long n) {
        long resultado = 0;

        if (m == 0) {
            return (long) n + 1;
        }
        if (n == 0) {
            return ackerman(m - 1, 1);
        }
        return ackerman(m - 1, ackerman(m, n - 1));
    }

    private static String decimaABinario(int n) {
        if (n < 2) {
            return "" + n;
        }
        return (decimaABinario(n / 2) + n % 2);
    }

}
