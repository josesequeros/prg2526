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
        Triangulo[] triangulos = {
                new Triangulo(5, 10), // Área = 25
                new Triangulo(3, 6), // Área = 9
                new Triangulo(7, 8), // Área = 28
                new Triangulo(4, 5), // Área = 10
                new Triangulo(6, 9), // Área = 27
                new Triangulo(10, 5), // Área = 25 (Duplicado)
                new Triangulo(6, 3) // Área = 9 (Duplicado)
        };

        System.out.println("Triángulos antes del ordenamiento:");
        for (Triangulo t : triangulos) {
            System.out.println(t);
        }

        ordenarPorSeleccion(triangulos);

        Triangulo[] sinDuplicados = eliminarDuplicados(triangulos);
        System.out.println("");
        System.out.println("Triángulos después del ordenamiento y eliminación de duplicados:");
        for (Triangulo t : sinDuplicados) {
            System.out.println(t);
        }
    }

    public static void ordenarPorSeleccion(Triangulo[] triangulos) {
        for (int i = 0; i < triangulos.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < triangulos.length; j++) {
                if (triangulos[j].calcularArea() < triangulos[minimo].calcularArea()) {
                    minimo = j;
                }
            }
            Triangulo temp = triangulos[i];
            triangulos[i] = triangulos[minimo];
            triangulos[minimo] = temp;
        }
    }

    public static Triangulo[] eliminarDuplicados(Triangulo[] triangulos) {
        int n = triangulos.length;
        Triangulo[] sinDuplicados = new Triangulo[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean esDuplicado = false;
            for (int j = 0; j < index; j++) {
                if (triangulos[i].calcularArea() == sinDuplicados[j].calcularArea()) {
                    esDuplicado = true;
                    break;
                }
            }
            if (!esDuplicado) {
                sinDuplicados[index++] = triangulos[i];
            }
        }

        Triangulo[] resultadoFinal = new Triangulo[index];
        System.arraycopy(sinDuplicados, 0, resultadoFinal, 0, index);
        return resultadoFinal;
    }
}
