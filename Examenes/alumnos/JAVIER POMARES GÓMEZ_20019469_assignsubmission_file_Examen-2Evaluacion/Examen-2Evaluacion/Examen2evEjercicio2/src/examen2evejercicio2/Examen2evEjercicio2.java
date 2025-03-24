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

        System.out.println("--------------------");

        System.out.println("Triángulos despues del ordenamiento:");
        for (Triangulo t : triangulos) {
            System.out.println(t);
        }

        System.out.println("--------------------");

        // Eliminar duplicados por área
       Triangulo[] sinDuplicados = eliminarDuplicados(triangulos);
        // Mostrar triángulos después del ordenamiento y eliminación de duplicados
         System.out.println("\nTriángulos después del ordenamiento y eliminación de duplicados:");
       for (Triangulo t : sinDuplicados) {
           System.out.println(t);
       }
    }

    // método de ordenación por selección para ordenar triángulos por área
    public static void ordenarPorSeleccion(Triangulo[] triangulos) {
        int i, j, minimo;
        Triangulo aux;
        for (i = 0; i < triangulos.length - 1; i++) {
            minimo = i;
            for (j = i + 1; j < triangulos.length; j++) {
                if (triangulos[j].calcularArea() < triangulos[minimo].calcularArea()) {
                    minimo = j;
                }
            }
            aux = triangulos[i];
            triangulos[i] = triangulos[minimo];
            triangulos[minimo] = aux;
        }
    }

    // Método para eliminar triángulos duplicados por área

    public static Triangulo[] eliminarDuplicados(Triangulo[] triangulos) {
        int i, j, s = 0;
        Triangulo[] sinDuplicados = new Triangulo[triangulos.length];
        for (i = 0; i < triangulos.length; i++) {
            boolean duplicado = false;
            for (j = 0; j < i; j++) {
                if (triangulos[i].calcularArea() == triangulos[j].calcularArea()) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) {
                sinDuplicados[s++] = triangulos[i];
            }
        }
        return sinDuplicados;
    }
}
