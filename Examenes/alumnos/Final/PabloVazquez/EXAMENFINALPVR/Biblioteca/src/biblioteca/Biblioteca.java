/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pabvazrui
 */
public class Biblioteca {

    Scanner teclado = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] agrs) throws InterruptedException {
        List<LibroInterfaz> biblioteca = new ArrayList<>();
        LibroAbstracta libro1 = new LibroAbstracta("Quijote", "Miguel", 1600, "A", "Comedia", "Aventuras") {

            @Override
            public void mostrarInformacion() {
                System.out.println("Informacion: ");
                System.out.println("Titulo: " + titulo);
                System.out.println("Autor: " + autor);
                System.out.println("Fecha: " + publicacion);
                System.out.println("ISBN: " + isbn);
                System.out.println("Genero: " + genero);
                System.out.println("Tema: " + tema);
            }

            @Override
            public String getTitulo() {
                return titulo;
            }

            @Override
            public String getAutor() {
                return autor;
            }

            @Override
            public String getISBN() {
                return isbn;
            }

            @Override
            public void getFechaPublicacion(int publicacion) {
                System.out.println(publicacion);
            }
        };
        biblioteca.add(libro1);
    }

    public String borrarLibro(String isbn) {
        System.out.println("Inserte el isbn del libro que quiere borrar: " + isbn);
        isbn = teclado.nextLine();
        return "libro borrado";
    }

    public String buscarLibro(String titulo) {

        return "El libro que has buscado con el titulo: " + titulo + "esta en la biblioteca";

    }
    /**
    public void mostrarBiblioteca() {
        for (ListaAbstracta v : biblioteca) {
            v.mostrarInformacion();
            System.out.println("Días desde mantenimiento: " + v.diasDesdeUltimoMantenimiento());
            System.out.println("-----------------------");
        }
    }
    * */ // Profe, el metodo biblioteca seria algo asi creo, es con un bucle que recorre la lista biblioteca
}
