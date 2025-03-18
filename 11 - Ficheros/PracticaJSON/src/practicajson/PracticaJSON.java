/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicajson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jabue
 */
public class PracticaJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Persona> listaPersonas;
        Personal personal;
        personal = Auxiliar.leerPersonas("personal.csv");
        listaPersonas = personal.getPersonal();
        System.out.println(listaPersonas.size());
        guardarPersonasEnJson(listaPersonas, "personal.json");
        
        ArrayList<Persona> personal2 = leerPersonasDesdeJson("personal.json");
        System.out.println(personal2.size());
    }

    private static void guardarPersonasEnJson(ArrayList<Persona> listaPersonas, String archivo) {
    ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Formato bonito

        try {
            objectMapper.writeValue(new File(archivo), listaPersonas);
            System.out.println("Personal guardado en " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Persona> leerPersonasDesdeJson(String archivo) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Persona> personas = new ArrayList<>();

        try {
            personas = objectMapper.readValue(new File(archivo), new TypeReference<ArrayList<Persona>>() {});
            System.out.println("Personal cargadas correctamente desde " + archivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }

        return personas;
    }
    
}
