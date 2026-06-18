/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuraslineales;

/**
 *
 * @author pabvazrui
 */
public class ListaInt {

    private NodoInt primero;

    public class NodoInt {

        int dato;
        NodoInt siguiente;

        NodoInt(int d) {
            this.dato = d;
            siguiente = null;
        }
    }

    public ListaInt() {
        this.primero = null;
    }

    public void addItem(int valor) {
        NodoInt nuevo = new NodoInt(valor);
        nuevo.siguiente = primero;
        primero = nuevo;
    }

    public void listar() {
        NodoInt aux = primero;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
    
    public void añadirInicio(int valor) {
        NodoInt nuevo = new NodoInt(valor);
        nuevo.siguiente = primero; 
        primero = nuevo;          
        
    }
    
    public NodoInt getPrimero() {
        return primero;
    }

    public static ListaInt fusionarInterseccionDescendente(ListaInt original) {
        ListaInt resultado = new ListaInt();

        NodoInt actualA = original.primero;
        

        while (actualA != null && actualA != null) {
            if (actualA.dato == actualA.dato) {

                resultado.añadirInicio(actualA.dato);

                actualA = actualA.siguiente;
            } else if (actualA.dato < actualA.dato) {
                actualA = actualA.siguiente;
            }
        }
        return resultado;
    }

}
