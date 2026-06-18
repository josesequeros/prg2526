/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursividad;

import java.util.Scanner;

/**
 *
 * @author josgimgar3
 */
public class Recursividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner dato = new Scanner(System.in);
        System.out.print("Introduce el tamaño de la matriz: ");
        int t = dato.nextInt();

        int matriz[][] = new int[t][t];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        int res = sumaMatriz(matriz, 0, 0, 0, t - 1);

        System.out.println("Suma total: " + res);

    }

    public static int sumaMatriz(int[][] matriz, int cu, int cur1, int cur2, int tope) {
        
        if (cur1 == tope && cur2 == tope) {
            cu += matriz[cur1][cur2];
            return cu;
        }else{
            cu += matriz[cur1][cur2];
            System.out.println(matriz[cur1][cur2]);
            if(cur1 == tope){
                cur1 = 0;
                cur2++;
            }else{
                cur1++;
            }
            return sumaMatriz(matriz, cu, cur1, cur2, tope);
        }
        
    }
}
