/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegocartas;

/**
 *
 * @author IEUser
 */
public class JuegoCartas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] jugador1 = new int[5];
        int[] jugador2 = new int[5];
        int puntosJugador1, puntosJugador2;

        for (int i = 0; i < 5; i++) {
            jugador1[i] = (int) (1 + Math.random() * 12);
            jugador2[i] = (int) (1 + Math.random() * 12);
        }
        System.out.println("Cartas Jugador 1");
        for (int i = 0; i < 5; i++) {
            System.out.print(jugador1[i] + " ");
        }
        System.out.println("");
        System.out.println("Cartas Jugador 2");
        for (int i = 0; i < 5; i++) {
            System.out.print(jugador2[i] + " ");
        }
        System.out.println("");

        puntosJugador1 = jugador1[0];
        puntosJugador2 = jugador2[0];
        for (int i = 1; i < 5; i++) {
            // Jugador 1
            if (jugador1[i] > jugador1[i - 1]) {
                puntosJugador1 += jugador1[i];
            } else {
                if (jugador1[i] < jugador1[i - 1]) {
                    puntosJugador1 -= jugador1[i];
                }
            }
            // Jugador 2
            if (jugador2[i] > jugador2[i - 1]) {
                puntosJugador2 += jugador2[i];
            } else {
                if (jugador2[i] < jugador2[i - 1]) {
                    puntosJugador2 -= jugador2[i];
                }
            }
        }
        System.out.println("Puntos Jugador 1: "+ puntosJugador1);
        System.out.println("Puntos Jugador 2: "+ puntosJugador2);
        System.out.println("");

    }

}
