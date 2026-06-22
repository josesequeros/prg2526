/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2evejercicio2;

/**
 *
 * @author jabue
 */
public class Examen2evEjercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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

    public static void seleccion(int[] a) {
        int i, j, aux, minimo;
        //Recorrido del array
        for (i = 0; i < a.length - 1; i++) {
            minimo = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[j] < a[minimo]) {
                    minimo = j;
                }
            }
            aux = a[i];
            a[i] = a[minimo];
            a[minimo] = aux;
        }
    }

    private static void ordenarPorSeleccion(Triangulo[] a) {
        int i, j;
        Triangulo aux;
        int minimo;
        //Recorrido del array
        for (i = 0; i < a.length - 1; i++) {
            minimo = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[j].calcularArea() < a[minimo].calcularArea()) {
                    minimo = j;
                }
            }
            aux = a[i];
            a[i] = a[minimo];
            a[minimo] = aux;
        }
    }

    private static Triangulo[] eliminarDuplicados(Triangulo[] triangulos) {
        Triangulo[] aux = new Triangulo[triangulos.length];
        int j = 0;
        for (int i = 0; i < triangulos.length; i++) {
            aux[j] = triangulos[i];
            while ((i + 1) < triangulos.length - 1 && aux[j].calcularArea() == triangulos[i + 1].calcularArea()) {
                i++;
            }
            j++;
        }

        Triangulo[] filtrado = new Triangulo[j];
        for (int i = 0; i < j; i++) {
            filtrado[i] = aux[i];
        }
        return filtrado;
    }

    private static Triangulo[] eliminarDuplicados2(Triangulo[] triangulos) {
        Triangulo[] aux = new Triangulo[triangulos.length];
        int j = 0;
        aux[j++] = triangulos[0];
        for (int i = 1; i < triangulos.length; i++) {
            aux[j] = triangulos[i];
            if (triangulos[i - 1].calcularArea() != triangulos[i].calcularArea()) {
                aux[j++] = triangulos[i];
            }
        }

        Triangulo[] filtrado = new Triangulo[j];
        for (int i = 0; i < j; i++) {
            filtrado[i] = aux[i];
        }
        return filtrado;
    }
}
