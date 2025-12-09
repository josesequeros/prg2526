/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semaforos;

/**
 *
 * @author ja.buenoseva
 */
public class Semaforos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int contador = 0;
        int velocidad = 10;
        int minutos = 1;
        int segundos = minutos * 60;

        for (int i = 0; i < segundos; i++) {
            Thread.sleep(1000 / velocidad);
            System.out.println(++contador);
        }
    }

}
