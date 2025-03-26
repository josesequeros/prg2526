/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numerarlineasfichero;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author jabue
 */
public class NumerarLineasFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            NumerarLineas numerarLineas = new NumerarLineas("vientosdelpueblo.txt","salida.txt");
            numerarLineas.copiarNumerado();
            System.out.println("Ejecución correcta");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
