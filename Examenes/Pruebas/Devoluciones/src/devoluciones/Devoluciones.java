/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package devoluciones;

/**
 *
 * @author jabue
 */
public class Devoluciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double importe = 123.42;
        double entrega = 500.0;
        double vueltas = entrega - importe;

        int billetes[] = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int monedas[] = {50, 20, 10, 5, 2, 1};

        int ctdBilletes = (int) vueltas;
        int ctdMonedas = (int) (vueltas * 100) % 100;
        System.out.println(vueltas);
        System.out.println(ctdBilletes);
        System.out.println(ctdMonedas);

        int i = 0;
        while (ctdBilletes > 0) {
            int x = ctdBilletes / billetes[i];
            if (x > 0) {
                System.out.println(x + " de " + billetes[i]);
            }
            ctdBilletes = ctdBilletes % billetes[i];
            i++;
            //System.out.println(ctdBilletes);
        }
        i = 0;
        while (ctdMonedas > 0) {
            int x = ctdMonedas / monedas[i];
            if (x > 0) {
                System.out.println(x + " de " + monedas[i]/100.0);
            }
            ctdMonedas = ctdMonedas % monedas[i];
            i++;
            //System.out.println(ctdBilletes);
        }
    }

}
