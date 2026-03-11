/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testreloj;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ja.buenoseva
 */
public class TestReloj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Reloj reloj24 = new Reloj();
        int tiempo = 1000000;
        long retardo = 0; // En miliSegundos - 1000 es un segundo
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < tiempo; i++) {
            Thread.sleep(retardo); // 1000 milisegundos = 1 segundo
            if (reloj24.getBateria() <= 0) {
                break;
            }
            reloj24.setSegundos(reloj24.getSegundos() + 1);
            //System.out.println(reloj24);
            System.out.print(reloj24.mostrarReloj12Real());
            System.out.print("    ");
            reloj24.mostrarBateria();
            System.out.println("");
        }
        long fin = System.currentTimeMillis();
        System.out.println("Ha tardado: " + ((fin - inicio)) + " milisegundos");
    }

}
