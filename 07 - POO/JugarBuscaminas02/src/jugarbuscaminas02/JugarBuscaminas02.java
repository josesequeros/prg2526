/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jugarbuscaminas02;

import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class JugarBuscaminas02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dimension, totalMinas;
        
        System.out.println("");
        System.out.print("Introduce Dimensión del tablero: ");
        dimension = in.nextInt();
        System.out.print("Introduce El número de minas a colocar: ");
        totalMinas = in.nextInt();
        
        BuscaMinas partida = new BuscaMinas(dimension, totalMinas);
        partida.jugar();
    }
    
}
