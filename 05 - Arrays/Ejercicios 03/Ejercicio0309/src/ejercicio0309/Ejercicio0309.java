/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio0309;

/**
 *
 * @author jabue
 */
public class Ejercicio0309 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int filas = 2;
        int columnas = 3;
        int dimension = 10;
        filas = (int) (Math.random() * dimension + 1) - 0;
        columnas = (int) (Math.random() * dimension + 1) - 0;
        int[][] matriz = new int[filas][columnas];

        matriz = generarMatriz(filas, columnas);
        mostrarMatriz(matriz);

        // matriz Nula
        // a)
        boolean es = esNula(matriz);
        if (es) {
            System.out.println("Es Nula");
        } else {
            System.out.println("No es Nula");
        }

        /*
        System.out.println("");
        System.out.println("Positiva");
        // Damos nuevos valores a la matriz
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                //matriz[i][j] = (int) (Math.random() * 21) - 10;   //  entre -10 y 10
                matriz[fila][columna] = (int) (Math.random() * 2) - 0;
            }
        }
        // mostrar la matriz
        mostrarMatriz(matriz);
         */
        es = esPositiva(matriz);
        if (es) {
            System.out.println("Si es positiva");
        } else {
            System.out.println("No es positiva");
        }

        es = esNegativa(matriz);
        if (es) {
            System.out.println("Si es negativa");
        } else {
            System.out.println("No es negativa");
        }

        es = esDiagonalPrincipal(matriz);
        if (es) {
            System.out.println("Si es Diagonal Principal");
        } else {
            System.out.println("No es Diagonal Principal");
        }

        es = esTriangularInferior(matriz);
        if (es) {
            System.out.println("Si es Triangular Inferior");
        } else {
            System.out.println("No es Triangular Inferior");
        }

        es = esTriangularSuperior(matriz);
        if (es) {
            System.out.println("Si es Triangular Superior");
        } else {
            System.out.println("No es Triangular Superior");
        }

        es = esDispersa(matriz);
        if (es) {
            System.out.println("Si es Dispersa");
        } else {
            System.out.println("No es Dispersa");
        }

        es = esSimetrica(matriz);
        if (es) {
            System.out.println("Si es Simetrica");
        } else {
            System.out.println("No es Simetrica");
        }

        int[][] aux;
        System.out.println("Matriz Traspuesta:");
        aux = traspuesta(matriz);
        mostrarMatriz(aux);

        System.out.println("Matriz Opuesta:");
        aux = opuesta(matriz);
        mostrarMatriz(aux);

        // Ejercicio 9.11
        if (matriz.length == 1 || matriz[0].length == 1) {
            System.out.println("Submatriz911 nula");
        } else {
            aux = submatriz911(matriz, 1, 1);
            System.out.println("Submatriz911:");
            mostrarMatriz(aux);
        }

        // Ejercicio 9.12
        int[] vector;
        vector = arraySumaFila(matriz);
        System.out.println("Vector suma fila:");
        mostrarArray(vector);

        // Ejercicio 9.13
        //int[] vector;
        vector = arraySumaColumna(matriz);
        System.out.println("Vector suma columna:");
        mostrarArray(vector);

        System.out.println("Matriz por escalar:");
        aux = matrizPorEscalar(matriz,5);
        mostrarMatriz(aux);
    }

// ***************  Métodos  ***************************************************
    public static int[][] generarMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                //matriz[i][j] = (int) (Math.random() * 21) - 10;   //  entre -10 y 10
                matriz[fila][columna] = (int) (Math.random() * 2) - 0;
            }
        }
        return matriz;
    }

    public static void generarMatriz2(int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                //matriz[i][j] = (int) (Math.random() * 21) - 10;   //  entre -10 y 10
                matriz[fila][columna] = (int) (Math.random() * 2) - 0;
            }
        }
    }

    // Método que visualiza la matriz
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("matriz: ");
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                System.out.printf("%3d", matriz[fila][columna]);
            }
            System.out.println("");
        }
    }

