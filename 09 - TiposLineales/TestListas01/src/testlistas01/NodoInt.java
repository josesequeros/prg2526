/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testlistas01;

/**
 *
 * @author jabue
 */
public class NodoInt {

    int dato;
    NodoInt siguiente;

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
