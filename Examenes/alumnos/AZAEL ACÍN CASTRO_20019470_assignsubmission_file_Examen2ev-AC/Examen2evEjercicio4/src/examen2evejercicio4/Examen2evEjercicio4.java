/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//para insertar un elemento valor en la ListaEnlazada en el caso deq que no existiera previamente en ella, bien al inicio de la lista,
//como primer elemento si el argumento delante es true, bien por la parte de atras, al final de la lista en el caso de que el argumento 
//delante sea false. La ListaIntEnlazada permanecera sin cambios, en el caso de que el elemento valor ya existiera inicialmente en ella

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
        // TODO code application logic here
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
        
        System.out.println("Contenido de la Lista: ");
        System.out.println(lista);
    }
    
}
