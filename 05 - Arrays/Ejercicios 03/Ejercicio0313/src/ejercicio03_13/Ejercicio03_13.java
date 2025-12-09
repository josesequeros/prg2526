/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio03_13;

/**
 *
 * @author ja.buenoseva
 */
public class Ejercicio03_13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n= 5;
        int m = 3;
        int a[][] = new int[n][m];
        int b[][] = new int[m][n];
        int p[][] = new int[n][n];
        
        System.out.println("Matriz A");
        for (int f = 0; f < n; f++) {
            for (int c = 0; c < m; c++) {
                a[f][c] = (int) (Math.random()*3+1);
                System.out.printf("%2d",a[f][c]);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Matriz B");
        for (int f = 0; f < m; f++) {
            for (int c = 0; c < n; c++) {
                b[f][c] = (int) (Math.random()*3+1);
                System.out.printf("%2d",b[f][c]);
            }
            System.out.println("");
        }
        System.out.println("");
     
        System.out.println("Matriz P");
        for (int f = 0; f < n; f++) {
            int suma = 0;
            for (int c = 0; c < n; c++) {
                for (int i = 0; i < m; i++) {
                    suma += a[f][i]*b[i][c];
                }
                p[f][c] = suma;
                System.out.printf("%3d",p[f][c]);
            }
            System.out.println("");
        }
        System.out.println("");        
        
    }
    
}
