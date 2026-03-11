/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sieteymedia;

/**
 *
 * @author jabue
 */
public class SieteyMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Jugador jugador1 = new Jugador("Jugador 1", 1000);
        Jugador jugador2 = new Jugador("Jugador 2", 2000);
        Jugador jugador3 = new Jugador("Jugador 3", 12000);
        
        Juego partida = new Juego();
        partida.addJugador(jugador1);
        partida.addJugador(jugador2);
        partida.setApuesta(100);
        partida.setBanca(jugador3);
        
        
        Baraja baraja = new Baraja();
        //System.out.println(baraja);
        int veces = (int) (Math.random() * 10) + 1;
        //System.out.println(veces);
        for (int i = 0; i < veces; i++) {
            baraja.barajar();
        }
        
        
        partida.setBaraja(baraja);
        partida.mostrarJuego();
        
        partida.play();
        partida.mostrarJuego();
        //System.out.println(baraja);
    }

}
