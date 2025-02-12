package lineales;

import java.util.NoSuchElementException;

/**
 * Clase Colas: Cola de int. Implementación enlazada.
 *
 * @author 
 * @version 
 */
public class Colas {

    private NodoInt primero, ultimo;
    private int talla;

    /**
     * Crea una cola vacía.
     */
    public Colas() {
        primero = null;
        ultimo = null;
        talla = 0;
    }

    /**
     * Encola un nuevo elemento en la cola.
     *
     * @param int x, el elemento a encolar.
     */
    public void encolar(int x) {
        NodoInt nuevo = new NodoInt(x);
        if (ultimo != null) {
            ultimo.siguiente = nuevo;
        } else {
            primero = nuevo;
        }
        ultimo = nuevo;
        talla++;
    }

    /**
     * Desencola y devuelve el primer elemento de la cola.
     *
     * @return int, la cabeza de la cola antes de desencolar.
     * @throws NoSuchElementException si la cola está vacía.
     */
    public int desencolar() {
        if (talla == 0) {
            throw new NoSuchElementException("Cola vacía");
        }
        int x = primero.dato;
        primero = primero.siguiente;
        if (primero == null) {
            ultimo = null;
        }
        talla--;
        return x;
    }

    /**
     * Devuelve el primer elemento de la cola.
     *
     * @return int, la cabeza de la cola.
     * @throws NoSuchElementException si la cola está vacía.
     */
    public int primero() {
        if (talla == 0) {
            throw new NoSuchElementException("Cola vacía");
        }
        return primero.dato;
    
}
