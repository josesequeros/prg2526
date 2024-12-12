/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0206;

/**
 *
 * @author ja.buenoseva
 */
public class Ejercicio0206 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 1;
        int b = 1;

        if (perteneceA(a, b)) {
            System.out.println("(" + a + "," + b + ") Pertenece al conjunto A");
        }
        if (perteneceB(a, b)) {
            System.out.println("(" + a + "," + b + ") Pertenece al conjunto B");
        }
        if (perteneceC(a, b)) {
            System.out.println("(" + a + "," + b + ") Pertenece al conjunto C");
        }
        if (perteneceA(a, b) && perteneceB(a, b)) {
            System.out.println("(" + a + "," + b + ") Pertenece al conjunto A interseccion B");
        }
        if (perteneceA(a, b) && perteneceB(a, b) && perteneceC(a, b)) {
            System.out.println("(" + a + "," + b + ") Pertenece al conjunto A interseccion B interseccion C");
        }
        if (perteneceA(a, b) || perteneceB(a, b)) {
            System.out.println("(" + a + "," + b + ") Pertenece al conjunto A union B");
        }
        if (perteneceA(a, b) || perteneceB(a, b) || perteneceC(a, b)) {
            System.out.println("(" + a + "," + b + ") Pertenece al conjunto A union B unionC");
        }
    }

    public static boolean perteneceA(int x, int y) {
        //return (x * x + y * y <= 100);

        if (x * x + y * y <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean perteneceB(int x, int y) {
        return (x * x) / 36 + (y * y) / 25 <= 1;
    }

    public static boolean perteneceC(int x, int y) {
        return (2 * x + 4 * y) >= 1 && (2 * x + 4 * y) <= 10;
    }
}
