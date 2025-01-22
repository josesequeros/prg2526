/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ageofempires;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        AgeOfEmpires juego = new AgeOfEmpires();
        Civilizacion spanish = new Civilizacion("Españoles", "Isabel I", 0, 0, 0);
        juego.addCivilizacion(spanish);
        //spanish.mostrarRecursos();
        Civilizacion bizantinos = new Civilizacion("Bizantinos", "Constantino II", 0, 0, 0);
        juego.addCivilizacion(bizantinos);
        int segundos = 200;
        int tiempoCrearAldeano = 2;
        int tiempoAtaqueMonje = 5;
        int itemsMina = 500;
        
        try {
            juego.simular(segundos, tiempoCrearAldeano, tiempoAtaqueMonje, itemsMina);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
