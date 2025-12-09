/*
 */

package com.roberto.biblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author Roberto
 */
public class Biblioteca  {

     private static Scene scene;

  
    
    
    public static void main(String[] args) {
        
        
      BibliotecaGestion biblioteca = new BibliotecaGestion();

     biblioteca.addLibro(new LibroFiccion("harry potter", "jk rowling", 1970, "1234A", "harry.jpg", "harry_back.jpg", "fantasia"));
     biblioteca.addLibro(new LibroFiccion("Batman", "Bruce wayne", 1939, "1234B", "batman.jpg", "batman_back.jpg", "ciencia ficcion"));
      biblioteca.addLibro(new LibroFiccion("Iron Man", "Stan Lee", 1965, "1234C", "ironman.jpg", "ironman_back.jpg", "ciencia ficcion"));
        
        biblioteca.addLibro(new LibroNoFiccion("1 guerra mundial", "Herg", 1960, "2234A", "1ww.jpg", "1ww_back.jpg", "historia"));
        biblioteca.addLibro(new LibroNoFiccion("100 cosas que no sabes", "Giovany", 2020, "2234B", "cien.jpg", "cien_back.jpg", "ciencia"));
        biblioteca.addLibro(new LibroNoFiccion("biografia william sekspeare", "william sekspeare", 1672, "2234C", "william.jpg", "william.jpg", "biografia"));
        
    
    biblioteca.mostrarBiblioteca();
    Libroabrsatcta comic = biblioteca.buscarLibroISBN("1234B");
        if (comic != null) {
            comic.mostrarInformacion();
        } else {
            System.out.println("Comic no encontrado.");
        }

        // Buscar por título
        System.out.println("\n=== BUSCAR POR TÍTULO (Batman) ===");
        BibliotecaGestion busquedaTitulo = biblioteca.buscarComicTitulo("Batman");
        busquedaTitulo.mostrarBiblioteca();
        
    }
    
    
    
}
