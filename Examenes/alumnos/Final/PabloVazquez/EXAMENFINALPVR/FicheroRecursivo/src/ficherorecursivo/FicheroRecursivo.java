/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficherorecursivo;
import java.io.File;
import java.lang.String;
import java.util.Scanner;
/**
 *
 * @author pabvazrui
 */
public class FicheroRecursivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String ruta = "";
        System.out.println("Inserte la ruta: " + ruta);
        ruta = teclado.nextLine();
        File fichero = new File(ruta);
        
        System.out.println("Tamaño del archivo: " + fichero.length());
        System.out.println("nombre" + fichero.getName());
    }
    
}
