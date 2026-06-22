/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.comicteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Auxiliar {

    public static ArrayList<ComicAbstracta> leerComics(String nomFich) {
        ArrayList<ComicAbstracta> comics = new ArrayList<>();
        // Declarando el Scanner en el try tenemos el cierre automático del mismo
        try (Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US)) {
            while (f.hasNext()) {
                String linea = f.nextLine();
                String[] partes = linea.split(",");
                String titulo = partes[0];
                String autor = partes[1];
                int publicacion = Integer.valueOf(partes[2]);
                String isbn = partes[3];
                String portada = partes[4];
                String portadaAlternativa = partes[5];
                String universo = partes[6];
                String tipo = partes[7];
                ComicAbstracta comic;
                if (tipo.equals("superheroes")) {
                    comic = new ComicSuperheroes(titulo, autor, publicacion, isbn, portada, portadaAlternativa, universo);
                } else {
                    String editorial = universo;    // por claridad
                    comic = new ComicEuropeo(titulo, autor, publicacion, isbn, portada, portadaAlternativa, editorial);
                }
                comics.add(comic);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error leyendo datos");
            System.out.println(ex.getMessage());
        }
        return comics;
    }

    public static void grabarComics(String archivo, ArrayList<ComicAbstracta> lista) {
        try {
            // Intentamos abrir el fichero
            File f = new File(archivo);
            FileWriter fw = new FileWriter(f);
            for (ComicAbstracta comic : lista) {
                fw.write(comic.getTitulo());
                fw.write(",");
                fw.write(comic.getAutor());
                fw.write(",");
                fw.write(comic.getPublicacion()+"");
                fw.write(",");
                fw.write(comic.getISBN());
                fw.write(",");
                fw.write(comic.getPortada());
                fw.write(",");
                fw.write(comic.getPortadaAlternativa());
                fw.write(",");
                if (comic instanceof ComicSuperheroes) {
                    fw.write(((ComicSuperheroes) comic).getUniverso());
                    fw.write(",");
                    fw.write("superheroes");
                } else {
                    fw.write(((ComicEuropeo) comic).getEditorial());
                    fw.write(",");
                    fw.write("europeo");
                }

                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public static boolean validarNif(String nif) {
        if (nif == null || nif.length() != 9) {
            return false;
        }
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P',
            'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        char letra = nif.charAt(nif.length() - 1);
        long numero = Long.parseLong(nif.substring(0, nif.length() - 1));
        return letras[(int) (numero % 23)] == letra;

    }
}
