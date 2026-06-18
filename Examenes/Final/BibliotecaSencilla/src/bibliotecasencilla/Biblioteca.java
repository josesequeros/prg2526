/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecasencilla;

import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public class Biblioteca {

    private ArrayList<LibroInterfaz> biblioteca;

    public Biblioteca(ArrayList<LibroInterfaz> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Biblioteca() {
        this.biblioteca = new ArrayList<>();
    }

    public void addLibro(LibroInterfaz libro) {
        this.biblioteca.add(libro);
    }

    public boolean borrarLibroPorISBN(String isbn) {
        for (LibroInterfaz libro : this.biblioteca) {
            if (libro.getIsbn().equals(isbn)) {
                this.biblioteca.remove(libro);
                return true;
            }
        }
        return false;
    }

    public LibroInterfaz buscarLibroPorISBN(String isbn) {
        for (LibroInterfaz libro : this.biblioteca) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public void mostrarBiblioteca() {
        for (LibroInterfaz libro : this.biblioteca) {
            libro.mostrarInformacion();
        }
    }
}
