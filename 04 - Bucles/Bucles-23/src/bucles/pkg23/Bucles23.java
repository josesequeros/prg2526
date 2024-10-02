/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bucles.pkg23;

/**
 *
 * @author jabue
 */
public class Bucles23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int altura = 5;
        int base = 7;
        int veces = 3;
        int vecesFilas = 4;
        
        for (int vezFila = 1; vezFila <= vecesFilas; vezFila++) {
            for (int fila = 1; fila <= altura; fila++) {
                if (vezFila < vecesFilas && fila < altura || vezFila == vecesFilas) {
                    for (int vez = 1; vez <= veces; vez++) {
                        for (int columna = 1; columna <= base; columna++) {
                            if (vez < veces && columna < base || vez == veces) {
                                if (fila == 1 || fila == altura || columna == 1 || columna == base) {
                                    System.out.print("* ");
                                } else {
                                    System.out.print("  ");
                                }
                            }
                        }
                    }
                    System.out.println("");
                }
                
            }
        }
    }

}
