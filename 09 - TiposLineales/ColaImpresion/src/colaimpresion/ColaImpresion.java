/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colaimpresion;

import java.util.NoSuchElementException;

/**
 *
 * @author IEUser
 */
public class ColaImpresion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int trabajo;
        Cola epsonLaser = new Cola();
        epsonLaser.desencolar();
        for (int i = 0; i < 60; i++) {
            //NodoInt trabajoImpresion = new NodoInt(i);
            if (i % 3 == 0 && i < 37) {
                epsonLaser.encolar(i);
                System.out.println("Mandando a imprimir trabajo:" + i);
            }
            if (i % 5 == 0) {
                if (!epsonLaser.esVacia()) {
                    trabajo = epsonLaser.desencolar();
                    System.out.println("Imprimiento Trabajo: " + trabajo);
                }
            }
        }
        //System.out.println(epsonLaser);
        try {
            epsonLaser.verCola();
        } catch (NoSuchElementException e) {
            //System.out.println(e.getMessage());
            System.out.println("Fin de Trabajos");
        }
        //epsonLaser.verCola();
    }



}
