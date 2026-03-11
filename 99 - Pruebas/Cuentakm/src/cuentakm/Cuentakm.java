/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuentakm;

/**
 *
 * @author ja.buenoseva
 */
public class Cuentakm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int limite = 999;
        int kmTotales = 0;
        int viaje = 0;

        int i = 0;
        while (i<limite){
            i++;
            viaje++;
            if (i % 10 == 0) {
                kmTotales++;
            }
            
            System.out.println(kmTotales + " - " + (double)viaje/10);
        }
    }
}
