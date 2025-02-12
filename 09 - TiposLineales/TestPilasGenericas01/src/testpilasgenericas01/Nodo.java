/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testpilasgenericas01;

/**
 *
 * @author IEUser
 */
public class Nodo<Item> {

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
