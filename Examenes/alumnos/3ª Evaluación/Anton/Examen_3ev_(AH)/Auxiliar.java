import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class Auxiliar {

    public static ArrayList<Persona> leerPersonas(String nombreFichero) {
        ArrayList<Persona> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String nombre = datos[0];
                String apellidos = datos[1];
                String email = datos[2];
                String genero = datos[3];
                LocalDate nacimiento = LocalDate.parse(datos[4], Persona.FORMATO_FECHA);
                String pais = datos[5];

                Persona persona = new Persona(nombre, apellidos, email, genero, nacimiento, pais);
                lista.add(persona);
            }

        } catch (Exception ex) {
            System.out.println("Error en leer las personas!");
        }

        return lista;
    }
}