import java.io.File;
import java.util.Scanner;


public class Ejercicio4 {

    public static void main(String[] args) {
        File origen = new File(".");
        mostrarArchivos(origen);
    }

    private static void mostrarArchivos(File origen) {
        if(origen.isDirectory()) {
            System.out.println("Directorio: ");
            System.out.println("\t"+origen.getName());
            String[] lista = origen.list();
            for (String nombre : lista) {
                File ruta = new File(origen, nombre);
                mostrarArchivos(ruta);
            }
        }
        else {
            System.out.println("\tArchivo: ");
            System.out.println("\t\t    "+origen.getName());
        }
    }
}