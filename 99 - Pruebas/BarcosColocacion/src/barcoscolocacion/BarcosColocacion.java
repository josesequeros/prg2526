/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barcoscolocacion;

/**
 *
 * @author jabue
 */
public class BarcosColocacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int dimension = 10;
        int tablero[][] = new int[dimension][dimension];
        int numeroBarcos = 10;
        int barcos[] = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        int fila, columna;
        fila = (int) (Math.random() * dimension);
        columna = (int) (Math.random() * dimension);

        mostrarTablero(tablero);
    }

    private static void mostrarTablero(int[][] tablero) {
        System.out.printf("%s", "   ");
        for (int i = 0; i < tablero.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println("");
        for (int i = 0; i < (tablero.length + 1) * 3; i++) {
            System.out.print("-");
        }
        System.out.println("");
        for (int i = 0; i < tablero.length; i++) {
            System.out.printf("%c %c", 'A' + i, '|');
            for (int j = 0; j < tablero[0].length; j++) {
                char c = '\0';
                switch (tablero[i][j]) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        c = '.';
                        break;
                    case -1:
                        c = 'x';
                        break;
                    case 10:
                        c = 't';
                        break;
                    case 11:
                        c = 'h';
                        break;
                    default:
                    //
                }
                System.out.printf("%3c", c);
                //System.out.printf("%3d", tablero[i][j]);
            }
            System.out.println("");
        }
    }

}
