/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg03.sumalista;

/**
 *
 * @author IEUser
 */
public class SumaLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] vectorNumeros;
        int elementos = 10;
        vectorNumeros = new int[elementos];
        int total = 0;


        for (int i = 0; i < elementos; i++) { 
            //vectorNumeros[i] = (int) (1 + Math.random() * 10);
            vectorNumeros[i] = 2 * (i+1);
        }
        for (int i = 0; i < vectorNumeros.length; i++) {
            System.out.print(vectorNumeros[i] + " ");
        }
        System.out.println();
        
        for (int i = 0; i < vectorNumeros.length; i++) {
            total += vectorNumeros[i];
        }
        System.out.println("La suma de los elementos del array es: " + total);
        System.out.println("La media de los elementos del array es: " + total/elementos);
    }
    
}
