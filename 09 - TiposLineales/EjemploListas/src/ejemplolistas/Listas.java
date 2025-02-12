/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplolistas;

/**
 *
 * @author jabue
 */
public class Listas {

    /**
     * Clase Listas: Lista de int. Implementación enlazada.
     *
     * @author
     * @version
     */
    private NodoInt primero;
    private int talla;



//
    /**
     * Clase NodoInt: representa un nodo de una secuencia enlazada que tiene un dato de tipo int y un enlace al nodo siguiente.
     *
     * @author
     * @version
     */
    public class NodoInt {

        private int dato;
        private NodoInt siguiente;

        /**
         * Crea un nodo con un dato d y sin siguiente.
         *
         * @param d int, el dato del nuevo nodo.
         */
        NodoInt(int d) {
            this.dato = d;
            siguiente = null;
        }

        /**
         * Crea un nodo con un dato d, enlazado a un nodo ya existente s.
         *
         * @param d int, el dato del nuevo nodo.
         * @param s NodoInt, con el que enlazar el nuevo nodo.
         */
        NodoInt(int d, NodoInt s) {
            dato = d;
            siguiente = s;
        }
    }

   

    /**
     * Crea una pila vacía.
     */
    public Listas() {
        primero = null;
        talla = 0;
    }

    /**
     * Apila x en la cima de la pila.
     *
     * @param int x, el valor a apilar.
     */
    public void addItem(int x) {
        primero = new NodoInt(x, primero);
        talla++;
    }
    
    public void listar() {
        NodoInt aux = primero;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }    
}
