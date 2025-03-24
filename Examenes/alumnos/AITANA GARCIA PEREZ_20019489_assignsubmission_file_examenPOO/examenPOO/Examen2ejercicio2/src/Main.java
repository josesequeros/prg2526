//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
        System.out.println("Triángulos antes del ordenamiento:");
        for (Triangulo t : triangulos) {
            System.out.println(t);
        }
        // Ordenar usando el método de inserción
        ordenarPorSeleccion(triangulos);
        // Eliminar duplicados por área
        Triangulo[] sinDuplicados = eliminarDuplicados(triangulos);
        // Mostrar triángulos después del ordenamiento y eliminación de duplicados
        System.out.println("\nTriángulos después del ordenamiento y eliminación de duplicados:");
        for (Triangulo t : sinDuplicados) {
            System.out.println(t);
        }
    }

    public static void ordenarPorSeleccion(Triangulo[] triangulos) {
        int n = triangulos.length;
        for (int i = 0; i < n - 1; i++) {
            int aux = i;
            for (int j = i + 1; j < n; j++) {
                if (triangulos[j].calcularArea() < triangulos[aux].calcularArea()) {
                    aux = j;
                }
            }

            Triangulo temp = triangulos[i];
            triangulos[i] = triangulos[aux];
            triangulos[aux] = temp;
        }
    }

    public static Triangulo[] eliminarDuplicados(Triangulo[] triangulos) {
        boolean[] duplicados = new boolean[triangulos.length];
        int contador = 0;

        for (int i = 0; i < triangulos.length; i++) {

            if (!duplicados[i]) {
                for (int j = i + 1; j < triangulos.length; j++) {
                    if (triangulos[i].calcularArea() == triangulos[j].calcularArea()) {
                        duplicados[i] = true;
                    }
                }
                contador++;
            }
        }
        Triangulo[] sinDuplicados = new Triangulo[contador];
        int aux = 0;
        for (int i = 0; i < triangulos.length; i++) {
            if (!duplicados[i]) {
                sinDuplicados[aux++] = triangulos[i];
            }
        }

        return sinDuplicados;
    }
}