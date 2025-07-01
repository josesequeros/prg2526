package com.mycompany.buscaminas;

//Aquí definí el nivel personalizado como clase porque ya me parecía que tenía demasiados metodos en el primaryController y 
//no quería que se hiciera muy grande, aunque ha pasado igual xd.
//No tiene mucho misterio, simplemente es una clase que guarda el número de filas, columnas y minas del nivel personalizado.

public class customlvl {
    private int rows;
    private int cols;
    private int mines;

    public customlvl(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows < 1) {
            System.out.println("El número de filas debe ser al menos 1.");
            this.rows = 1;
        } else {
            this.rows = rows;
        }
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        if (rows < 1) {
            System.out.println("El número de columnas debe ser al menos 1.");
            this.cols = 1;
        } else {
            this.cols = cols;
        }
    }

    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }
}
