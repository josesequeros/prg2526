/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testpilasgenericas02;

/**
 *
 * @author jabue
 */
public class Nodo<Item> {

    Item dato;
    Nodo<Item> next;

    public Nodo(Item e) {
        dato = e;
    }
}
