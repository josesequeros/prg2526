/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sieteymedia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Juego {

    private ArrayList<Jugador> jugadores;
    private int apuesta;
    private Jugador banca;
    private Baraja baraja;

    public Juego(ArrayList<Jugador> jugadores, int apuesta, Jugador banca) {
        this.jugadores = jugadores;
        this.apuesta = apuesta;
        this.banca = banca;
    }

    public Juego() {
        jugadores = new ArrayList<>();
    }

    public ArrayList getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public Jugador getBanca() {
        return banca;
    }

    public void setBanca(Jugador banca) {
        this.banca = banca;
        banca.setEstado(Estado.JUGANDO);
    }

    public void addJugador(Jugador j) {
        jugadores.add(j);
        j.setEstado(Estado.JUGANDO);
    }

    public Baraja getBaraja() {
        return baraja;
    }

    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public void mostrarJuego() {
        System.out.println("Datos de la Partida:");
        System.out.println("Banca: " + banca.getNombre());
        System.out.println("\t" + banca.getMano());
        System.out.println("\t" + banca.getSaldo());
        System.out.println("Jugadores:");
        for (Jugador jugador : jugadores) {
            System.out.println("\t" + jugador.getNombre());
            System.out.println("\t" + jugador.getMano());
            System.out.println("\t" + jugador.getSaldo());
        }

    }

    public void play() {
        //rondaInicila()
        rondaInicial();
        while (enJuego()) {
            ronda();
        }
        juegaBanca();
        // Ganador?
        determinarGanador();
    }

    public void rondaInicial() {
        //Repartir la primera carta a cada jugador boca abajo
        for (int i = 0; i < this.jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            Carta c = baraja.extraerCarta();
            CartaJugada cj = new CartaJugada(c, true);
            j.getMano().add(cj);
        }
        banca.getMano().add(new CartaJugada(baraja.extraerCarta(), true));
    }

    public void ronda() {
        //Repartir la primera carta a cada jugador boca abajo
        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < this.jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            if (jugador.getEstado() == Estado.JUGANDO) {
                System.out.println("Jugador: " + jugador.getNombre());
                System.out.println(jugador.mostrarMano());
                System.out.println("Introduzca un número: ");
                System.out.println("\tNegativo si la carta la quiere tapada");
                System.out.println("\tCero si se planta");
                System.out.println("\tPositivo la carta la quiere destapada");
                int opcion = entrada.nextInt();
                entrada.nextLine();
                if (opcion == 0) {
                    // se planta
                    jugador.setEstado(Estado.PLANTADO);
                } else {
                    Carta c = baraja.extraerCarta();
                    CartaJugada cj = new CartaJugada(c, true);
                    if (opcion < 0) {
                        // tapada
                        jugador.destaparCartas();
                    } else {
                        // destapada
                        cj.setOculta(false);
                    }
                    jugador.getMano().add(cj);
                }
                if (jugador.obtenerPuntuacion() > 7.5) {
                    jugador.setEstado(Estado.TORRADO);
                }
            }
        }
    }

    private void repartirCarta() {
        for (Jugador jugador : jugadores) {

        }
        for (int i = 0; i < this.jugadores.size(); i++) {
            Jugador j = jugadores.get(i);
            Carta c = baraja.extraerCarta();
            CartaJugada cj = new CartaJugada(c, true);
            j.getMano().add(cj);
        }

        //return null;
    }

    public boolean enJuego() {
        boolean jugando = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getEstado() == Estado.JUGANDO) {
                jugando = true;
            }
        }
        return jugando;

    }

    private void juegaBanca() {
        Scanner entrada = new Scanner(System.in);
        //System.out.println(banca);
        while (banca.getEstado() == Estado.JUGANDO) {
            System.out.println("Jugador: " + banca.getNombre());
            System.out.println(banca.mostrarMano());
            System.out.println("Introduzca un número: ");
            System.out.println("\tCero si se planta");
            System.out.println("\tDistinto de 0 pide carta");
            int opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion == 0) {
                // se planta
                banca.setEstado(Estado.PLANTADO);
            } else {
                Carta c = baraja.extraerCarta();
                CartaJugada cj = new CartaJugada(c, false);
                banca.getMano().add(cj);
            }
            if (banca.obtenerPuntuacion() > 7.5) {
                banca.setEstado(Estado.TORRADO);
            }
        }
    }

    private void determinarGanador() {
        System.out.println("");
        System.out.println("Resultado de la partida");
        System.out.println("Estado de la Banca: "+ banca.getEstado());
        System.out.println("Saldo: " + banca.getSaldo());
        if (banca.getEstado() == Estado.PLANTADO) {
            if (banca.obtenerPuntuacion() != 7.5) {
                System.out.println("Banca: " + banca.getNombre());
                System.out.println("");
                for (int i = 0; i < jugadores.size(); i++) {
                    Jugador jugador = jugadores.get(i);
                
                //for (Jugador jugador : jugadores) {
                    if (jugador.getEstado() == Estado.PLANTADO && banca.obtenerPuntuacion() < jugador.obtenerPuntuacion()) {
                        System.out.println("Jugador: " + banca.getNombre());
                        if (jugador.obtenerPuntuacion() == 7.5) {
                            jugador.setSaldo(jugador.getSaldo() + 2 * this.apuesta);
                            banca.setSaldo(banca.getSaldo() - 2 *  this.apuesta);
                        } else {
                            jugador.setSaldo(jugador.getSaldo() + this.apuesta);
                            banca.setSaldo(banca.getSaldo() -  this.apuesta);
                        }
                        System.out.println("Gana");
                        System.out.println("Saldo: " + jugador.getSaldo());
                        System.out.println("");
                    } else {
                        banca.setSaldo(banca.getSaldo() + this.apuesta);
                        jugador.setSaldo(jugador.getSaldo() - this.apuesta);
                    }
                }
            } else {
                for (Jugador jugador : jugadores) {
                    banca.setSaldo(banca.getSaldo() + this.apuesta);
                    jugador.setSaldo(jugador.getSaldo() - this.apuesta);
                }
            }
        } else {
            for (int i = 0; i < jugadores.size(); i++) {
                    Jugador jugador = jugadores.get(i);
            //for (Jugador jugador : jugadores) {
                if (jugador.getEstado() == Estado.PLANTADO ) {
                    System.out.println("Jugador: " + banca.getNombre());
                    if (jugador.obtenerPuntuacion() == 7.5) {
                        jugador.setSaldo(jugador.getSaldo() + 2 * this.apuesta);
                        banca.setSaldo(banca.getSaldo() - 2 *  this.apuesta);
                    } else {
                        jugador.setSaldo(jugador.getSaldo() + this.apuesta);
                        banca.setSaldo(banca.getSaldo() - this.apuesta);
                    }
                    System.out.println("Gana");
                    System.out.println("Saldo: " + jugador.getSaldo());
                    System.out.println("");
                }
            }
        }
    }
}