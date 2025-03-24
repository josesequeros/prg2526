package ejercicio4;

public class ListaEnlazada {

    private NodoInt primero;
    private int talla;

    class NodoInt {

        int dato;
        NodoInt siguiente;

        NodoInt(int d) {
            this.dato = d;
            this.siguiente = null;
        }

        NodoInt(int d, NodoInt siguiente) {
            this.dato = d;
            this.siguiente = siguiente;
        }
    }

    public void insertarSinRepetidos(int valor, boolean delante) {
        if (existeValor(valor)) {
            return;
        }

        if (delante) {
            primero = new NodoInt(valor, primero);
        } else {
            NodoInt aux = primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = new NodoInt(valor);
        }
    }

    public boolean existeValor(int valor) {
        NodoInt aux = primero;
        
        while (aux.siguiente == null) {
            if (valor == aux.dato) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }
}
