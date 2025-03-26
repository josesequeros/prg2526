/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numerarlineasfichero;

import java.util.*;
import java.io.*;

/**
 *
 * @author jabue
 */
public class NumerarLineas {

    private FileReader in;
    private FileWriter out;
    private BufferedReader br;
    private BufferedWriter bw;
    private PrintWriter pw;
    private Scanner scanner = new Scanner(System.in);

    public NumerarLineas() throws FileNotFoundException, IOException {
        String inputFile, outputFile;
        System.out.print("Fichero de Entrada: ");
        inputFile = scanner.next();
        System.out.print("Fichero de Salida: ");
        outputFile = scanner.next();
        in = new FileReader(inputFile); // throws FileNotFoundException
        br = new BufferedReader(in); // envolver el FileReader con un BufferedReader
        out = new FileWriter(outputFile); // throws IOException
        bw = new BufferedWriter(out);   // por razones de eficiencia o por seguir la estructura del bufferReader
        pw = new PrintWriter(bw); // envolver BufferedWriter con un PrintWriter (no es necesario, PrintWriter ya posee buffer)
    }

    public NumerarLineas(String inputFile, String outputFile)
            throws FileNotFoundException, IOException {
        in = new FileReader(inputFile); // throws FileNotFoundException
        br = new BufferedReader(in); // envolver el FileReader con un BufferedReader
        out = new FileWriter(outputFile); // throws IOException
        bw = new BufferedWriter(out);   // por razones de eficiencia o por seguir la estructura del bufferReader
        pw = new PrintWriter(bw); // envolver BufferedWriter con un PrintWriter (no es necesario, PrintWriter ya posee buffer)
    }

    public void copiarNumerado() throws IOException {
        String s;
        int linea = 0;
        while ((s = br.readLine()) != null) // readLine() throws IOException
        {
            linea++;
            //System.out.println(s);
            pw.println(linea + ". " + s);
        }
        pw.close();
    }
}




