/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taquillas;

/**
 *
 * @author jabue
 */
public class Taquillas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int totalAlumnos = 100;
        int totalTaquillas = 100;
        int abiertas = 0;

        boolean[] taquillas = new boolean[totalTaquillas];
        for (int i = 0; i < totalTaquillas; i++) {
            taquillas[i] = false;
        }

        for (int alumno = 1; alumno <= totalAlumnos; alumno++) {
            //System.out.println("Alumno: " + alumno);
            for (int taquilla = alumno-1; taquilla < totalTaquillas; taquilla = taquilla + alumno) {
                taquillas[taquilla] = !taquillas[taquilla];
                //System.out.println("Taquilla: " + taquilla + " " + taquillas[taquilla]);
            }
        }
        for (boolean taquilla : taquillas) {
            if (taquilla) {
                abiertas++;
            }
        }
        System.out.println("Hay un total de: " + abiertas + " taquillas abiertas");
        for (int i = 0; i < totalTaquillas; i++) {
            if (taquillas[i]) 
                System.out.println("Taquilla " + (i+1) + " Abierta");
        }
    }

}
