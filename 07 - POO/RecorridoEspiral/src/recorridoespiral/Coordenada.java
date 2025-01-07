/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recorridoespiral;

/**
 *
 * @author jabue
 */
public class Coordenada {
    private int fila;
    private int columna;

    /**
     *
     * @param fila
     * @param columna
     */
    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
}
