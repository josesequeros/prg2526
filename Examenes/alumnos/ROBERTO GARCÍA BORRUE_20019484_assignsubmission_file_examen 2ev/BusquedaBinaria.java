/**
 * 5. Búsqueda Binaria
 * Implementación de una función recursiva que busca un elemento en un array ordenado.
 */
public class BusquedaBinaria {
    
    /**
     * Busca un elemento en un array ordenado y devuelve su posición.
     * 
     * @param array El array ordenado donde buscar
     * @param elemento El elemento a buscar
     * @param inicio El índice inicial del rango de búsqueda
     * @param fin El índice final del rango de búsqueda
     * @return La posición del elemento o -1 si no se encuentra
     */
    public static int busquedaBinaria(int[] array, int elemento, int inicio, int fin) {
        // Caso base: elemento no encontrado
        if (inicio > fin) {
            return -1;
        }
        
        // Calcular el punto medio
        int medio = inicio + (fin - inicio) / 2;
        
        // Caso base: elemento encontrado
        if (array[medio] == elemento) {
            return medio;
        }
        
        // Casos recursivos
        if (array[medio] > elemento) {
            // Buscar en la mitad izquierda
            return busquedaBinaria(array, elemento, inicio, medio - 1);
        } else {
            // Buscar en la mitad derecha
            return busquedaBinaria(array, elemento, medio + 1, fin);
        }
    }
    
    /**
     * Sobrecarga para facilitar el uso de la búsqueda binaria.
     */
    public static int busquedaBinaria(int[] array, int elemento) {
        return busquedaBinaria(array, elemento, 0, array.length - 1);
    }
    
    /**
     * Método principal para probar la función de búsqueda binaria.
     */
    public static void main(String[] args) {
        System.out.println("Búsqueda binaria usando recursión:");
        
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        
        // Ejemplos de búsqueda
        System.out.println("Buscando 7 en el array: posición " + busquedaBinaria(array, 7));    // 3
        System.out.println("Buscando 11 en el array: posición " + busquedaBinaria(array, 11));  // 5
        System.out.println("Buscando 4 en el array: posición " + busquedaBinaria(array, 4));    // -1 (no existe)
        System.out.println("Buscando 20 en el array: posición " + busquedaBinaria(array, 20));  // -1 (no existe)
        
        // Mostrar el array para referencia
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Índices:  0  1  2  3  4   5   6   7   8   9");
    }
}