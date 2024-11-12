/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficherosparesimparessuma;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jabue
 */
public class FicherosParesImparesSuma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int totalLineas = 20;
        int numerosPorLinea = 5;
/*
        FileWriter archivo;
        try {
            archivo = new FileWriter("./numeros.txt");
            PrintWriter salida = new PrintWriter(archivo);
            for (int linea = 0; linea < totalLineas; linea++) {
                int suma = 0;
                for (int i = 0; i < numerosPorLinea; i++) {
                    int numero = (int) (Math.random() * 100);
                    //System.out.print("\t" + numero);
                    salida.write(numero + "\t");
                    suma += numero;
                }
                salida.write(suma + "\t");
                //System.out.println("");
                salida.write("\n");
            }
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
*/
        
        FileReader fr = null;
        FileWriter pares = null;
        FileWriter impares = null;
        try {
            fr = new FileReader("./numeros.txt");
            pares = new FileWriter("./numerosPares.txt");
            impares = new FileWriter("./numerosImpares.txt");
            PrintWriter salidaPares = new PrintWriter(pares);
            PrintWriter salidaImpares = new PrintWriter(impares);
            BufferedReader entrada = new BufferedReader(fr);
            String linea = entrada.readLine();
            while (linea != null) {
                //System.out.println(linea);
                String[] partes = linea.split("\t");
                int[] numeros = new int[numerosPorLinea];
                int suma = 0;
                int ultimoNumero = 0;
                int i = 0;
                for (i = 0; i < numerosPorLinea; i++) {
                    numeros[i] = Integer.parseInt(partes[i]);
                    suma += numeros[i];
                    
                }
                ultimoNumero = Integer.parseInt(partes[i]);
                if (suma == ultimoNumero) {
                    if (suma % 2 == 0) {
                        salidaPares.write(linea + "\n");
                    } else {
                        salidaImpares.write(linea + "\n");
                    }
                }
                else {
                    System.out.println("Error: \t\t" + linea + " - \t" + suma);
                }
                linea = entrada.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fr.close();
                pares.close();
                impares.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
