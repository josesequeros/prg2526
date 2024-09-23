/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios05;

/**
 *
 * @author jabue
 */
public class Ejercicios05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a, u, n, r;
        u = 16;
        a = 1;
        n = 6;
        System.out.println("Serie: 1,4,7,10,13,16,19,...");
        System.out.println("u = " + u);
        System.out.println("a = " + a);
        System.out.println("n = " + n);
        r = (u - a) / (n - 1);
        System.out.println("r = " + r);
        u = a + (87 -1) * r;
        System.out.println("El termino 87 es: " + u);

    }

}
