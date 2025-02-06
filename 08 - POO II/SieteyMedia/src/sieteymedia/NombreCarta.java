/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sieteymedia;

/**
 *
 * @author jabue
 */
public enum NombreCarta {
    AS(1),
    DOS(2),
    TRES(3),
    CUATRO(4),
    CINCO(5),
    SEIS(6),
    SIETE(7),
    SOTA(0.5),
    CABALLO(0.5),
    REY(0.5);

    private final double valor;

    NombreCarta(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
