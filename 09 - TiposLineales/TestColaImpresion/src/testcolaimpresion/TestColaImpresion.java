/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testcolaimpresion;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ja.buenoseva
 */
public class TestColaImpresion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
        ColaImpresion colaImpresion = new ColaImpresion();
        colaImpresion.addImpresora(new Impresora("A"));
        colaImpresion.addImpresora(new Impresora("B"));
        colaImpresion.addImpresora(new Impresora("C"));
        colaImpresion.encender();
    }



}
