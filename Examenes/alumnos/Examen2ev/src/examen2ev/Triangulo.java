/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2ev;

public class Triangulo {
    private double base;
    private double altura;

    // Constructor
    public Triangulo() {
        this.base = base;
        this.altura = altura;
    }

    // Método para calcular el área del triángulo
    public double calcularArea() {
        return (base * altura) / 2;
    }

    // Método toString para imprimir información del triángulo
    @Override
    public String toString() {
        return String.format("Triángulo [Base: %.2f, Altura: %.2f, Área: %.2f]", base, altura, calcularArea());
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }





    public boolean estaOrdenada() {
        if (primero == null || primero.siguiente == null) {
            // Si la lista está vacía o tiene un solo elemento, está ordenada
            return true;
        }
        NodoInt actual = primero; // Comienza desde el primer nodo
        while (actual.siguiente != null) {
            // Recorre la lista mientras haya un siguiente nodo
            if (actual.dato > (actual.siguiente.dato)) {
                // Si el dato del nodo actual es mayor que el del siguiente nodo, la lista no está ordenada
                return false;
            }
            actual = actual.siguiente; // Avanza al siguiente nodo
        }
        return true; // Si no se encontraron elementos desordenados, la lista está ordenada
    }

    class NodoInt {
        int dato; // Dato almacenado en el nodo
        NodoInt siguiente; // Referencia al siguiente nodo en la lista

        NodoInt(int d) {
            dato = d; // Asigna el dato al nodo
            siguiente = null; // Inicializa la referencia al siguiente nodo como null
        }
    }
    private NodoInt primero; // Referencia al primer nodo de la lista
    private int talla;
    public void ListaStrEnlazada() {
        primero = null; // Inicializa la lista vacía
        talla = 0; // Inicializa la talla en 0
    }

    public void insertar(int dato) {
        NodoInt nuevo = new NodoInt(dato); // Crea un nuevo nodo con el dato
        if (primero == null) {
            // Si la lista está vacía, el nuevo nodo es el primero
            primero = nuevo;
        } else {
            // Si la lista no está vacía, inserta el nuevo nodo al final
            NodoInt actual = primero; // Comienza desde el primer nodo
            while (actual.siguiente != null) {
                // Recorre la lista mientras haya un siguiente nodo
                actual = actual.siguiente; // Avanza al siguiente nodo
            }
            actual.siguiente = nuevo; // Inserta el nuevo nodo al final
        }
        talla++; // Incrementa la talla de la lista
    }

    public void eliminarDuplicados() {
        if (primero == null) {
            // Si la lista está vacía, no hay duplicados que eliminar
            return;
        }
        NodoInt actual = primero; // Comienza desde el primer nodo
        while (actual.siguiente != null) {
            // Recorre la lista mientras haya un siguiente nodo
            if (actual.dato == (actual.siguiente.dato)) {
                // Si el dato del nodo actual es igual al del siguiente nodo, elimina el siguiente nodo
                actual.siguiente = actual.siguiente.siguiente;
                talla--; // Decrementa la talla de la lista
                System.out.println("Duplicado eliminado: " + actual.dato); ;
            } else {
                // Si no son iguales, avanza al siguiente nodo
                actual = actual.siguiente;
            }
        }
    }
    public void imprimir() {
        NodoInt actual = primero; // Comienza desde el primer nodo
        while (actual != null) {
            // Recorre la lista mientras haya un nodo
            System.out.print(actual.dato + " "); // Imprime el dato del nodo
            actual = actual.siguiente; // Avanza al siguiente nodo
        }
        System.out.println(); // Imprime un salto de línea
    }
}

