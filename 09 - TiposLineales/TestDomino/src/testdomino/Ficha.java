/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdomino;

/**
 *
 * @author ja.buenoseva
 */
public class Ficha {

    private int numeroUno;
    private int numeroDos;

    public Ficha(int numeroUno, int numeroDos) {
        this.numeroUno = numeroUno;
        this.numeroDos = numeroDos;
    }

    public int getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroUno(int numeroUno) {
        this.numeroUno = numeroUno;
    }

    public int getNumeroDos() {
        return numeroDos;
    }

    public void setNumeroDos(int numeroDos) {
        this.numeroDos = numeroDos;
    }

    public void rotar() {
        int aux;
        aux = numeroUno;
        numeroUno = numeroDos;
        numeroDos = numeroUno;
    }
    
    public boolean esDoble() {
        return numeroDos == numeroUno;
    }
    
    public int valor() {
        return numeroDos + numeroUno;
    }

    @Override
    public String toString() {
        return "[ " + numeroUno + ", " + numeroDos + ']';
    }

}
