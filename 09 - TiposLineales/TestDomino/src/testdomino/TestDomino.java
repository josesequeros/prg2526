/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdomino;

/**
 *
 * @author ja.buenoseva
 */
public class TestDomino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CajaFichas domino = new CajaFichas();
        
        Jugador j1 = new Jugador("Angel");
        Jugador j2 = new Jugador("Beatriz");
        Jugador j3 = new Jugador("Carlos");
        Jugador j4 = new Jugador("Delia");
        /*
        domino.repartiMano(j1);
        domino.repartiMano(j2);
        domino.repartiMano(j3);
        domino.repartiMano(j4);
        System.out.println(j1.getMano());
        System.out.println(j2.getMano());
        System.out.println(j3.getMano());
        System.out.println(j4.getMano());
        */
        
        Partida partida = new Partida();
        partida.añadirJugador(j1);
        partida.añadirJugador(j2);
        partida.añadirJugador(j3);
        partida.añadirJugador(j4);
        partida.jugar();
    }
    
}

