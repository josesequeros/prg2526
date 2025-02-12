/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdeque;

/**
 *
 * @author IEUser
 */
public class TestDeque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Deque deque = new Deque<Integer>();
        System.out.println("Recien creado");
        if (deque.isEmpty()) {
            System.out.println("el deque está vacío.");
        }
        System.out.println("Añadimos 10 elementos al deque.");
        for (int i = 0; i < 10; i++) {
            deque.addFirst(i);
        }
        System.out.println("Nostrando cola:");
        deque.mostrarCola();
        System.out.println("Nostrando Pila:");
        deque.mostrarPila();
        System.out.println("Sacando elemento de la cola:");
        System.out.println(deque.getFirst());
        System.out.println("Nostrando cola:");
        deque.mostrarCola();
        System.out.println("Sacando elemento de la cola:");
        System.out.println(deque.getFirst());
        System.out.println("Sacando dos elementos de la pila:");
        System.out.println(deque.getLast());
        System.out.println(deque.getLast());

        if (deque.isEmpty()) {
            System.out.println("el deque está vacío.");
        } else {
            System.out.println("El deque tiene: ");
            deque.mostrarCola();
        }
        System.out.println("Añadimos 4 elementos al principio. ");
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);
        deque.addFirst(40);
        System.out.println("Nostrando cola:");
        deque.mostrarCola();
        System.out.println("Nostrando Pila:");
        deque.mostrarPila();
    }

}
