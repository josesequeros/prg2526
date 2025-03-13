import java.io.File;
import java.util.Scanner;


public class Ejercicio3 {

    public static void main(String[] args) {
        System.out.println("Nombre del directorio a crear: ");
        Scanner entrada = new Scanner(System.in);
        String nombre = entrada.nextLine();
        File ruta = new File("./" + nombre);
        if (ruta.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            System.out.println("Creamos el directorio");
            if (ruta.mkdir()) {
                System.out.println("Directorio Creado");
            } else {
                System.out.println("Error al crear el directorio");
            }
        }

    }
}