/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpilasgenericas02;

/**
 *
 * @author jabue
 */
public class TestPilasGenericas02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pila<Integer> miPila = new Pila();

        System.out.println("Pila creada");
        if (miPila.vacia()) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("Número de elementos de la pila: " + miPila.getTalla());
        }
        for (int i = 0; i < 5; i++) {
            miPila.apilar(i);
        }

        miPila.apilar(2);
        if (miPila.vacia()) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("Número de elementos de la pila: " + miPila.getTalla());
        }
        miPila.mostrar();
        System.out.println("");

        Pila<String> miPilaString = new Pila();

        System.out.println("Total de elementos de la pila: " + miPilaString.getTalla());

        miPilaString.apilar("uno");
        miPilaString.apilar("dos");
        miPilaString.apilar("tres");
        miPilaString.mostrar();
        if (miPilaString.vacia()) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("Total de elementos de la pila: " + miPilaString.getTalla());
        }
        System.out.println("Elemento en cima: " + miPilaString.peek());
        if (miPilaString.vacia()) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("Total de elementos de la pila: " + miPilaString.getTalla());
        }

        System.out.println("Pop: " + miPilaString.pop());
        if (miPilaString.vacia()) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("Total de elementos de la pila: " + miPilaString.getTalla());
        }
        miPilaString.mostrar();
        int posicion = miPilaString.search(new Nodo("dos"));
        if (posicion != -1) {
            System.out.println("Posicion = " + posicion);
        }
        
        posicion = miPila.search(new Nodo(7));
        System.out.println("Posicion = " + posicion);
    }

}
