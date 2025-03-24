/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2evejercicio4;

/**
 *
 * @author jabue
 */
public class Examen2evEjercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaIntEnlazada lista = new ListaIntEnlazada();
        
        lista.insertarSinRepetidos(1, false);
        lista.insertarSinRepetidos(1, true);
        lista.insertarSinRepetidos(2, true);
        lista.insertarSinRepetidos(5, true);
        lista.insertarSinRepetidos(10, false);
        lista.insertarSinRepetidos(15, false);
        lista.insertarSinRepetidos(20, true);
        lista.insertarSinRepetidos(25, true);
        lista.insertarSinRepetidos(20, true);
        
        System.out.println("Contenido de la Lista:");
        System.out.println(lista);
    }
    
}
