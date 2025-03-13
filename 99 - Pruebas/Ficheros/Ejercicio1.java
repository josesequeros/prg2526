import java.io.File;


public class Ejercicio1 {

    public static void main(String[] args) {
        File f = new File("C:/Users\\jabue\\Documents\\NetBeansProjects2324/prg2324/Pruebas/Cristian/Ficheros/Ejercicio1.java");

        if (f.isFile()) {
            System.out.println("El fichero existe");
            System.out.println(f.getName());
            System.out.println(f.length());
            System.out.println(f.getParent());
        } else {
            System.out.println("No existe");
        }

    }
}