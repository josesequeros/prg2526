/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegoahorcado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import juegoahorcado.utilidades.EntradaCorrecta;
import juegoahorcado.utilidades.Utilidades;

/**
 *
 * @author jabue
 */
public class JuegoAhorcado {

    static Jugador jugadorAdivina;
    static Jugador jugadorElige;
    static String archivoPalabras;
    static String archivoJugadores;
    static String archivoPartidas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String objetivo = "sinpalabras";

        jugadorAdivina = null;//new Jugador("uno");
        jugadorElige = null;//new Jugador("dos");

        Ahorcado.portada();

        archivoPalabras = "./src/juegoahorcado/archivos/castellano.txt";
        ListaPalabras lo = new ListaPalabras(archivoPalabras);
        archivoJugadores = "./src/juegoahorcado/archivos/jugadoresDatos.txt";
        ListaJugadores lj = new ListaJugadores("./src/juegoahorcado/archivos/jugadoresDatos.txt");
        lj.buscarJugador("jose");
        lj.buscarJugador("pepe");
        //lj.mostrarJugadores();
        archivoPartidas = "./src/juegoahorcado/archivos/partidasDatos.txt";
        ListaPartidas lp = new ListaPartidas(archivoPartidas);
        //lp.mostrarPartidas();
        //mostrarJugadores(listaJugadores);
        //listaPartidas = leerPartidas("./src/juegoahorcado/archivos/partidas.txt");
        //System.out.println("Total de Palabras: " + listaPalabras.size());
        //System.out.println("Total de Jugadores: " + listaJugadores.size());
        //System.out.println("Total de Partidas: " + listaPartidas.size());

        if (!lp.getListaPartidas().isEmpty()) {
            objetivo = lo.obtenerObjetivo();
        }

        System.out.println("Palabra a adivinar: " + objetivo);

        String nombreJugador1 = "";
        String nombreJugador2 = "";
        int opcion = 0;
        //Ahorcado juego = new Ahorcado(JugadorAdivina, jugadorElige, objetivo);
        while (opcion != 9) {
            //System.out.println(juego);
            //limpiar();
            opcion = menu(nombreJugador1, nombreJugador2);
            switch (opcion) {
                case 1:
                    seleccionarJugadores(lj);
                    nombreJugador1 = jugadorElige.getNombre();
                    nombreJugador2 = jugadorAdivina.getNombre();
                    break;
                case 2:
                    if (jugadorElige == null || jugadorAdivina == null) {
                        System.out.println("Debes seleccionar primero los jugadores");
                    } else {
                        Ahorcado juego = new Ahorcado(jugadorElige, jugadorAdivina, objetivo);
                        int numeroPartida = lp.getListaPartidas().size() + 1;

                        Jugador jugadorGana = juego.jugar();
                        Partida partida = new Partida(numeroPartida, jugadorAdivina.getNombre(), jugadorElige.getNombre(), objetivo, 10, jugadorGana.getNombre());
                        lp.getListaPartidas().add(partida);
                    }
                    break;
                case 3:
                    objetivo = lo.obtenerObjetivo();
                    System.out.println("Objetivo: " + objetivo);
                    break;
                case 4:
                    Utilidades.mostrarArchivosEnDirectorio("./src/juegoahorcado/archivos/");
                    if (cambiarFicheroPalabras()) {
                        lo = new ListaPalabras(archivoPalabras);
                        //System.out.println(lo.getListaPalabras().size());
                    }
                    break;
                case 5:
                    lj.ranking();
                    break;
                case 6:
                    lj.mostrarJugadores();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opción no valida");
            }

            System.out.println("");
        }
        lj.escribirJugadores(archivoJugadores);
        lp.escribirPartidas(archivoPartidas);
        Ahorcado.adios();
    }

    public static int menu(String nombreJugador1, String nombreJugador2) {
        System.out.println("Juego del Ahorcado");
        System.out.println("");
        System.out.println("1.- Seleccionar Jugadores");
        System.out.println("2.- Jugar " + nombreJugador1 + " " + nombreJugador2);
        System.out.println("3.- Elegir la Palabra a adivinar");
        System.out.println("4.- Cambiar el fichero de Palabras");
        System.out.println("5.- Mostrar Ranking");
        System.out.println("6.- Mostrar Jugadores");
        System.out.println("7.- Dar de Alta un Jugador");
        System.out.println("8.- ");
        System.out.println("9.- Finalizar");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        int opcion = EntradaCorrecta.nextInt(sc, "Introduzca una opción: ", 0, 9);
        return opcion;
    }

    public static void limpiar() {

        final String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            try {
                Runtime.getRuntime().exec("cls");
            } catch (IOException ex) {
                //Logger.getLogger(JuegoAhorcado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException ex) {
            //Logger.getLogger(JuegoAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(JuegoAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void seleccionarJugadores(ListaJugadores lj) {
        Scanner teclado = new Scanner(System.in, "UTF-8");
        String nombreElige;
        String nombreAdivina;

        lj.mostrarJugadores();
        do {
            System.out.println("Introduce el nombre del jugador que pone la elige la palabra: ");
            nombreElige = teclado.nextLine();
            System.out.println("Introduce el nombre del jugador que pone la adivina la palabra: ");
            nombreAdivina = teclado.nextLine();
        } while (nombreElige.equals(nombreAdivina));
        jugadorElige = lj.buscarJugador(nombreElige);
        jugadorAdivina = lj.buscarJugador(nombreAdivina);
    }

    private static boolean cambiarFicheroPalabras() {
        boolean cambiado = false;
        Scanner teclado = new Scanner(System.in, "UTF-8");
        System.out.println("introduzca el nombre del Fichero: ");
        String archivo = teclado.nextLine();
        String ruta = "./src/juegoahorcado/archivos/" + archivo;
        File temp = new File(ruta);
        if (temp.exists()) {
            System.out.println("existe");
            archivoPalabras = ruta;
            cambiado = true;
        } else {
            System.out.println("No existe");
        }
        return cambiado;
    }
}
