/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jabue
 */
public class Ejercicio_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ficheroBinario = "numeros.bin";

        File fichero = new File(ficheroBinario);
        if (!fichero.exists()) {
            try {
                crearFicheroBinario(ficheroBinario);
                System.out.println("Archivo binario creado");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            //System.exit(2);
        } else {
            System.out.println("El archivo binario ya existe");
        }
        System.out.println("Leyendo archivo binario");
        mostrarFrecuencia(ficheroBinario);
    }

    private static void crearFicheroBinario(String ficheroBinario) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(ficheroBinario);
        DataOutputStream out = new DataOutputStream(fout);

        int totalNumeros = (int) (Math.random() * 500 + 1);
        System.out.println("Generando " + totalNumeros + " numeros");
        //totalNumeros = 123;
        for (int i = 0; i < totalNumeros; i++) {
            int n = (int) (Math.random() * 100 + 1);
            out.writeInt(n);
        }
        out.close();
    }

    private static void mostrarFrecuencia(String ficheroBinario) {
        FileInputStream fis = null;
        DataInputStream dis = null;

        Map<Integer, Integer> frecuencias = new HashMap<>();
        int total = 0;
        int totalFrecuencias = 0;

        try {
            fis = new FileInputStream(ficheroBinario);
            dis = new DataInputStream(fis);

            while (true) // do until EOFException
            {
                try {
                    int numero = dis.readInt();
                    total++;
                    frecuencias.put(numero, frecuencias.getOrDefault(numero, 0) + 1);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error leyendo el archivo");
        }

        System.out.println(total + " Total de numeros");
        System.out.println("Frecuencias:");
        for (Map.Entry<Integer, Integer> entrada : frecuencias.entrySet()) {
            System.out.printf("Número %3d: %d veces\n", entrada.getKey(), entrada.getValue());
            totalFrecuencias += entrada.getValue();
        }
        System.out.println("Total Frecuencias: " + totalFrecuencias);
        /*
        for (Integer key : frecuencias.keySet()) {
            System.out.println(key + " " + frecuencias.get(key));
        }
        System.out.println("Total Frecuencias: " + totalFrecuencias);
        */
    }

}
