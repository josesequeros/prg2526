/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica01mutableinmutable;

import java.util.Random;

/**
 *
 * @author ja.buenoseva
 */
public class Practica01MutableInmutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int MAXIMUM = 2000000;
        final String OBJETIVO = "AZAR";
        StringBuilder letras = new StringBuilder();
        Random random = new Random();

        long inicio = System.currentTimeMillis();
        while (letras.indexOf(OBJETIVO, letras.length() - 4) < 0 && letras.length() <= MAXIMUM) {
            int posicion = random.nextInt(26); // una aleatoria posicion entre las letras válidas
            char nextLetra = (char) (posicion + 'A'); // position+'A' es el código ASCII de la letra siguiente
            letras.append(nextLetra); // añade la nueva letra
        }
        if (letras.indexOf(OBJETIVO, letras.length() - 4) >= 0) // si letras acaba con "LEAR"
        {
            System.out.println("Ha tomado " + letras.length() + " caracteres para generar " + OBJETIVO);
        } else {
            System.out.println("No ha sido posible");
        }
        long fin = System.currentTimeMillis();
        System.out.println("Ha tardado: " + ((fin - inicio)) + " milisegundos");

        String letras2 = "";
        inicio = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            int posicion = random.nextInt(26); // una aleatoria posicion entre las letras válidas
            char nextLetra = (char) (posicion + 'A'); // position+'A' es el código ASCII de la letra siguiente
            letras2 += nextLetra; // añade la nueva letra
        }
        while (!letras2.substring(letras2.length()- 4).equals(OBJETIVO) && letras2.length() <= MAXIMUM) {
            int posicion = random.nextInt(26); // una aleatoria posicion entre las letras válidas
            char nextLetra = (char) (posicion + 'A'); // position+'A' es el código ASCII de la letra siguiente
            letras2 += nextLetra; // añade la nueva letra
        }
        if (letras2.substring(letras2.length()- 4).equals(OBJETIVO)) // si letras acaba con "LEAR"
        {
            System.out.println("Ha tomado " + letras2.length() + " caracteres para generar " + OBJETIVO);
        } else {
            System.out.println("No ha sido posible");
        }
        fin = System.currentTimeMillis();
        System.out.println("Ha tardado: " + ((fin - inicio)) + " milisegundos");
    }

}
