/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librointerfaz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josgimgar3
 */
public class Biblioteca {

    private ArrayList<LibroAbstracta> lista;

    public void addLibro() {
        Scanner dato = new Scanner(System.in);
        System.out.println("1.LibroAbstracta 2.LibroFiccion 3.LibroNoFiccion");
        int o = dato.nextInt();
        switch (o) {
            case 1 -> {
                String titulo = dato.nextLine();
                String autor = dato.nextLine();
                int publicacion = dato.nextInt();
                String ISBN = dato.nextLine();
                lista.add(new LibroAbstracta(titulo, autor, publicacion, ISBN));
            }
            case 2 -> {
                String titulo = dato.nextLine();
                String autor = dato.nextLine();
                int publicacion = dato.nextInt();
                String ISBN = dato.nextLine();
                String genero = dato.nextLine();
                lista.add(new LibroFiccion(titulo, autor, publicacion, ISBN, genero));
            }
            case 3 -> {
                String titulo = dato.nextLine();
                String autor = dato.nextLine();
                int publicacion = dato.nextInt();
                String ISBN = dato.nextLine();
                String tema = dato.nextLine();
                lista.add(new LibroNoFiccion(titulo, autor, publicacion, ISBN, tema));
            }
        }
    }

    public void borrarLibro() {
        Scanner dato = new Scanner(System.in);
        System.out.println("1.LibroAbstracta 2.LibroFiccion 3.LibroNoFiccion");
        int o = dato.nextInt();

        String titulo = dato.nextLine();

        for (LibroAbstracta l : lista) {
            if (l.getTitulo().equals(titulo)) {
                lista.remove(l);
            }
        }

    }
    public  LibroAbstracta buscarLibro() {
        Scanner dato = new Scanner(System.in);
        System.out.println("1.LibroAbstracta 2.LibroFiccion 3.LibroNoFiccion");
        int o = dato.nextInt();

        String titulo = dato.nextLine();

        for (LibroAbstracta l : lista) {
            if (l.getTitulo().equals(titulo)) {
                return l;
            }
        }
        return null;
    }
    public  void mostrarBiblioteca() {
        
        for (LibroAbstracta l : lista) {
            String libro = l.toString();
            System.out.println(libro);
        }
      
    }
}


