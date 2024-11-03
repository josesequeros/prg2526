/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg05.filtrarlista02;

/**
 *
 * @author IEUser
 */
public class FiltrarLista02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] vectorS, vectorT, vectorUnion, vectorInterseccion, vectorDiferencia;
        int elementos = 10;
        vectorS = new int[elementos];
        vectorT = new int[elementos];
        vectorUnion = new int[elementos*2];
        vectorInterseccion = new int[elementos];
        vectorDiferencia = new int[elementos];
        int posicion; 
        int posicionDiferencia;
        int j,k;
        boolean repetido,insertado;

        for (int i = 0; i < elementos; i++) { 
            //vectorNumeros[i] = (int) (1 + Math.random() * 10);
            vectorS[i] = (int) (1 + Math.random() * 10);
            vectorT[i] = (int) (1 + Math.random() * 10);
        }
        System.out.println("Array S");
        for (int i = 0; i < vectorS.length; i++) {
            System.out.print(vectorS[i] + " ");
        }
        System.out.println();
        System.out.println("Array T");
        for (int i = 0; i < vectorT.length; i++) {
            System.out.print(vectorT[i] + " ");
        }
        System.out.println();
        // Unión
        //System.arraycopy(vectorS, 0, vectorUnion, 0, elementos); 
        for (int i = 0; i < elementos; i++) {
            vectorUnion[i] = vectorS[i];
        }
        for (int i = 0; i < elementos; i++) {
            vectorUnion[i+elementos] = vectorT[i];
        }
        //System.arraycopy(vectorT, 0, vectorUnion, 10, elementos); //vectorNumeros[i] = (int) (1 + Math.random() * 10);
        // Vector Unión
        System.out.println("Array Unión:");
        for (int i = 0; i < vectorUnion.length; i++) {
            System.out.print(vectorUnion[i] + " ");
        }
        System.out.println();
        // Intersección
        posicion = 0;
        posicionDiferencia = 0;
        for (int i = 0; i < vectorS.length; i++) {
            repetido = false;
            j=0;
            while (!repetido && j<vectorT.length) {
                if (vectorS[i] == vectorT[j]) {
                    repetido = true;
                }
                j++;
            }
            if (repetido) {
                k=0;
                insertado = false;
                while (!insertado && k<vectorInterseccion.length) {
                    if (vectorS[i] == vectorInterseccion[k]) {
                        insertado = true;
                    }
                    k++;
                }
                if (!insertado) {
                    vectorInterseccion[posicion] = vectorS[i];
                    posicion++;
                }
            }
            else {
                k=0;
                insertado = false;
                while (!insertado && k<vectorDiferencia.length) {
                    if (vectorS[i] == vectorDiferencia[k]) {
                        insertado = true;
                    }
                    k++;
                }
                if (!insertado) {
                    vectorDiferencia[posicionDiferencia] = vectorS[i];
                    posicionDiferencia++;
                }
            }
        }
        System.out.println("Array Intersección:");
        for (int i = 0; i < vectorInterseccion.length; i++) {
            if (vectorInterseccion[i] == 0) {
                break;
            }
            System.out.print(vectorInterseccion[i] + " ");
        }
        System.out.println();
        System.out.println("Array Diferencia:");
        for (int i = 0; i < vectorDiferencia.length; i++) {
            if (vectorDiferencia[i] == 0) {
                break;
            }
            System.out.print(vectorDiferencia[i] + " ");
        }
        System.out.println();
    }
    
}
