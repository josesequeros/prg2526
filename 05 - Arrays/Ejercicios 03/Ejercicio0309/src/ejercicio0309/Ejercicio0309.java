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
        aux = traspuesta(matriz);
        System.out.println("Matriz Traspuesta:");
        mostrarMatriz(aux);

        aux = opuesta(matriz);
        System.out.println("Matriz Opuesta:");
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
}
