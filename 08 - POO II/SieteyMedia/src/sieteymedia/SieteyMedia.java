/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sieteymedia;

/**
 *
 * @author jabue
 */
public class SieteyMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Baraja baraja = new Baraja();
        System.out.println(baraja);
        int veces = (int) (Math.random() * 10) + 1;
        System.out.println(veces);
        for (int i = 0; i < veces; i++) {
            baraja.barajar();
        }
        System.out.println(baraja);
    }

}
