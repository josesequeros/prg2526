/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bucles.pkg11;

/**
 *
 * @author jossev
 */
public class Bucles11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x = 1;
        double numeroE = 0;
        int n = 10;
        double suma = 0;
        
        int factorial = 1;
        
        for (int i = 0; i < n; i++) {
            factorial = 1;
            for (int j = 1; j <= i; j++) {
                factorial = factorial * j;
            }
            suma += Math.pow(x, i)/factorial;
        }
        System.out.println("e elevado a " + x + " = " + suma);
    }
    
}
