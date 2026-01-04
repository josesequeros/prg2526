/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo01;

/**
 *
 * @author jabue
 */
public class Ejemplo01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Articulo articulo01 = new Articulo();
        Articulo articulo02 = new Articulo();

        articulo01.cod = "001";
        articulo01.titulo = "Título Artículo 001";
        articulo01.formato = "DVD";
        articulo01.precio_alquiler = 2.5f;

        articulo02.cod = "002";
        articulo02.titulo = "Título Artículo 002";
        articulo02.formato = "DVD";
        articulo02.precio_alquiler = 3f;

        // Utilizar sus métodos
        System.out.println("Alquiler Art.: " + articulo01.cod
                + " 1 día: " + articulo01.precio1());
        System.out.println("Alquiler Art.: " + articulo01.cod
                + " 2 día: " + articulo01.precio2());
        System.out.println("Alquiler Art.: " + articulo01.cod
                + " 1 semana: " + articulo01.precio_semana());
        System.out.println("Alquiler Art.: " + articulo02.cod
                + " 1 día: " + articulo02.precio1());
        System.out.println("Alquiler Art.: " + articulo02.cod
                + " 2 día: " + articulo02.precio2());
        System.out.println("Alquiler Art.: " + articulo02.cod
                + " 1 semana: " + articulo02.precio_semana());
    }

}
