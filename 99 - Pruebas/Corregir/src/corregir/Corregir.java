/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package corregir;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Corregir {

    public static int inundada = 1;

    public static void mostrar(int[][] superficie, int filas, int columnas) {
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                System.out.printf("%4d", superficie[i][j]);
            }
            System.out.println("");
        }
    }

    //comprobará las casillas 
    public static void comprobrar(int contador, int[][] superficie, int fila, int columna) {
        if (superficie[fila][columna] <= contador) {
            superficie[fila][columna] = 22;
            inundada++;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner teclado = new Scanner(System.in);

        int p = 0;
        int f = 0;
        int contador = 0;
        int mitad = 0;
        int mitad0 = 0;

        do {
            System.out.print("Escribe el ancho del terreno: ");
            p = teclado.nextInt();
            System.out.print("Escribe el alto del terreno, debe ser impar: ");
            f = teclado.nextInt();

            if (p < 1 || p > 100 || f < 1 || f > 100 || f % 2 == 0) {
                System.out.println("Los números introducidos no son validos");

            }
        } while (p < 1 || p > 100 || f < 1 || f > 100 || f % 2 == 0);

        int[][] superficie = new int[f][p];

        //asignaremos para cada uno de los huecos de la matriz un valor aleatorio entre 0 y 10.
        for (int filas = 0; filas < f; filas++) {
            for (int columnas = 0; columnas < p; columnas++) {
                superficie[filas][columnas] = (int) (Math.random() * 10);
            }
        }
                // El terreno del ejemplo
        superficie = new int[][]{{3, 9, 1, 8, 2, 6}, {0, 0, 4, 4, 0, 5}, {1, 1, 1, 1, 1, 3}};
        superficie = new int[][]{
            {2, 1, 2, 4, 2},
            {6, 6, 6, 6, 6},
            {2, 1, 2, 4, 6},
            {0, 3, 3, 9, 0},            
            {3, 7, 8, 9, 3}
        };

        mitad0 = f / 2;
        superficie[mitad0][0] = 0;
        mostrar(superficie, p, f);
        mitad = ((p * f) / 2);

        superficie[mitad0][0] = 22;

        while (contador <= 10 && inundada <= mitad) {
            contador++;
            for (int filas = 0; filas < f; filas++) { //alto
                for (int columnas = 0; columnas < p; columnas++) { //ancho
                    //si la posición en la que nos encontramos esta inundada, la que hemos indicado como 22 revisará en las direcciones si hay alguna casilla posible de inundar.
                    if (superficie[filas][columnas] == 22) {
                        //Comprobación a su izquierda
                        if (columnas - 1 >= 0) {
                            comprobrar(contador, superficie, filas, (columnas - 1));
                        }
                        //Comprobación a la derecha
                        if (columnas + 1 < p) {
                            comprobrar(contador, superficie, filas, (columnas + 1));
                        }

                        //comprobación hacia arriba
                        if (filas - 1 >= 0) {
                            comprobrar(contador, superficie, (filas - 1), columnas);
                        }

                        //comrpobación hacia abajo
                        if (filas + 1 < f) {
                            comprobrar(contador, superficie, (filas + 1), columnas);
                        }

                    }
                }
            }
            //aumentamos la cantidad del agua que hay
            
            System.out.println(inundada);
            mostrar(superficie, p, f);
        }
        System.out.println("");
        System.out.println("Altura de la crecida : " + contador);
        System.out.println("Parcelas inundadas : " + inundada);
        System.out.println("");

    }

}
