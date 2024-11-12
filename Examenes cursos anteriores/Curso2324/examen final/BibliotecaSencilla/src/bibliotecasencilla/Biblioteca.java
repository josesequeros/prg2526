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

    private ArrayList<LibroAbstracta> biblioteca;

    public Biblioteca(ArrayList<LibroAbstracta> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Biblioteca() {
        this.biblioteca = new ArrayList<>();
    }

    public void addLibro(LibroAbstracta libro) {
        this.biblioteca.add(libro);
    }

    public boolean borrarLibroPorISBN(String isbn) {
        for (LibroAbstracta libro : this.biblioteca) {
            if (libro.getIsbn().equals(isbn)) {
                this.biblioteca.remove(libro);
                return true;
            }
        }
        return false;
    }

    public LibroAbstracta buscarLibroPorISBN(String isbn) {
        for (LibroAbstracta libro : this.biblioteca) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public void mostrarBiblioteca() {
        for (LibroAbstracta libro : this.biblioteca) {
            libro.mostrarInformacion();
        }
    }
}
