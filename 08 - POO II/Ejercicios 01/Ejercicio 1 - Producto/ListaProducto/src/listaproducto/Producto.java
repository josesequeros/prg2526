/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaproducto;

/**
 *
 * @author ja.buenoseva
 */
public class Producto {
// Atributos
    private String nombre;
    private int cantidad;

    // Constructor
    public Producto(String nom, int cant) {
        this.nombre = nom;
        this.cantidad = cant;
    }

    // GETTERS Y SETTERS
    ;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
