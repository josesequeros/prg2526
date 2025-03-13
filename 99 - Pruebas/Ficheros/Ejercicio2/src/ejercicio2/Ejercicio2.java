/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 *
 * @author jabue
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File f = new File("./numNaturales.txt");

        if (!f.exists()) {
            f.createNewFile();
        }

        FileWriter archivo = new FileWriter(f);
        PrintWriter escribe = new PrintWriter(archivo);

        for (int i = 0; i < 100; i++) {

            escribe.println(i + 1);

        }

        escribe.close();

        //ARCHIVO RELLENO DE NUMEROS
        int resultado = obtenerSuma("./numNaturales.txt", 10);
        System.out.println(resultado);

    }

    public static int obtenerSuma(String rutaarchivo, int n) {

        int suma = 0;

        try {

            FileReader f = new FileReader(rutaarchivo);
            BufferedReader lectura = new BufferedReader(f);

            String numeroarchivo = lectura.readLine();
            //for (int i = 0; i < n && numeroarchivo != null; i++) {
            while (numeroarchivo != null) {

                suma += Integer.parseInt(numeroarchivo);

                numeroarchivo = lectura.readLine();
            }

            lectura.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no existe");
        } catch (IOException e) {
            System.out.println("Fallo al abrir archivo");
        }

        return suma;
    }

}
