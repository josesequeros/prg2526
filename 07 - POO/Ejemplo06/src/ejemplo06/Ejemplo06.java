/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo06;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author jabue
 */
public class Ejemplo06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        // Ejemplo 06 Vector de Objetos
        Articulo[] misArticulos = new Articulo[10];

        for (int i = 0; i < 10; i++) {
            misArticulos[i] = new Articulo("Identificador" + i, "Cod " + i, "Artículo " + i, "DVD", (float) (i * 10));
            System.out.println("Creando Artículo: " + Articulo.getNumero());
        }
        System.out.println("Total de Artículos Creados: " + Articulo.getNumero());
        for (int i = 0; i < 10; i++) {
            System.out.println(misArticulos[i].toString());
            System.out.println("\tCódigo Artículo: " + misArticulos[i].getCod());
            System.out.println("\tAlquiler Artículo: " + " 1 día: " + misArticulos[i].precio1());
            System.out.println("\tAlquiler Artículo: " + " 2 día: " + misArticulos[i].precio2());
            System.out.println("\tAlquiler Artículo: " + " 1 semana: " + misArticulos[i].precio_semana());
        }

    }

}
