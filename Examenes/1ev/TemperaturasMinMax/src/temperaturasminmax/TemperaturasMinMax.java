/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package temperaturasminmax;

/**
 *
 * @author jabue
 */
public class TemperaturasMinMax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int temperaturas[][][] = new int[12][31][2];
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        int year = 2024;
        int diasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean bisiesto = false;
        final int MAXIMA = 0;
        final int MINIMA = 1;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            diasMes[1] = 29;
            bisiesto = true;
        }
        System.out.println("Year: " + year);
        for (int mes = 0; mes < 12; mes++) {
            for (int dia = 0; dia < diasMes[mes]; dia++) {
                int temp1 = (int) (Math.random() * 60 - 10);
                int temp2 = (int) (Math.random() * 60 - 10);
                if (temp1 > temp2) {
                    temperaturas[mes][dia][MAXIMA] = temp1;
                    temperaturas[mes][dia][MINIMA] = temp2;
                } else {
                    temperaturas[mes][dia][MAXIMA] = temp2;
                    temperaturas[mes][dia][MINIMA] = temp1;
                }
            }
        }

        //System.out.println(bisiesto);
        System.out.printf("%-12s", "Mes: ");
        for (int dia = 0; dia < 31; dia++) {
            System.out.printf("%5s%5s%5s", "Dia", "Max", "Min");
        }
        System.out.println("");
        for (int mes = 0; mes < 12; mes++) {
            System.out.printf("%-12s", meses[mes]);
            for (int dia = 0; dia < diasMes[mes]; dia++) {
                System.out.printf("%5d%5d%5d", dia + 1, temperaturas[mes][dia][MAXIMA], temperaturas[mes][dia][MINIMA]);
            }
            System.out.println("");
        }

        // dia de mayor diferencia del mes
        int mayorDiferenciaMes = 0;
        int diamayorDiferenciaMes = 0;
        int mayorDiferenciaAño = 0;
        int diamayorDiferenciaAño = 0;
        int mesMayorDiferencia = 0;
        int diferencia = 0;
        int totalMeses = 0;
        int totalDias = 0;
        System.out.println("");
        System.out.println("Mayor diferencia de: ");
        System.out.printf("%-14s%-4s%-4s", "", "Dif", "dia");
        System.out.println("");
        for (int mes = 0; mes < 12; mes++) {
            mayorDiferenciaMes = 0;
            for (int dia = 0; dia < diasMes[mes]; dia++) {
                diferencia = temperaturas[mes][dia][MAXIMA] - temperaturas[mes][dia][MINIMA];
                if (diferencia > mayorDiferenciaMes) {
                    mayorDiferenciaMes = diferencia;
                    diamayorDiferenciaMes = dia;
                    totalDias = 1;
                } else if (diferencia == mayorDiferenciaMes) {
                    totalDias++;
                }
            }

            System.out.printf("%-12s %4d%4d", meses[mes], mayorDiferenciaMes, diamayorDiferenciaMes + 1);
            System.out.println("\tDias alcanzada: " + totalDias);

            if (mayorDiferenciaMes > mayorDiferenciaAño) {
                mayorDiferenciaAño = mayorDiferenciaMes;
                diamayorDiferenciaAño = diamayorDiferenciaMes;
                mesMayorDiferencia = mes;
                totalMeses = 1;
            } else if (mayorDiferenciaMes == mayorDiferenciaAño) {
                totalMeses++;
            }
        }
        System.out.println("");
        System.out.println("Mayor diferencia anual:");

        System.out.printf("%-12s %4d%4d", meses[mesMayorDiferencia], mayorDiferenciaAño, diamayorDiferenciaAño + 1);
        System.out.println("");
        System.out.println("Meses alcanzada: " + totalMeses);

    }
}
