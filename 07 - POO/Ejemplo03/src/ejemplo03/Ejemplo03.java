/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo03;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author jabue
 */
public class Ejemplo03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        // Creamos dos artículos
        Articulo articulo01 = new Articulo();
        Articulo articulo02 = new Articulo();

        // Le damos valores a sus atributos
        articulo01.modificaValores("001", "Titulo1", "DVD", 2.5f);
        articulo02.modificaValores("002", "Titulo2", "DVD", 3f);

        // Utilizar sus métodos
        System.out.println("Alquiler Artículo: " + articulo01.getCod()
                + " 1 día: " + articulo01.precio1());
        System.out.println("Alquiler Artículo: " + articulo01.getCod()
                + " 2 día: " + articulo01.precio2());
        System.out.println("Alquiler Artículo: " + articulo01.getCod()
                + " 1 semana: " + articulo01.precio_semana());
        System.out.println("Alquiler Artículo: " + articulo02.getCod()
                + " 1 día: " + articulo02.precio1());
        System.out.println("Alquiler Artículo: " + articulo02.getCod()
                + " 2 día: " + articulo02.precio2());
        System.out.println("Alquiler Artículo: " + articulo02.getCod()
                + " 1 semana: " + articulo02.precio_semana());
    }

}
