/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testpilasgenericas01;

import java.util.NoSuchElementException;

/**
 *
 * @author IEUser
 */
public class Pila<Item> {

    private Nodo cima;
    private int talla;

    /**
     * Crea una pila vacía.
     */
    public Pila() {
        cima = null;
        talla = 0;
    }

    /**
     * Apila x en la cima de la pila.
     *
     * @param int x, el valor a apilar.
     */
    public void apilar(Item x) {
        cima = new Nodo(x, cima);
        talla++;
    }

    /**
     * Desapila y devuelve el elemento de la cima de la pila.
     *
     * @return int, la cima de la pila antes de desapilar.
     * @throws NoSuchElementException si la pila está vacía.
     */
    public Item desapilar() {
        if (cima == null) {
            throw new NoSuchElementException("Pila vacía");
        }
        Item x = cima.dato;
        cima = cima.siguiente;
        talla--;
        return x;
    }

    /**
     * Devuelve el elemento en la cima de la pila.
     *
     * @return int, la cima de la pila.
     * @throws NoSuchElementException si la pila está vacía.
     */
    public Item cima() {
        if (cima == null) {
            throw new NoSuchElementException("Pila vacía");
        }
        return cima.dato;
    }

    /**
     * Comprueba si la pila está vacía.
     *
     * @return boolean, true si la pila está vacía y false en caso contrario.
     */
    public boolean esVacia() {
        return (cima == null);
    }

    /**
     * Devuelve la talla de la pila.
     *
     * @return int, la talla.
     */
    public int talla() {
        return talla;
    }

    @Override
    public String toString() {
        return "Pila{" + "cima=" + cima + ", talla=" + talla + '}';
    }
    
    public void mostrarPila() {
        Nodo aux = cima;
        System.out.print("Cima -> ");
        while (aux != null){
            System.out.print(aux.dato+" -> ");
            aux = aux.siguiente;
        }
        System.out.println("");
    }

    public class Nodo {

        private Item dato;
        private Nodo siguiente;

        Nodo(Item x, Nodo siguiente) {
            this.dato = x;
            this.siguiente = siguiente;
        }

        @Override
        public String toString() {
            return "Nodo{" + "dato=" + dato + '}';
        }
    }

}
