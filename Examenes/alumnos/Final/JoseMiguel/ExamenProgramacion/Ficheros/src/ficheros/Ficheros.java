/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author josgimgar3
 */
public class Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        File f = new File("personal.csv");
        //Añadimos la informacion de personal.csv al personal 
        Auxiliar a = new Auxiliar();
        List<Persona> gente = a.leerPersonas(f.getPath());
        Personal personal = new Personal();
        for (int i = 0; i < gente.size(); i++) {
            personal.addPersona(gente.get(i));
        }

        buscarCumpleañeros("01", personal);
        buscarCumpleañeros("10", personal);

        boolean sali = false;
        while (!sali) {
            System.out.print("Command:");
            int o = sc.nextInt();
            switch (o) {
                case 0 -> {
                    sali = true;
                }
                case 1 -> {
                    System.out.print("Genero:");
                    String da = sc.nextLine();
                    busquedaPorSexo(da, personal);
                }
                
            }
        }

    }

    public static void buscarCumpleañeros(String mes, Personal per) {
        Auxiliar a = new Auxiliar();
        for (int i = 0; i < per.personal.size(); i++) {
            String[] dato = per.personal.get(i).nacimiento.split(",");
            if (dato[4].equals(mes)) {
                if (mes.equals("01")) {
                    String nombreArchivo = "enero.txt";

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
                        Iterable<Persona> personas = null;

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
                } else if (mes.equals("10")) {
                    String nombreArchivo = "diciembre.txt";

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
                        Iterable<Persona> personas = null;

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
        }
    }
    public static void busquedaPorSexo(String gene, Personal per) {
        int a = 0;
        for (int i = 0; i < per.personal.size(); i++) {
            if (per.personal.get(i).genero.equals(gene)) {
                a++;
            }
        }
        System.out.println("Personas con el sexo" + gene + " = " + a);
    }
}
