/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sequeros.autoreslibros;

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
        //ArrayList<Persona> personal = new ArrayList<>();
        ArrayList<Autor> autores = new ArrayList<>();
        // Declarando el Scanner en el try tenemos el cierre automático del mismo
        try (Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US)) {
            //Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
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
            //personal = null;
        }
        // f.close
        return autores;
    }

    public static void grabarAutores(String archivo, ArrayList<Autor> lista) {
        archivo = archivo;
        for (Autor autor : lista) {
            System.out.println(autor);
        }
        try {
            // Intentamos abrir el fichero
            File f = new File(archivo);
            //Scanner lector = new Scanner(f);
            FileWriter fw = new FileWriter(f);
            for (Autor autor : lista) {
                System.out.println(autor.getPathImagen());
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
}
