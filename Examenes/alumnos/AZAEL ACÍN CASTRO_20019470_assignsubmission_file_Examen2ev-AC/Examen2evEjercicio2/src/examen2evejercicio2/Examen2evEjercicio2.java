package examen2evejercicio2;

public class Examen2evEjercicio2 {

    public static void main(String[] args) {
        Triangulo[] triangulos = {
            new Triangulo(5, 10), // Área = 25
            new Triangulo(3, 6), // Área = 9
            new Triangulo(7, 8), // Área = 28
            new Triangulo(4, 5), // Área = 10
            new Triangulo(6, 9), // Área = 27
            new Triangulo(10, 5), // Área = 25 (Duplicado)
            new Triangulo(6, 3) // Área = 9 (Duplicado)
        };

        // Mostrar triángulos antes del ordenamiento
        System.out.println("Triángulos antes del proceso:");
        for (Triangulo t : triangulos) {
            System.out.println(t);
        }

        // Ordenar usando el método de selección
        ordenarPorSeleccion(triangulos);

        // Eliminar duplicados por área
        Triangulo[] sinDuplicados = eliminarDuplicados(triangulos);

        // Mostrar triángulos después del ordenamiento y eliminación de duplicados
        System.out.println("Triángulos después del proceso:");
        for (Triangulo t : sinDuplicados) {
            if (t != null) {
                System.out.println(t);
            }
        }
    }

     // Método de ordenación por selección. Adaptar para ordenar triángulos
    public static void ordenarPorSeleccion(Triangulo[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].calcularArea() < a[min].calcularArea()) {
                    min = j;
                }
            }
            Triangulo aux = a[i];
            a[i] = a[min];
            a[min] = aux;
        }
    }

    // Método para eliminar triángulos duplicados por área
    public static Triangulo[] eliminarDuplicados(Triangulo[] arr) {
        int n = arr.length;
        Triangulo[] aux = new Triangulo[n];
        int indice = 0;

        for (int i = 0; i < n; i++) {
            boolean duplicado = false;
            for (int j = 0; j < indice; j++) {
                if (Double.compare(arr[i].calcularArea(), aux[j].calcularArea()) == 0) {
                    duplicado = true;
                }
            }
            if (!duplicado) {
                aux[indice++] = arr[i];
            }
        }
        
        Triangulo[] resultado = new Triangulo[indice];
        for (int i = 0; i < indice; i++) {
            resultado[i] = aux[i];
        }
        return resultado;
    }
}
