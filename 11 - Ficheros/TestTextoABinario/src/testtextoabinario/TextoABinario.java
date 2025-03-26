/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testtextoabinario;

import java.io.*;
import java.util.*;

/**
 *
 * @author jabue
 */
public class TextoABinario {

    public static void crearFicheroBinario(String textFile, String binaryFile)
            throws IOException {
        Scanner input = new Scanner(new File(textFile));
        int number;
        FileOutputStream fout = new FileOutputStream(binaryFile);
        DataOutputStream out = new DataOutputStream(fout);
        while (input.hasNext()) {
            number = input.nextInt();
            out.writeInt(number);
        }
        out.close();
    }

}
