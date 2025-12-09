/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.autoresexamen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Auxiliar {

    public static ArrayList<Autor> leerAutores(String nomFich) {
        ArrayList<Autor> autores = new ArrayList<>();
        // Declarando el Scanner en el try tenemos el cierre automático del mismo
        try (Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US)) {
            while (f.hasNext()) {
                String linea = f.nextLine();
                String[] partes = linea.split(",");
                String dni = partes[0];
                String nombre = partes[1];
                String apellidos = partes[2];
                String nacimiento = partes[3];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(nacimiento, formatter);
                String pathImagen = partes[4];
                Autor persona = new Autor(dni, nombre, apellidos, date, pathImagen);

                autores.add(persona);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error leyendo datos");
         }
        return autores;
    }

    public static void grabarAutores(String archivo, ArrayList<Autor> lista) {
        try {
            // Intentamos abrir el fichero
            File f = new File(archivo);
            FileWriter fw = new FileWriter(f);
            for (Autor autor : lista) {
                fw.write(autor.getDni());
                fw.write(",");
                fw.write(autor.getNombre());
                fw.write(",");
                fw.write(autor.getApellidos());
                fw.write(",");
                fw.write(autor.getNacimiento().get().toString());
                fw.write(",");
                fw.write(autor.getPathImagen());
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
