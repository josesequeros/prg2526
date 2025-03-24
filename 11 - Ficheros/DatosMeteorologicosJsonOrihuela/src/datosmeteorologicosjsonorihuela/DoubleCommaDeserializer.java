/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosmeteorologicosjsonorihuela;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

/**
 *
 * @author jabue
 */
public class DoubleCommaDeserializer extends JsonDeserializer<Double> {
    @Override
    public Double deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().replace(",", "."); // Reemplaza coma por punto
        try {
            return Double.parseDouble(value); // Convierte a double
        } catch (NumberFormatException e) {
            return 0.0; // Valor por defecto si hay error
        }
    }
}
