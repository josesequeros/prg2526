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

        //int palos = 4;
        String[] palos = {"oros", "Copas", "Espadas", "Bastos"};
        String[] cartasPalo = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "Sota", "Caballo", "Rey"};
        int[] cartasPaloValor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int cartasPaloCantidad = cartasPalo.length;
        // Creamos la baraja
        int[] baraja = crearBaraja(palos, cartasPalo);
        System.out.println("");
        // Com comprobación mostramos la baraja
        //mostrarBaraja(baraja, palos, cartasPalo);
        
        // barajamos las cartas
        barajarCartas(baraja);
        
        // mostramos las cartas barajadas
        mostrarBaraja(baraja, palos, cartasPalo);
        

        // Creamos la partida, para ello
        // Repartimos cartas una vez barajadas
        int[][] partida = new int[numeroJugadores][cartasRepatir];
        partida = repartirCartas(numeroJugadores, cartasRepatir, baraja);

        // Mostramos las cartas de cada Jugador
        mostrarCartasJugadores(partida, cartasPalo, palos);
 
        // Contamos puntos de cada jugador
        int[] puntosJugador = new int[numeroJugadores];
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
    
    public static int[] crearBaraja(String[] palos, String[] cartasPalo) {
        int[] baraja = new int[palos.length * cartasPalo.length];
        for (int i = 0; i < baraja.length; i++) {
            baraja[i] = i;
        }
        return baraja;
    }

    public static void barajarCartas(int[] baraja) {
        for (int i = 0; i < baraja.length; i++) {
            int r = i + (int) (Math.random() * (baraja.length - i));
            int temp = baraja[i];
            baraja[i] = baraja[r];
            baraja[r] = temp;

        }
    }
    
    public static void mostrarBaraja(int[] baraja, String[] palos, String[] cartasPalo) {
        System.out.println("");
        
        for (int i = 0; i < baraja.length; i++) {
            System.out.print(i + " - " + cartasPalo[baraja[i] % 12] + " de ");
            System.out.println(palos[(int) (baraja[i] - 1) / 12]);
        }
        System.out.println("");        
    }    
    
    public static int [][] repartirCartas(int numeroJugadores, int cartasRepartir, int[] baraja) {
        int[][] partida = new int[numeroJugadores][cartasRepartir];
        int contador = 0;
        for (int j = 0; j < numeroJugadores; j++) {
            partida[j][0] = baraja[contador++];
            //puntosJugador[j] = partida[j][0];
        }
        for (int j = 0; j < numeroJugadores; j++) {
            for (int c = 1; c < cartasRepartir; c++) {
                partida[j][c] = baraja[contador++];
            }
        }
        return partida;
    }
    
    public static void mostrarCartasJugadores(int[][] partida, String[] cartasPalo, String[] palos) {
        int numeroJugadores = partida.length;
        int cartasRepartir = partida[0].length;
        for (int j = 0; j < numeroJugadores; j++) {
            System.out.println("Cartas Jugador " + (j + 1));
            for (int c = 0; c < cartasRepartir; c++) {
                //System.out.print(partida[j][i] + " ");
                System.out.print("\t" + cartasPalo[partida[j][c] % 12] + " de ");
                System.out.print(palos[(int) (partida[j][c] - 1) / 12] + " ");
            }
            System.out.println("");
        }
    }
}
