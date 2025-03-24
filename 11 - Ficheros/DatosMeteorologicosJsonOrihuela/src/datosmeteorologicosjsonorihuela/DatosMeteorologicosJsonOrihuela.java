/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datosmeteorologicosjsonorihuela;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jabue
 */
public class DatosMeteorologicosJsonOrihuela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String archivoJson = "DatosMeteorologicosOrihuela2024.json"; // Nombre del archivo JSON

        // Cargar datos del JSON
        //DatosMeteorologicos datos = leerDatosDesdeJson(archivoJson);
        // Cargar lista de datos meteorológicos
        List<DatosMeteorologicos> listaDatos = leerDatosDesdeJson(archivoJson);

        
        // Mostrar los datos cargados
        if (listaDatos != null) {
            for (DatosMeteorologicos datos : listaDatos) {
                System.out.println(datos);
                System.out.println("------------------------");
            }
        }
        System.out.println("------");
            for (DatosMeteorologicos datos : listaDatos) {
                System.out.println(datos.getPrec());
                System.out.println("------------------------");
            }
    }

    public static List<DatosMeteorologicos> leerDatosDesdeJson(String archivo) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(archivo),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, DatosMeteorologicos.class));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
            return null;
        }
    }
}
