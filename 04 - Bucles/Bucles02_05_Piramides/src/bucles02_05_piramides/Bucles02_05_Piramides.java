/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bucles02_05_piramides;

/**
 *
 * @author ja.buenoseva
 */
public class Bucles02_05_Piramides {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int totalFilas = 6;
        for (int fila = 1; fila <= totalFilas; fila++) {
            for (int columna = 1; columna <= fila; columna++) {
                System.out.printf("%2d",columna);
            }
            for (int espacios = 1; espacios <= totalFilas-fila; espacios++) {
                System.out.print("..");
            }
            System.out.print("  ");
            
            for (int columna = 1; columna <= totalFilas - fila+1; columna++) {
                System.out.printf("%2d",columna);
            }
            for (int espacios = 1; espacios < fila; espacios++) {
                System.out.print("..");
            }    
            System.out.print("  ");
            
            for (int espacios = 1; espacios <= totalFilas-fila; espacios++) {
                System.out.print("..");
            }            
            for (int columna = fila; columna >= 1; columna--) {
                System.out.printf("%2d",columna);
            }            
            
            
            System.out.print("  ");
            
            for (int espacios = 1; espacios < fila; espacios++) {
                System.out.print("..");
            }             
            for (int columna = 1; columna <= totalFilas - fila+1; columna++) {
                System.out.printf("%2d",columna);
            }
               
            System.out.println("");
        }
    }
    
}
