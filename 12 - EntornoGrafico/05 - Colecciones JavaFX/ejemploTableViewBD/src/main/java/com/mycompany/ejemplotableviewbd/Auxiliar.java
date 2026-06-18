/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplotableviewbd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public static Personal leerPersonas(String nomFich) {
        //ArrayList<Persona> personal = new ArrayList<>();
        Personal personal = new Personal();
        // Declarando el Scanner en el try tenemos el cierre automático del mismo
        try (Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US)) {
            //Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
            while (f.hasNext()) {
                String linea = f.nextLine();
                String[] partes = linea.split(",");
                String nombre = partes[0];
                String apellido = partes[1];
                String email = partes[2];
                String genero = partes[3];
                String nacimiento = partes[4];
                LocalDate fechaNacimiento = LocalDate.parse(partes[4], DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                //System.out.println(fechaNacimiento.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                String pais = partes[5];
                Persona persona = new Persona(nombre, apellido, email, genero, fechaNacimiento, pais);

                personal.addPersona(persona);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error leyendo datos");
            //personal = null;
        }
        // f.close
        return personal;
    }

    public static void grabarPersonas(String archivo, ArrayList<Persona> lista) {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        DateTimeFormatter formatoFechaNacimiento = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        archivo = archivo + "_" + ahora.format(formato) + ".csv";
        try {
            // Intentamos abrir el fichero
            File f = new File(archivo);
            //Scanner lector = new Scanner(f);
            FileWriter fw = new FileWriter(f);
            //PrintWriter pw = new PrintWriter(new File("salida.txt"));
            /*
            FileOutputStream fos = new FileOutputStream(archivo);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter fw = new BufferedWriter(osw);
             */
            // Si llega aquí es que ha abierto el fichero :)
            for (Persona persona : lista) {
                fw.write(persona.getNombre());
                fw.write(",");
                fw.write(persona.getApellidos());
                fw.write(",");
                fw.write(persona.getEmail());
                fw.write(",");
                fw.write(persona.getGenero());
                fw.write(",");
                String textoFechaNacimiento = persona.getNacimiento().format(formatoFechaNacimiento);
                System.out.println(textoFechaNacimiento);
                fw.write(textoFechaNacimiento);
                fw.write(",");
                fw.write(persona.getPais());
                fw.write("\n");
            }
            fw.flush();
            fw.close();
            //pw.flush();
            //pw.close();

        } catch (IOException e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
    
    
    
public static Personal leerPersonasBufferedReader(String nomFich) {
        Personal personal = new Personal();

        try (BufferedReader br = new BufferedReader(new FileReader(nomFich))) {
            String linea;
            while ((linea = br.readLine())!=null  ) {
                //System.out.println(linea);
                String partes[] = linea.split(",");
                String nombre = partes[0];
                String apellido = partes[1];
                String email = partes[2];
                String genero = partes[3];
                String nacimiento = partes[4];
                LocalDate fechaNacimiento
                        = LocalDate.parse(
                                nacimiento,
                                DateTimeFormatter.ofPattern("yyyy/MM/dd")
                        );
                String pais = partes[5];
                Persona p = new Persona(nombre, apellido, email, genero, fechaNacimiento, pais);
                personal.addPersona(p);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error leyendo datos");
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
        return personal;
    }

}
