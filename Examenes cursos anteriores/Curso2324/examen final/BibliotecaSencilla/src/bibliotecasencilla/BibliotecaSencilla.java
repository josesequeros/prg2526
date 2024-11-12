/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecasencilla;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class BibliotecaSencilla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.addLibro(new LibroNoFiccion("Nombres Fósiles", "Autor 1", 1980, "isbn001", "hombresFosiles.jpg", "tema 01"));
        biblioteca.addLibro(new LibroNoFiccion("Física Existencial", "autor 2", 1982, "isbn 02", "fisicaExistencial.jpg", "tema 2"));
        biblioteca.addLibro(new LibroFiccion("Elantris", "Autor 3", 1983, "isbn 03", "elantris.jpg", "genero 01"));
        
        biblioteca.mostrarBiblioteca();
        
        System.out.println("");
        System.out.println("Introduzca el isbn a buscar: ");
        String isbn = teclado.nextLine();
        LibroAbstracta libro = biblioteca.buscarLibroPorISBN(isbn);
        if ( libro != null) {
            libro.mostrarInformacion();
        }
        else {
            System.out.println("Libro no encontrado");
        }
        System.out.println("");
        
        if(biblioteca.borrarLibroPorISBN(isbn)) {
            System.out.println("libro borrado\n");
        }
        else {
            System.out.println("No existe el libro con isbn: "+isbn);
        }
        biblioteca.mostrarBiblioteca();
        
    }
    
}
