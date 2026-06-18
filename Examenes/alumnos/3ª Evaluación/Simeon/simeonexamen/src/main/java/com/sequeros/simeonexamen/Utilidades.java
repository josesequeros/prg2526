package com.sequeros.simeonexamen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilidades {

    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static ArrayList<Persona> leerPersonas(String nomFich) {
        ArrayList<Persona> lista = new ArrayList<>();
        File f = new File(nomFich);
        if (!f.exists()) {
            return lista;
        }
        try {
            Scanner lector = new Scanner(f);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linea.split(",");
                if (partes.length != 6) {
                    continue;
                }
                String nombre = partes[0];
                String apellidos = partes[1];
                String correo = partes[2];
                String genero = partes[3];
                String fechaTexto = partes[4];
                String pais = partes[5];
                LocalDate fecha = null;
                try {
                    fecha = LocalDate.parse(fechaTexto, FORMATO_FECHA);
                } catch (Exception e) {
                    System.out.println("Fecha no valida: " + fechaTexto);
                }
                lista.add(new Persona(nombre, apellidos, correo, genero, fecha, pais));
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Error leyendo fichero: " + e);
        }
        return lista;
    }

    public static void grabarPersonas(String archivo, ArrayList<Persona> lista) {
        try {
            FileWriter fw = new FileWriter(new File(archivo));
            for (Persona p : lista) {
                String fechaStr = "";
                if (p.getNacimiento() != null) {
                    fechaStr = p.getNacimiento().format(FORMATO_FECHA);
                }
                String linea = p.getNombre() + ","
                        + p.getApellidos() + ","
                        + p.getCorreo() + ","
                        + p.getGenero() + ","
                        + fechaStr + ","
                        + p.getPais() + "\n"; //si no, se porque se rompe, lo úlitmo
                fw.write(linea);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error grabando: " + e);
        }
    }
}
