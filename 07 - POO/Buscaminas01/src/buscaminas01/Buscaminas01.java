/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buscaminas01;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class Buscaminas01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in = new Scanner(System.in);
        int dimension, totalMinas;
        
        System.out.println("");
        System.out.print("Introduce Dimensión del tablero: ");
        dimension = in.nextInt();
        System.out.print("Introduce El número de minas a colocar: ");
        totalMinas = in.nextInt();
        
        BuscaMinas partida = new BuscaMinas(dimension);
        partida.setNumeroMinas(totalMinas);
        partida.colocarMinas();
        //partida.mostrarCampo();
        partida.jugar();
        
    }
   
}
