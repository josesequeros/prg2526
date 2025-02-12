/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testfiguras;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jabue
 */
public class Colores {
    private static final Map<String, Color> colorMap = new HashMap<>();
    
    // Inicializar el mapa de colores
    static {
        colorMap.put("negro", Color.BLACK);
        colorMap.put("azul", Color.BLUE);
        colorMap.put("verde", Color.GREEN);
        colorMap.put("rojo", Color.RED);
        colorMap.put("amarillo", Color.YELLOW);
        colorMap.put("naranja", Color.ORANGE);
        // Agrega más colores según sea necesario
    }
    
    // Método para obtener un color a partir de una cadena
    public static Color getColor(String colorName) {
        // Convierte el nombre del color a minúsculas para evitar errores de capitalización
        colorName = colorName.toLowerCase();
        // Verifica si el color está en el mapa
        if (colorMap.containsKey(colorName)) {
            return colorMap.get(colorName);
        } else {
            // Si el color no está en el mapa, devuelve un color gris
            return Color.GRAY;
        }
    }
}
