/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegocartasampliacion;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class JuegoCartasAmpliacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numeroJugadores, cartasRepatir;

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce el número de Jugadores: ");
        numeroJugadores = entrada.nextInt();
        System.out.print("Introduce el número de Cartas a Repartir: ");
        cartasRepatir = entrada.nextInt();

        int[][] partida = new int[numeroJugadores][cartasRepatir];

        //int palos = 4;
        String[] palos = {"oros", "Copas", "Espadas", "Bastos"};
        String[] cartasPalo = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "Sota", "Caballo", "Rey"};
        int[] cartasPaloValor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int cartasPaloCantidad = cartasPalo.length;

        int[] baraja = new int[palos.length * cartasPalo.length];
        for (int i = 0; i < baraja.length; i++) {
            baraja[i] = i;
        }
        System.out.println("");

        /*
        for (int i = 0; i < baraja.length; i++) {
            System.out.print(i + " - " + cartasPalo[baraja[i] % 12] + " de ");
            System.out.println(palos[(int) (baraja[i] - 1) / 12]);
        }
        System.out.println("");
         */
        // barajamos las cartas
        for (int i = 0; i < baraja.length; i++) {
            int r = i + (int) (Math.random() * (baraja.length - i));
            int temp = baraja[i];
            baraja[i] = baraja[r];
            baraja[r] = temp;

        }
        /*
        for (int i = 0; i < baraja.length; i++) {
            System.out.print(baraja[i] + " ");
        }
        System.out.println("");
        
        for (int i = 0; i < baraja.length; i++) {
            System.out.print(i + " - " + cartasPalo[baraja[i] % 12] + " de ");
            System.out.println(palos[(int) (baraja[i] - 1) / 12]);
        }
        System.out.println("");
         */

        int[] puntosJugador = new int[numeroJugadores];
        // Repartimos cartas una vez barajadas
        int contador = 0;
        for (int j = 0; j < numeroJugadores; j++) {
            partida[j][0] = baraja[contador++];
            //puntosJugador[j] = partida[j][0];
        }
        for (int j = 0; j < numeroJugadores; j++) {
            for (int c = 1; c < cartasRepatir; c++) {
                partida[j][c] = baraja[contador++];
            }
        }

        for (int j = 0; j < numeroJugadores; j++) {
            System.out.println("Cartas Jugador " + (j + 1));
            for (int c = 0; c < cartasRepatir; c++) {
                //System.out.print(partida[j][i] + " ");
                System.out.print("\t" + cartasPalo[partida[j][c] % 12] + " de ");
                System.out.print(palos[(int) (partida[j][c] - 1) / 12] + " ");
            }
            System.out.println("");
        }

        // Contamos puntos de cada jugador
        for (int j = 0; j < numeroJugadores; j++) {
            //puntosJugador[j] = partida[j][0] % cartasPaloCantidad + 1;
            puntosJugador[j] = cartasPaloValor[partida[j][0] % cartasPaloCantidad];
            //System.out.println("Puntos Iniciales Jugador: " + (j + 1) + ": " + puntosJugador[j] + "");
        }
        for (int j = 0; j < numeroJugadores; j++) {
            for (int c = 1; c < cartasRepatir; c++) {
                if (partida[j][c] % 12 > partida[j][c - 1] % cartasPaloCantidad) {
                    //puntosJugador[j] += (partida[j][c] % cartasPaloCantidad) + 1;
                    puntosJugador[j] += cartasPaloValor[partida[j][c] % cartasPaloCantidad];
                } else {
                    if (partida[j][c] % 12 < partida[j][c - 1] % cartasPaloCantidad) {
                        //puntosJugador[j] -= (partida[j][c] % cartasPaloCantidad) + 1;
                        puntosJugador[j] -= cartasPaloValor[partida[j][c] % cartasPaloCantidad];
                    }
                }
            }
        }
        // Puntos de cada jugador
        System.out.println("");
        for (int j = 0; j < numeroJugadores; j++) {
            System.out.println("Puntos Jugador: " + (j + 1) + ": " + puntosJugador[j] + "");
        }

        // Obtener ganador
        int maximo = -9999;
        for (int i = 0; i < puntosJugador.length; i++) {
            if (puntosJugador[i] > maximo) {
                maximo = puntosJugador[i];
            }
        }
        System.out.println("Ganador:");
        System.out.println("El ganador ha obtenido: " + maximo + " puntos");
        for (int i = 0; i < puntosJugador.length; i++) {
            if (puntosJugador[i] == maximo) {
                System.out.println("Jugador número: " + (i + 1));
            }
        }

    }
}
