/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imprimircalendario;

import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class ImprimirCalendario {
    static final int INICIO_1_ENE_1583 = 5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter year
        System.out.print("Introducir el año (mayor de 1581) (e.g., 2001): ");
        int year = input.nextInt();

        // Prompt the user to enter month
        System.out.print("Enter month in number between 1 and 12: ");
        int month = input.nextInt();

        // Print calendar for the month of the year
        imprimirMes(year, month);
    }

    /**
     * Print the calendar for a month in a year
     */
    public static void imprimirMes(int year, int month) {
        // Print the headings of the calendar
        imprimirMesCabecera(year, month);

        // Print the body of the calendar
        imprimirMesCuerpo(year, month);
    }

    /**
     * Print the month title, e.g., May, 1999
     */
    public static void imprimirMesCabecera(int year, int month) {
        System.out.println("         " + getNombreMes(month)
                + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Lun Mar Mie Jue Vie Sab Dom");
    }

    /**
     * Obtener nombre del mes
     */
    public static String getNombreMes(int mes) {
        String nombreMes[] = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return nombreMes[mes];
    }

    /**
     * Imprimir el cuerpo del mes
     */
    public static void imprimirMesCuerpo(int year, int month) {
        // Get start day of the week for the first date in the month
        int startDay = getDiaInicio(year, month);

        // Get number of days in the month
        int numberOfDaysInMonth = getNumeroDiasMes(year, month);

        // Pad space before the first day of the month
        int i = 0;
        for (i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    /**
     * Get the start day of month/1/year
     */
    public static int getDiaInicio(int year, int month) {
        //final int START_DAY_FOR_JAN_1_1800 = 2;
        
        // Get total number of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = getTotalNumeroDias(year, month);

        // Return the start day for month/1/year
        return (totalNumberOfDays + INICIO_1_ENE_1583) % 7;
    }

    /**
     * Get the total number of days since January 1, 1800
     */
    public static int getTotalNumeroDias(int year, int month) {
        int total = 0;

        // Get the total days from 1800 to 1/1/year
        for (int i = 1583; i < year; i++) {
            if (esBisiesto(i)) {
                total = total + 366;
            } else {
                total = total + 365;
            }
        }

        // Add days from Jan to the month prior to the calendar month
        for (int i = 1; i < month; i++) {
            total = total + getNumeroDiasMes(year, i);
        }

        return total;
    }

    /**
     * Get the number of days in a month
     */
    public static int getNumeroDiasMes(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            return 31;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        if (month == 2) {
            return esBisiesto(year) ? 29 : 28;
        }

        return 0; // If month is incorrect
    }

    /**
     * Determine if it is a leap year
     */
    public static boolean esBisiesto(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
