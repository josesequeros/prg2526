/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoahorcado;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ahorcado {

    private int numeroJugadores;
    //private ArrayList<Jugador> jugadores;
    private Jugador jugadorPonePalabra;
    private Jugador jugadorAdivinaPalabra;
    private String palabra;
    private ArrayList<Letra> objetivo;
    private ArrayList<Character> aciertos;
    private ArrayList<Character> fallos;
    private int intentos;

    public Ahorcado(Jugador jugador1, String objetivo) {
        this.jugadorPonePalabra = jugador1;
        this.palabra = objetivo;
        this.objetivo = crearObjetivo(objetivo);
        this.intentos = 6;
    }

    public Ahorcado(Jugador jugadorPonePalabra, Jugador jugadorAdivinaPalabra, String objetivo) {
        this.jugadorPonePalabra = jugadorPonePalabra;
        this.jugadorAdivinaPalabra = jugadorAdivinaPalabra;
        this.palabra = objetivo;
        this.objetivo = crearObjetivo(objetivo);
        this.intentos = 6;
        this.aciertos = new ArrayList<>();
        this.fallos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Ahorcado{" + "numeroJugadores=" + numeroJugadores
                + ", \njugador1=" + jugadorPonePalabra + ", "
                + "\njugador2=" + jugadorAdivinaPalabra
                + ", \nobjetivo=" + objetivo
                + ", \naciertos=" + aciertos
                + ", \nfallos=" + fallos + '}';
    }

    /**
     * @return the objetivo
     */
    public ArrayList<Letra> getObjetivo() {
        return objetivo;
    }

    /**
     * @param objetivo the objetivo to set
     */
    public void setObjetivo(ArrayList<Letra> objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * @param objetivo String a transformar
     * @return ArrayList de Letras
     */
    private ArrayList<Letra> crearObjetivo(String objetivo) {
        ArrayList<Letra> aux = new ArrayList<>();
        for (Character c : objetivo.toCharArray()) {
            Letra letra = new Letra(c, false);
            aux.add(letra);
        }
        return aux;
    }

    public void mostrarEstadoJuego() {
        System.out.println("\n\n");
        System.out.println("Jugadores: \tElige la palabra:"
                + this.jugadorPonePalabra.getNombre()
                + "\t Adivina la palabra: " + this.jugadorAdivinaPalabra.getNombre());
        System.out.println("Adivinando la palabra:\n");

        for (Letra c : objetivo) {
            System.out.print(c + " ");
        }
        System.out.println("");
        if (this.aciertos.size() > 0) {
            System.out.print("\nLetras acertadas: ");
            System.out.println(this.aciertos);
        }
        if (this.fallos.size() > 0) {
            System.out.print("\nLetras falladas: ");
            System.out.println(this.fallos);
        }
        System.out.println("");
        dibujarHorca();
    }

    public Jugador jugar() {
        Scanner teclado = new Scanner(System.in, "UTF-8");
        char caracter = '\0';
        Jugador jugadorGana;
        Jugador jugadorPierde;
        while (this.getIntentos() > 0 && !completa()) {
            mostrarEstadoJuego();
            do {
                System.out.print("Introduzca un carácter: ");
                caracter = teclado.next().charAt(0);
            } while (!Character.isLetter(caracter));
            System.out.println();
            this.comprobarCaracter(caracter);
        }
        if (this.intentos > 0) {
            System.out.println("Acertaste la palabra");
            jugadorGana = this.jugadorAdivinaPalabra;
            jugadorPierde = this.jugadorPonePalabra;
        } else {
            System.out.println("No has acertado la palabra: " + this.palabra);
            jugadorGana = jugadorPonePalabra;
            jugadorPierde = jugadorAdivinaPalabra;
            //mostrarPalabra();
        }
        // Actualizar el resultado del juego
        jugadorGana.setPartidasGanadas(jugadorGana.getPartidasGanadas() + 1);
        jugadorGana.setTotalPuntos(jugadorGana.getTotalPuntos() + 10);
        jugadorPierde.setPartidasPerdidas(jugadorPierde.getPartidasPerdidas() + 1);
        System.out.println("Gana: " + jugadorGana);
        System.out.println("pierde: " + jugadorPierde);
        return jugadorGana;
    }

    public void dibujarHorca() {
        String[] horca = {
            """
            
                     __________
                    |         |
                    |         0
                    |        /|\\
                    |        / \\
                    |
                  __|__
            """,
            """
            
                     __________
                    |         |
                    |         0
                    |        /|
                    |        / \\
                    |
                  __|__
            """,
            """
            
                     __________
                    |         |
                    |         0
                    |         |
                    |        / \\
                    |
                  __|__
            """,
            """
            
                     __________
                    |         |
                    |         0
                    |         |
                    |        / 
                    |
                  __|__
            """,
            """
            
                     __________
                    |         |
                    |         0
                    |         |
                    |         
                    |
                  __|__
            """,
            """
            
                     __________
                    |         |
                    |         0
                    |        
                    |         
                    |
                  __|__
            """,
            """
            
                     __________
                    |         |
                    |         
                    |        
                    |        
                    |
                  __|__
            """
        };
        //System.out.println(horca[jugador.getIntentos()]);
        System.out.println(horca[this.intentos]);
    }

    public static void portada() {
        System.out.println("\n"
                + "8888888888 888\n"
                + "888        888                     __________\n"
                + "888        888                    |         |\n"
                + "8888888    888                    |         0\n"
                + "888        888                    |        /|\\\n"
                + "888        888                    |        / \\\n"
                + "888        888                    |\n"
                + "8888888888 888                  __|__\n"
                + "\n"
                + "\n"
                + "         888                                             888\n"
                + "         888                                             888\n"
                + "         888                                             888\n"
                + " 8888b.  88888b.   .d88b.  888d888 .d8888b  8888b.   .d88888  .d88b.\n"
                + "    '88b 888 '88b d88''88b 888P'  d88P'        '88b d88' 888 d88''8b\n"
                + ".d888888 888  888 888  888 888    888      .d888888 888  888 888  888\n"
                + "888  888 888  888 Y88..88P 888    Y88b.    888  888 Y88b 888 Y88..88P\n"
                + "'Y888888 888  888  'Y88P'  888     'Y8888P' Y888888  'Y88888  'Y88P\n"
                + "\n");
    }

    public static void adios() {
        System.out.println("""
                                                          888
                                                          888  O                     
                                                          888                      
                                             8888b.   .d88888 d8b  .d88b.    .d8888
                                                "88b d88" 888 888 d88""88b  88
                                            .d888888 888  888 888 888  888  "8888b.
                                            888  888 Y88b 888 888 Y88..88P       88
                                            "Y888888  "Y88888 888  "Y88P"   888888"                           
                           """);
    }

    public void mostrarPalabra() {
        System.out.println(palabra);
    }

    /**
     * @return the intentos
     */
    public int getIntentos() {
        return intentos;
    }

    /**
     * @param intentos the intentos to set
     */
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    private void comprobarCaracter(char caracter) {
        System.out.println("Combrobando caracter: ");
        boolean existeLetra = false;
        if (this.aciertos.contains(caracter) || this.fallos.contains(caracter)) {
            System.out.println("\nCaracter repetido.\n");
        } else {
            for (Letra letra : objetivo) {
                if (caracter == letra.getLetra()) {
                    letra.setAcertada(Boolean.TRUE);
                    existeLetra = true;
                }
            }
            if (existeLetra) {
                aciertos.add(caracter);
            } else {
                fallos.add(caracter);
                this.intentos -= 1;
            }
        }
    }

    private boolean completa() {
        boolean todas = true;
        for (Letra letra : objetivo) {
            todas = todas && letra.getAcertada();
        }
        return todas;
    }

}
