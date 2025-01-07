/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recorridoespiral;

/**
 *
 * @author jabue
 */
public class RecorridoEspiral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int matriz[][] = new int[8][8];
        Coordenada posicion;
        int origen = 0, valor;

        matriz = recorridoEnEspiral(8);
        mostrarMatriz(matriz);

        for (int i = 0; i < 20; i++) {
            valor = (int) (Math.random() * 6 + 1);
            System.out.println("Valor: " + valor);
            posicion = obtenerPosicion(matriz, origen, valor);
            System.out.println("\tFila: " + posicion.getFila() + " - Columna: " + posicion.getColumna());
            origen = obtenerValorPosicion(matriz, posicion);
            System.out.println("\t\tNuevo Origen: " + origen);
            if (origen==63) {
                System.out.println("\nHas ganado\nIntento: "+i);
                break;
            }
        }
    }

    // Método que visualiza la matriz
    public static void mostrarMatriz(int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[0].length; columna++) {
                System.out.printf("%3d", matriz[fila][columna]);
            }
            System.out.println("");
        }
    }

    private static int[][] recorridoEnEspiral(int dim) {
        int matriz[][] = new int[8][8];
        int ultimaFila = dim - 1;
        int primeraFila = 0;
        int ultimaColumna = dim - 1;
        int primeraColumna = 0;
        int contador = -1;
        while (primeraFila <= ultimaFila) {
            for (int i = primeraColumna; i <= ultimaColumna; i++) {
                matriz[ultimaFila][i] = ++contador;
            }
            ultimaFila--;
            for (int i = ultimaFila; i >= primeraFila; i--) {
                matriz[i][ultimaColumna] = ++contador;
            }
            ultimaColumna--;
            for (int i = ultimaColumna; i >= primeraColumna; i--) {
                matriz[primeraFila][i] = ++contador;
            }
            primeraFila++;
            for (int i = primeraFila; i <= ultimaFila; i++) {
                matriz[i][primeraColumna] = ++contador;
            }
            primeraColumna++;
            //break;
        }
        return matriz;
    }

    private static Coordenada obtenerPosicion(int[][] matriz, int origen, int valor) {
        Coordenada c = new Coordenada(0, 0);
        int posicion = 0;
        if (origen + valor >= 64) {
            posicion = 63 - ((origen + valor) % 64 + 1);
        } else {
            posicion = origen + valor;
        }
        System.out.println("Exceso: " + posicion);
        //exceso = (exceso == 63) ? exceso : 62 - exceso;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == posicion) {   // (origen + valor) % 64
                    c = new Coordenada(i, j);
                    break;
                }
            }
        }
        return c;
    }

    private static int obtenerValorPosicion(int[][] matriz, Coordenada posicion) {
        return matriz[posicion.getFila()][posicion.getColumna()];
    }

}
