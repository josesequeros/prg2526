/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colaimpresion;

/**
 *  Clase NodoString: 
 *  Nodo de una secuencia enlazada, con dato de tipo String
 *  y un enlace al nodo siguiente.
 *  @author Jose
 *  @version 2023
 */
class NodoString {
    String dato;
    NodoString siguiente;

	/** Crea un nodo con un dato String dato sin enlazar. 
     *  @param dato es un String, dato del nuevo nodo.
     */ 
    NodoString(String dato) {
        this.dato = dato;
        siguiente = null;
    }

	/** Crea un nodo con un dato dato de tipo String,
     *  enlazado a un nodo existente
     *  @param dato String, dato del nuevo nodo.
     *  @param nodo NodoString, con el que enlazar el nuevo nodo.
     */
    NodoString(String dato, NodoString nodo) {
        this.dato = dato;
        siguiente = nodo;
    }
}
