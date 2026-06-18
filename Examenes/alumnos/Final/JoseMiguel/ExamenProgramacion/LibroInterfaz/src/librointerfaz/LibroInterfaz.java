/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librointerfaz;

import java.util.Scanner;

/**
 *
 * @author josgimgar3
 */
public class LibroInterfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner dato = new Scanner(System.in);
        Biblioteca lista = new Biblioteca();
        boolean seguir = true;
        while (seguir) {
            String ac = dato.nextLine();
            ac = ac.toUpperCase();
            String aña = "AÑADIR";
            String lis = "LISTAR";
            if(ac.equals(aña)){
            lista.addLibro();
            }
            if(ac.equals(lis)){
                lista.mostrarBiblioteca();
            }
        }
        
    }

    public static String getTitulo(LibroAbstracta l) {
        return l.getTitulo();
    }

    public static String getAutor(LibroAbstracta l) {
          return l.getAutor();
    }

    public static int getFechaPublicacion(LibroAbstracta l) {
        return l.getPublicacion();
    }

    public static String getISBN(LibroAbstracta l) {
        return l.getISBN();
    }

    
}
