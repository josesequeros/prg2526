/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package josefusdeque;

/**
 *
 * @author ja.buenoseva
 */
public class JosefusDeque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int personas = 7;
        int intervalo = 2;

        Deque<Integer> josefus = new Deque<>();
        for (int i = 0; i < personas; i++) {
            josefus.addLast(i);
        }
        System.out.println("Cola");
        josefus.mostrarCola();
        //System.out.println("");
        //System.out.println("Pila");
        //josefus.mostrarPila();
        System.out.println("");
        //System.out.println(josefus.size());
        int contador = 1;
        josefus.setPosicion(josefus.getPrimero());
        while (josefus.size() > 1) {
            while (contador < intervalo) {
                josefus.avanzarPosicion();
                contador++;
            }
            josefus.borrarNodo();
            contador = 0;
            josefus.mostrarCola();
        }
    }

}
