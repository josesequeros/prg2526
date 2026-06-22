/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package elecciones;

import java.util.Arrays;

/**
 *
 * @author IEUser
 */
public class Elecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int totalEscanos = 12;
        int totalPartidos = 5;
        String[] nombrePartidos = new String[totalPartidos];
        int[] totalVotos = new int[totalPartidos];
        int[] escanosPartido = new int[totalPartidos];
        Arrays.fill(escanosPartido, 0);
        for (int i = 0; i < totalPartidos; i++) {
            nombrePartidos[i] = "Partido " + i;
        }
        //int[] votos = {340, 281, 160, 60, 15};
        int[] votos = {239, 207, 167, 108, 68};
        totalVotos = votos;

        // reparto de escaños
        for (int j = 0; j < totalEscanos; j++) {
            int mayor = 0;
            int partido = 0;
            for (int i = 0; i < totalPartidos; i++) {
                int cociente = totalVotos[i] / (escanosPartido[i] + 1);
                if (cociente > mayor) {
                    mayor = cociente;
                    partido = i;
                }
            }
            escanosPartido[partido] += 1;
        }
        for (int i = 0; i < totalPartidos; i++) {
            System.out.println(nombrePartidos[i]+": "+escanosPartido[i]+" Escaños");
        }
    }

}
