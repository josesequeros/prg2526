/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package josefus;

/**
 *
 * @author IEUser
 */
public class Josefus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int personas = 7;
        int intervalo = 2;
        ListaCircular<Integer> lc = new ListaCircular<>();
        for (int i = 0; i < personas; i++) {
            lc.addItem(i);
        }
        System.out.println(lc.toString());
        int contador = 1;
        while (lc.getTalla() > 1) {
            while (contador < intervalo) {
                lc.avanzarPosicion();
                contador++;
            }
            lc.borrarNodo();
            lc.setTalla(lc.getTalla() - 1);
            contador = 0;
        }
        System.out.println("Lista Final: ");
        System.out.println(lc.toString());

        lc.avanzarPosicion();
        lc.avanzarPosicion();
        System.out.println(lc.toString());
        System.out.println("Posición: " + lc.getPosicion());
        System.out.println("Anterior: " + lc.anteriorNodo());
        lc.borrarNodo();
        System.out.println(lc.toString());
        lc.avanzarPosicion();
        lc.avanzarPosicion();
        lc.borrarNodo();
        System.out.println(lc.toString());
    }

}
