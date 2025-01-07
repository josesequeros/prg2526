/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminas01;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author IEUser
 */
public class BuscaMinas {

    private int dimension;
    private int campo[][];
    private int campoVisible[][];
    private int numeroMinas;

    public static final int MINA = -1;
    public static final int DESCUBIERTA = 0;
    public static final int CUBIERTA = -2;
    public static final int POSIBLE = -3;

    /**
     * Constructor
     *
     */
    public BuscaMinas(int dimension) {
        this.dimension = dimension;
        this.campo = new int[dimension][dimension];
        this.campoVisible = new int[dimension][dimension];
        for (int[] row : this.campo) {
            Arrays.fill(row, -2);
        }
        for (int[] row : this.campoVisible) {
            Arrays.fill(row, CUBIERTA);
        }
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

    public void colocarMinas() {
        //int posiciones[] = new int[this.dimension * this.dimension];
        int minasColocadas = 0;
        int posicion, fila, columna;

        while (minasColocadas < this.getNumeroMinas()) {
            posicion = (int) Math.floor(Math.random() * this.getDimension() * this.getDimension());
            fila = posicion / this.getDimension();
            columna = posicion % this.getDimension();
            if (this.campo[fila][columna] != MINA) {
                this.campo[fila][columna] = MINA;
                minasColocadas++;
            }
        }
    }

    public void mostrarCampo(boolean fin) {
        String simbolo = new String();
        System.out.println("");
        System.out.printf("%3s", "T");
        for (int j = 1; j <= this.getDimension(); j++) {
            System.out.printf("%3d", j);
        }
        System.out.println("");
        for (int i = 0; i < this.getDimension(); i++) {
            System.out.printf("%3d", i + 1);
            for (int j = 0; j < this.getDimension(); j++) {
                if (this.campo[i][j] == MINA) {
                    if (fin) {
                        simbolo = "*";
                    } else {
                        simbolo = "*";
                    }
                } else {
                    if (this.campo[i][j] == CUBIERTA) {
                        simbolo = "-";
                    } else {
                        if (this.campo[i][j] == POSIBLE) {
                            simbolo = "+";
                        } else {
                            simbolo = "" + this.campo[i][j];
                        }
                    }
                }
                System.out.printf("%3s", simbolo);
            }
            System.out.println("");
        }
    }

    public void mostrarCampoVisible(boolean fin) {
        String simbolo = new String();

        System.out.println("");
        System.out.printf("%3s", " ");
        for (int j = 1; j <= this.getDimension(); j++) {
            System.out.printf("%3d", j);
        }
        System.out.println("");
        for (int i = 0; i < this.getDimension(); i++) {
            System.out.printf("%3d", i + 1);
            for (int j = 0; j < this.getDimension(); j++) {
                if (this.campo[i][j] == MINA) {
                    if (fin) {
                        simbolo = "*";
                    } else {
                        simbolo = "-";
                        simbolo = this.campoVisible[i][j] == POSIBLE ? "+" : "-";
                    }
                } else {
                    if (this.campoVisible[i][j] == CUBIERTA) {
                        simbolo = "-";
                    } else {
                        if (this.campoVisible[i][j] == POSIBLE) {
                            simbolo = "+";
                        } else {
                            simbolo = "" + this.campoVisible[i][j];
                        }
                    }
                }
                System.out.printf("%3s", simbolo);
            }
            System.out.println("");
        }
    }

    public void alrededorCelda(int fila, int columna) {
        if (this.campoVisible[fila][columna] == CUBIERTA) {
            this.campoVisible[fila][columna] = 0;
            for (int f = fila - 1; f <= fila + 1; f++) {
                for (int c = columna - 1; c <= columna + 1; c++) {
                    if (f >= 0 && f < this.getDimension() && c >= 0 && c < this.getDimension()) {
                        if (this.campo[f][c] == MINA) {
                            this.campoVisible[fila][columna]++;
                        }
                    }
                }
            }
        }
    }

    public void destaparCelda(int fila, int columna) {
        this.alrededorCelda(fila, columna); // calcula y actualiza número de minas que toca
        if (this.campoVisible[fila][columna] == 0) { // si es 0 destapa todas las que le rodean
            for (int f = fila - 1; f <= fila + 1; f++) {
                for (int c = columna - 1; c <= columna + 1; c++) {
                    if (f >= 0 && f < this.getDimension() && c >= 0 && c < this.getDimension()) {
                        if (this.campoVisible[f][c] == CUBIERTA) { // solo destapa las que estan cubiertas
                            this.destaparCelda(f, c);
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
        int movimientos = 0;

        while (jugar) {
            boolean suponer = false;
            mostrarCampo(false);
            mostrarCampoVisible(false);
            System.out.println("");
            System.out.print("Movimiento: " + ++movimientos);
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
            if (suponer && (this.campoVisible[fila][columna] == CUBIERTA || this.campo[fila][columna] == MINA)) {
                this.campoVisible[fila][columna] = POSIBLE;
            } else {
                if (this.campo[fila][columna] == MINA) {
                    System.out.println("Pierdes");
                    jugar = false;
                    mostrarCampoVisible(true);
                } else {
                    if (this.campoVisible[fila][columna] == CUBIERTA || this.campoVisible[fila][columna] == POSIBLE) {
                        this.campoVisible[fila][columna] = CUBIERTA;
                        this.destaparCelda(fila, columna);
                    }
                }
            }

            int tapadas = contarTapadas();
            if (tapadas == numeroMinas) {
                ganas(movimientos);
                mostrarCampoVisible(false);
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
                if (campoVisible[i][j] == CUBIERTA || campo[i][j] == MINA) {
                    tapadas++;
                }

            }
        }
        return tapadas;
    }
}
