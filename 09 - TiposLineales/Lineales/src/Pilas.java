package lineales;

import java.util.NoSuchElementException;

/**
 * Clase Pilas: Pila de int. Implementación enlazada.
 *
 * @author 
 * @version 
 */
public class Pilas {

    private NodoInt cima;
    private int talla;

    /**
     * Crea una pila vacía.
     */
    public PilaIntEnla() {
        cima = null;
        talla = 0;
    }

    /**
     * Apila x en la cima de la pila.
     *
     * @param int x, el valor a apilar.
     */
    public void apilar(int x) {
        cima = new NodoInt(x, cima);
        talla++;
    }

    /**
     * Desapila y devuelve el elemento de la cima de la pila.
     *
     * @return int, la cima de la pila antes de desapilar.
     * @throws NoSuchElementException si la pila está vacía.
     */
    public int desapilar() {
        if (cima == null) {
            throw new NoSuchElementException("Pila vacía");
        }
        int x = cima.dato;
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
    public int cima() {
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
}
