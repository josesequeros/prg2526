import java.io.File;


public class Ejercicio2 {

    public static void main(String[] args) {
        File f = new File("C:/Users\\jabue\\Documents\\NetBeansProjects2324/prg2324/Pruebas/Cristian/Ficheros/prueba");
        String[] lista;
        if (f.exists()) {
            System.out.println("existe");
            
        } else {
            System.out.println("No existe");
            f.mkdir();
        }

    }
}