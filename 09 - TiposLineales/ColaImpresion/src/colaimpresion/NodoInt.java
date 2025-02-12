/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colaimpresion;

/**
 *  Clase NodoInt: 
 *  Nodo de una secuencia enlazada, con dato de tipo int
 *  y un enlace al nodo siguiente.
 *  @author Jose
 *  @version 2023
 */
class NodoInt {
    int dato;
    NodoInt siguiente;

	/** Crea un nodo con un dato de tipo int sin enlazar. 
     *  @param dato es un int, dato del nuevo nodo.
     */ 
    NodoInt(int dato) {
        this.dato = dato;
        siguiente = null;
    }

	/** Crea un nodo con un dato dato de tipo int,
     *  enlazado a un nodo existente. 
     *  @param dato int, dato del nuevo nodo.
     *  @param nodo NodoInt, con el que enlazar el nuevo nodo.
     */
    NodoInt(int dato, NodoInt nodo) {
        this.dato = dato;
        siguiente = nodo;
    }
}
