/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josgimgar3
 */
public class Auxiliar {

    public List<Persona> leerPersonas(String path) {
        return leerPersonas(path);
    }

    public List<Persona> leerPersonas(File path) {
        List<Persona> lista = new ArrayList<>();
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 6) {
                    String nombre = datos[0];
                    String apellido = datos[1];
                    String email = datos[2];
                    String genero = datos[3];
                    String nacimiento = datos[4];
                    String pais = datos[5];

                    Persona p = new Persona(nombre, apellido, email, genero, nacimiento, pais);
                    lista.add(p);
                }
            }
        } catch (IOException e) {
            System.out.print("Error al leer el archivo " + e.getLocalizedMessage());
        }
        return lista;
    }

    public void guardarPersonaEnero(List<Persona> personas) {
        String nombreArchivo = "enero.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {

            for (Persona p : personas) {
                String linea = p.getNombre() + "," + p.getApellido() + "," + p.getEmail() + ","
                        + p.getGenero() + "," + p.getNacimiento() + "," + p.getPais();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Archivo guardado como: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo");
        }

    }
}
