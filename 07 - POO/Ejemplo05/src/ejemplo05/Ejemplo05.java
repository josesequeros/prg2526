/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo05;

/**
 *
 * @author IEUser
 */
public class Ejemplo05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        //Articulo articulo01 = new Articulo();
        //Articulo articulo02 = new Articulo();
        // Utilizamos el constructor
        Articulo articulo01 = new Articulo("Identificador001", "001", "Título Artículo 001", "DVD", 2.5f);
        Articulo articulo02 = new Articulo("Identificador002", "002", "Título Artículo 002", "DVD", 3f);
        /*
        //Asignamos valores a los atributos de cada artículo
        articulo01.setCod("001");
        articulo01.setTitulo("Título Artículo 001");
        articulo01.setFormato("DVD");
        articulo01.setPrecio_alquiler(2.5f);

        articulo02.setCod("002");
        articulo02.setTitulo("Título Artículo 002");
        articulo02.setFormato("DVD");
        articulo02.setPrecio_alquiler(3f);
         */
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

        // Ejemplo 06 Vecor de Objetos
        Articulo[] misArticulos = new Articulo[10];
        
        for (int i = 0; i < 10; i++) {
            misArticulos[i] = new Articulo("Identificador"+i, "Cod "+i, "Artículo "+i, "DVD", (float)(i*10));
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(misArticulos[i].toString());
        }

    }

}
