/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdomino;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ja.buenoseva
 */
public class Partida {

    private ArrayList<Jugador> jugadores;
    private CajaFichas domino;
    private Deque<Ficha> mesa;
    private int alMejorDeRondas;
    private int ganaRondas;

    public Partida() {
        jugadores = new ArrayList<>();
        domino = new CajaFichas();
        mesa = new Deque<>();
        ganaRondas = 5;

    }

    public Partida(ArrayList<Jugador> jugadores, CajaFichas domino, Deque<Ficha> mesa, int alMejorDeRondas, int ganaRondas) {
        this.jugadores = jugadores;
        this.domino = domino;
        this.mesa = mesa;
        this.alMejorDeRondas = alMejorDeRondas;
        this.ganaRondas = ganaRondas;
    }

    public void jugar() {
        int numeroJugadores = jugadores.size();
        //domino.mostrarCaja();
        domino.mezclar();
        //domino.mostrarCaja();
        for (int i = 0; i < numeroJugadores; i++) {
            Jugador jugador = jugadores.get(i);
            domino.repartiMano(jugador);
            System.out.println(jugador);
        }
        int turno = jugadorComienza();

        boolean enJuego = true;
        int pasa = 0;
        while (enJuego) {
            turno = turno % numeroJugadores;
            Ficha ficha = moverFicha(turno);
            if (ficha == null) {
                pasa++;
            }
            if (pasa == numeroJugadores) {
                enJuego = false;    // cerrado
            } else {
                turno++;
            }
        }

    }

    public void añadirJugador(Jugador jugador) {
        if (jugadores.size() < 4) {
            jugadores.add(jugador);
        }
    }

    private int jugadorComienza() {
        int aux = 0;
        int mayor = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            for (Ficha ficha : this.jugadores.get(i).getMano()) {
                if (ficha.esDoble()) {
                    if (ficha.getNumeroUno() + ficha.getNumeroDos() > mayor) {
                        mayor = ficha.getNumeroUno() * 2;
                        aux = i;
                    }
                }
            }
        }
        return aux;
    }

    private Ficha moverFicha(int turno) {
        Ficha aux = null;
        Scanner entrada = new Scanner(System.in);
        Jugador jugadorJugando = jugadores.get(turno);
        
        System.out.println("Mesa:");
        System.out.println(mesa);
        System.out.println("Mano del jugador en Juego: ");
        System.out.println(jugadorJugando.getMano());
        System.out.println("Que ficha quieres mover? ");
        int numero = entrada.nextInt();
        return aux;
    }
}