// Método que visualiza el array
    public static void mostrarArray(int[] matriz) {
        System.out.println("array: ");
        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.printf("%3d", matriz[fila]);
        }
        System.out.println("");
    }

    // es nula
    public static boolean esNula(int[][] matriz) {
        int f = 0;
        boolean es = true;
        while (es && f < matriz.length) {
            int c = 0;
            while (es && c < matriz[0].length) {
                if (matriz[f][c] != 0) {
                    es = false;
                }
                c++;
            }
            f++;
        }
        return es;
    }

    // Es positiva
    public static boolean esPositiva(int[][] matriz) {
        boolean es = true;
        int f = 0;
        while (es && f < matriz.length) {
            int c = 0;
            while (es && c < matriz[0].length) {
                if (matriz[f][c] < 0) {
                    es = false;
                }
                c++;
            }
            f++;
        }
        return es;
    }

    // Es negativa
    public static boolean esNegativa(int[][] matriz) {
        boolean es = true;
        int f = 0;
        while (es && f < matriz.length) {
            int c = 0;
            while (es && c < matriz[0].length) {
                if (matriz[f][c] >= 0) {
                    es = false;
                }
                c++;
            }
            f++;
        }
        return es;
    }

    // Es Diagonal Principal
    public static boolean esDiagonalPrincipal(int[][] matriz) {
        boolean es = true;
        int f = 0;
        while (es && f < matriz.length) {
            int c = 0;
            while (es && c < matriz[0].length) {
                if (f != c && matriz[f][c] != 0) {
                    es = false;
                }
                c++;
            }
            f++;
        }
        return es;
    }

    // Es Triangular Inferior
    public static boolean esTriangularInferior(int[][] matriz) {
        boolean es = true;
        int f = 0;
        while (es && f < matriz.length) {
            int c = f + 1;
            while (es && c > f && c < matriz[0].length) {   // elementos sobre la diagonal
                if (f != c && matriz[f][c] != 0) {
                    es = false;
                }
                c++;
            }
            f++;
        }
        return es;
    }

    // Es Triangular Superior
    public static boolean esTriangularSuperior(int[][] matriz) {
        boolean es = true;
        int f = 0;
        while (es && f < matriz.length) {
            int c = 0;
            while (es && c < f && c < matriz[0].length) {
                if (f != c && matriz[f][c] != 0) {
                    es = false;
                }
                c++;
            }
            f++;
        }
        return es;
    }

    // Es Dispersa
    public static boolean esDispersa(int[][] matriz) {
        boolean dispersa = true;
        int f = 0;
        // Hay cero en todas las filas?
        while (dispersa && f < matriz.length) {
            int c = 0;
            boolean hayCero = false;
            while (!hayCero && c < matriz[0].length) {
                if (matriz[f][c] == 0) {
                    hayCero = true;
                }
                c++;
            }
            dispersa = dispersa && hayCero;
            f++;
        }
        // Hay cero en todas las filas?
        int c = 0;
        while (dispersa && c < matriz[0].length) {
            f = 0;
            boolean hayCero = false;
            while (!hayCero && f < matriz.length) {
                if (matriz[f][c] == 0) {
                    hayCero = true;
                }
                f++;
            }
            dispersa = dispersa && hayCero;
            c++;
        }
        return dispersa;
    }

    // Es Simétrica
    public static boolean esSimetrica(int[][] matriz) {
        boolean es = true;
        int f = 0;
        while (es && f < matriz.length) {
            int c = 0;
            while (es && f < matriz[0].length && c < matriz[0].length && c < matriz.length) {
                if (matriz[f][c] != matriz[c][f]) {
                    es = false;
                }
                c++;
            }
            f++;
        }
        return es;
    }

    // Traspuesta
    public static int[][] traspuesta(int[][] matriz) {
        int[][] aux = new int[matriz[0].length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                aux[j][i] = matriz[i][j];
            }

        }
        return aux;
    }

    // Opuesta
    public static int[][] opuesta(int[][] matriz) {
        int[][] aux = new int[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                aux[i][j] = matriz[i][j] * -1;
            }

        }
        return aux;
    }

    // 9.11
    // Dada la matriz y y dos índices de fila y columna i y j, construya una nueva matriz representando 
    // la submatriz de la inicial que se obtiene eliminando la fila i y la columna j.
    public static int[][] submatriz911(int[][] matriz, int fila, int columna) {
        int[][] aux = new int[matriz.length - 1][matriz[0].length - 1];
        int f = 0, c = 0;
        mostrarMatriz(matriz);
        for (int i = 0; i < matriz.length; i++) {
            c = 0;
            if (i != fila) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (j != columna) {
                        aux[f][c] = matriz[i][j];
                        c++;
                    }
                }
                f++;
            }
        }
        return aux;
    }

    // 9.12
    // Devolver un array cuyos elementos son la suma de las filas de la matriz inicial.  
    // (Elemento i es la suma de la fila i)
    public static int[] arraySumaFila(int[][] matriz) {
        int[] aux = new int[matriz.length];
        int f = 0, c = 0;
        //mostrarMatriz(matriz);
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                suma += matriz[i][j];
            }
            aux[i] = suma;
        }
        return aux;
    }

    // 9.13
    // Devolver un array cuyos elementos son la suma de las columnas de la matriz inicial.  
    // (Elemento i es la suma de la columna i)
    public static int[] arraySumaColumna(int[][] matriz) {
        int[] aux = new int[matriz[0].length];
        int f = 0, c = 0;
        //mostrarMatriz(matriz);
        int suma = 0;
        for (int columna = 0; columna < matriz[0].length; columna++) {
            suma = 0;
            for (int fila = 0; fila < matriz.length; fila++) {
                suma += matriz[fila][columna];
            }
            aux[columna] = suma;
        }
        return aux;
    }

    // 9.14
    // Devolver el producto de una matriz por un escalar
    // 
    public static int[][] matrizPorEscalar(int[][] matriz, int r) {
        int[][] aux = new int[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                aux[i][j] = matriz[i][j] * r;
            }
        }
        return aux;
    }

}
