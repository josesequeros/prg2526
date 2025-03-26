/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testtextoabinario;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jabue
 */
public class BinarioATexto {

    public static void makeTextFile(String textFile, String binaryFile)
            throws IOException {
        FileInputStream infile = null;
        DataInputStream in = null;
        FileOutputStream outfile = null;
        PrintWriter out = null;
        int count = 0;
        try {
            infile = new FileInputStream(binaryFile);
            in = new DataInputStream(infile);
            outfile = new FileOutputStream(textFile);
            out = new PrintWriter(outfile);
            while (true) // do until EOFException
            {
                int number = in.readInt();
                count++;
                out.print(number);
                if (count % 10 == 0) {
                    out.println();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) // when end of file has been reached
        {
            System.out.println(count + " values read");
        } finally {
            if ((out != null)) {
                out.close();
            }
        }
    }
}
