/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colaimpresion;

public class Nodo<Item> {

    Item dato;
    Nodo siguiente;

    /**
     * Crea un nodo con un dato de tipo int sin enlazar.
     *
     * @param dato es un int, dato del nuevo nodo.
     */
    Nodo(Item  dato) {
        this.dato = dato;
        siguiente = null;
    }

    /**
     * Crea un nodo con un dato dato de tipo int, enlazado a un nodo existente.
     *
     * @param dato int, dato del nuevo nodo.
     * @param nodo NodoInt, con el que enlazar el nuevo nodo.
     */
    Nodo(Item  dato, Nodo nodo) {
        this.dato = dato;
        siguiente = nodo;
    }
}
