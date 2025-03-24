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
                new Triangulo(10, 5),
                new Triangulo(8, 4),
                new Triangulo(6, 7),
                new Triangulo(12, 3),
                new Triangulo(5, 5)
        };

        System.out.println("Triángulos antes de ordenar:");
        for (Triangulo t : triangulos) {
            System.out.println(t);
        }

        Triangulo.ordenarPorArea(triangulos);

        System.out.println("\nTriángulos después de ordenar:");
        for (Triangulo t : triangulos) {
            System.out.println(t);
        }
    }
}


// He intentado hacerlo de la manera con todos los comentarios dejados pero esta es la unica que se me habia ocurrido
// y que funcionara a la par correctamentr, o eso crreo. He comentado el codigo dejado anteriormente por si acaso.

// Triangulo[] triangulos = {
// new Triangulo(5, 10), // Área = 25
// new Triangulo(3, 6), // Área = 9
// new Triangulo(7, 8), // Área = 28
// new Triangulo(4, 5), // Área = 10
// new Triangulo(6, 9), // Área = 27
// new Triangulo(10, 5), // Área = 25 (Duplicado)
// new Triangulo(6, 3) // Área = 9 (Duplicado)
// };
//
// // Mostrar triángulos antes del ordenamiento
// System.out.println("Triángulos antes del ordenamiento:");
// for (Triangulo t : triangulos) {
// System.out.println(t);
// }
//// Ordenar usando el método de inserción
// ordenarPorSeleccion(triangulos);
//
//// Eliminar duplicados por área
// Triangulo[] sinDuplicados = eliminarDuplicados(triangulos);
//// Mostrar triángulos después del ordenamiento y eliminación de duplicados
// System.out.println("\nTriángulos después del ordenamiento y eliminación de
// duplicados:");
// for (Triangulo t : sinDuplicados) {
// System.out.println(t);
// }
// }

// método de ordenación por selección. Adaptar para ordenar triángulos
// public static void seleccion(int[] a) {
// int i, j, aux, minimo;
// //Recorrido del array
// for (i = 0; i < a.length - 1; i++) {
// minimo = i;
// for (j = i + 1; j < a.length; j++) {
// if (a[j] < a[minimo]) {
// minimo = j;
// }
// }
// aux = a[i];
// a[i] = a[minimo];
// a[minimo] = aux;
// }
// }

// Crear un método que devuelva el array eliminando el elemento que tenga la
// misma área que uno ya existente.

// Triangulo[] triangulos = {
// new Triangulo(10, 5),
// new Triangulo(8, 4),
// new Triangulo(6, 7),
// new Triangulo(12, 3),
// new Triangulo(5, 5)
// };
//
// System.out.println("Triángulos antes de ordenar:");
// for (Triangulo t : triangulos) {
// System.out.println(t);
// }
//
// Triangulo.ordenarPorArea(triangulos);
//
// System.out.println("\nTriángulos después de ordenar:");
// for (Triangulo t : triangulos) {
// System.out.println(t);
// }
