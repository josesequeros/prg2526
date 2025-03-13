import java.io.File;


public class Ejercicio5 {

    public static void main(String[] args) {
        File origen = new File("c:/");
        mostrarArchivosporA(origen);
    }

    private static void mostrarArchivosporA(File origen) {
        if (origen.isDirectory()) {
            String[] lista = origen.list();
            for (String nombre : lista) {
                //System.out.println(nombre);
                if (nombre.startsWith("A")) {
                    //System.out.println(nombre);
                    File ruta = new File(origen, nombre);
                    if (ruta.isFile()) {
                        System.out.println(ruta.getAbsoluteFile());
                    }
                }
            }
        } else {
            System.out.println("No existe el directorio");
        }
    }
}
