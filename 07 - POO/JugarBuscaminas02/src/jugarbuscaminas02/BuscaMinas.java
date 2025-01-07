/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jugarbuscaminas02;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class BuscaMinas {

    private int dimension;
    private int numeroMinas;
    private Casilla campoMinas[][];

    /**
     * Constructor
     *
     */
    public BuscaMinas(int dimension, int numeroMinas) {
        this.dimension = dimension;
        this.numeroMinas = numeroMinas;
        this.campoMinas = new Casilla[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                campoMinas[i][j] = new Casilla();
            }
        }

        //mostrarCampo(true);
        colocarMinas();
        //mostrarCampo(true);
        alrededorCelda();

    }

    public int getNumeroMinas() {
        return numeroMinas;
    }

    public void setNumeroMinas(int numeroMinas) {
        this.numeroMinas = numeroMinas;
    }

    /**
     * Get the value of dimension
     *
     * @return the value of dimension
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * Set the value of dimension
     *
     * @param dimension new value of dimension
     */
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    private void colocarMinas() {
        //int posiciones[] = new int[this.dimension * this.dimension];
        int minasColocadas = 0;
        int posicion, fila, columna;

        while (minasColocadas < this.getNumeroMinas()) {
            posicion = (int) Math.floor(Math.random() * this.getDimension() * this.getDimension());
            fila = posicion / this.getDimension();
            columna = posicion % this.getDimension();
            
            if (!this.campoMinas[fila][columna].isMina()) {
                campoMinas[fila][columna].setMina(true);
                minasColocadas++;
                //System.out.println("Posición: ("+fila+","+columna+")");
            }
        }
    }

    private void mostrarMinas(boolean fin) {
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                if (campoMinas[i][j].isMina()) {
                    if (fin) {
                        campoMinas[i][j].setRender('*');
                    }
                    else {
                        //campoMinas[i][j].setRender('.');
                    }
                }
            }
        }
    }

    private void mostrarCampo(boolean fin) {
        if (fin) {
            mostrarMinas(fin);
        }
        System.out.printf("%3s", "T");
        for (int j = 1; j <= this.getDimension(); j++) {
            System.out.printf("%3d", j);
        }
        System.out.println("");
        for (int i = 0; i < this.getDimension(); i++) {
            System.out.printf("%3d", i + 1);
            for (int j = 0; j < this.getDimension(); j++) {
                System.out.printf("%3s", campoMinas[i][j].getRender());
            }
            System.out.println("");
        }
    }

    public void mostrarCampo2(boolean fin) {
        String simbolo = new String();

        System.out.printf("%3s", "T");
        for (int j = 1; j <= this.getDimension(); j++) {
            System.out.printf("%3d", j);
        }
        System.out.println("");
        for (int i = 0; i < this.getDimension(); i++) {
            System.out.printf("%3d", i + 1);
            for (int j = 0; j < this.getDimension(); j++) {
                if (this.campoMinas[i][j].isMina()) {
                    if (fin) {
                        simbolo = "*";
                    } else {
                        simbolo = "*";
                    }
                } else {
                    if (!this.campoMinas[i][j].isDescubierta()) {
                        simbolo = "-";
                    } else {
                        if (this.campoMinas[i][j].isMarcada()) {
                            simbolo = "+";
                        } else {
                            simbolo = "" + this.campoMinas[i][j].getMinasAdyacente();
                        }
                    }
                }
                System.out.printf("%3s", simbolo);
            }
            System.out.println("");
        }
    }

    private void alrededorCelda() {
        for (int fila = 0; fila < dimension; fila++) {
            for (int columna = 0; columna < dimension; columna++) {
                if (!campoMinas[fila][columna].isMina()) {
                    for (int f = fila - 1; f <= fila + 1; f++) {
                        for (int c = columna - 1; c <= columna + 1; c++) {
                            if (f >= 0 && f < dimension && c >= 0 && c < dimension) {
                                if (!(f == fila && c == columna) && campoMinas[f][c].isMina()) {
                                    campoMinas[fila][columna].setMinasAdyacente(campoMinas[fila][columna].getMinasAdyacente() + 1);
                                    //campoMinas[fila][columna].setDescubierta(true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void destaparCelda(int fila, int columna) {
        //this.alrededorCelda(fila, columna); // calcula y actualiza número de minas que toca
        this.campoMinas[fila][columna].setDescubierta(true);
        if (this.campoMinas[fila][columna].getMinasAdyacente() == 0) { // si es 0 destapa todas las que le rodean
            for (int f = fila - 1; f <= fila + 1; f++) {
                for (int c = columna - 1; c <= columna + 1; c++) {
                    if (f >= 0 && f < this.getDimension() && c >= 0 && c < this.getDimension()) {
                        if (!this.campoMinas[f][c].isDescubierta()) { // solo destapa las que estan cubiertas
                            this.destaparCelda(f, c);
                            campoMinas[f][c].setDescubierta(true);
                        }
                    }
                }
            }
        }
    }

    public void jugar() {
        int fila, columna;
        Scanner in = new Scanner(System.in);
        boolean jugar = true;
        int movimientos = 1;

        while (jugar) {
            boolean suponer = false;
            this.mostrarCampo(false);
            System.out.println(contarTapadas());
            System.out.println("");
            System.out.print("Movimiento: " + movimientos++);
            System.out.println("");
            System.out.print("Introduce Fila: ");
            fila = in.nextInt();
            System.out.print("Introduce Columna: ");
            columna = in.nextInt();

            if (fila < 0 || columna < 0) {
                fila = Math.abs(fila);
                columna = Math.abs(columna);
                suponer = true;
            }
            fila--;
            columna--;
            if (suponer && (!this.campoMinas[fila][columna].isDescubierta()
                    || this.campoMinas[fila][columna].isMina())) {
                this.campoMinas[fila][columna].setMarcada(true);
            } else {
                if (this.campoMinas[fila][columna].isMina()) {
                    System.out.println("Pierdes");
                    jugar = false;
                    mostrarCampo(true);
                } else {
                    if (!this.campoMinas[fila][columna].isDescubierta()
                            || this.campoMinas[fila][columna].isMarcada()) {
                        this.campoMinas[fila][columna].setDescubierta(true);
                        this.destaparCelda(fila, columna);
                    }
                }
            }

            int tapadas = contarTapadas();
            if (tapadas == numeroMinas) {
                ganas(movimientos);
                mostrarCampo(true);
                jugar = false;
            }
        }
    }

    private void ganas(int movimientos) {
        System.out.println("");
        System.out.println(" Has Ganado");
        System.out.println(" Con un total de: " + movimientos + " movimientos");
    }

    private int contarTapadas() {
        int tapadas = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (!campoMinas[i][j].isDescubierta() || campoMinas[i][j].isMina()) {
                    tapadas++;
                }
            }
        }
        System.out.println("tapadas " + tapadas);
        return tapadas;
    }
}
