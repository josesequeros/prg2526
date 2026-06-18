/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuras_lineales;

/**
 *
 * @author josgimgar3
 */
public class Estructuras_Lineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaStr lista = new ListaStr();
        lista.addItem(1);
        lista.addItem(6);
        lista.addItem(2);

        ListaStr list2 = nuevaListaOrdenada(lista);
        lista.listar();
        System.out.println();
        list2.listar();

    }

    public static ListaStr nuevaListaOrdenada(ListaStr lis) {
        ListaStr lis3 = new ListaStr();
        ListaStr lis2 = new ListaStr();
        NodoStr cur1 = lis.getPrimero();
        NodoStr cur2 = lis2.getPrimero();
       
        /*while (cur2.siguiente != null && cur1.siguiente != null) {
            if (cur1.dato == cur2.dato) {
                cur2 = cur2.siguiente;
            }
            if (cur1.dato < cur2.dato) {
                lis2.addItem(cur1.dato);
                cur1 = cur1.siguiente;
            }
            if (cur1.dato > cur2.dato) {
                lis2.addItem(cur2.dato);
                cur2 = cur1.siguiente;
            }

        }

        return list2;
*/
        int menor = lis3.primero.dato;
        NodoStr s = lis3.primero;
        while (s.siguiente != null) {
            if (menor > s.dato) {
                menor = s.dato;
                if(lis2.primero == null){
                    lis2.addItem(menor);
                    lis3.primero = lis3.primero.siguiente;
                }
            }
        }
        s = lis.primero;
        while (s.siguiente != null) {
            if (menor > s.dato) {
                menor = s.dato;
            }
        }
    return lis2;
    }

   
}
