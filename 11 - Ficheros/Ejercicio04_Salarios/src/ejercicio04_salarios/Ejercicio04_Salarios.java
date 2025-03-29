/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio04_salarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class Ejercicio04_Salarios {

    private static String[] categorias = {"asistente", "asociado", "titular"};
    private static final int CATEGORIA = 2, SALARIO = 3;
    private static final int ASISTENTE = 0, ASOCIADO = 1, TITULAR = 2, TODOS = 3;
    private static final int TOTALES = 0, MEDIAS = 1;

    public static void main(String[] args) {
        File fichero = new File("salario.txt");
        ArrayList<String[]> data = parseDataFromFile(fichero);
        double[][] salaryInfo = procesarData(data);
        visualizarInformacionSalario(salaryInfo);
    }

    private static void visualizarInformacionSalario(double[][] salaryInfo) {
        System.out.println("Salario Totales:");
        System.out.printf("   Asistente: %,15.2f%n", salaryInfo[TOTALES][ASISTENTE]);
        System.out.printf("   Asociado:  %,15.2f%n", salaryInfo[TOTALES][ASOCIADO]);
        System.out.printf("   Titular:   %,15.2f%n", salaryInfo[TOTALES][TITULAR]);
        System.out.printf("   Todos:     %,15.2f%n", salaryInfo[TOTALES][TODOS]);
        System.out.println("Salario Medias:");
        System.out.printf("   Asistente: %,15.2f%n", salaryInfo[MEDIAS][ASISTENTE]);
        System.out.printf("   Asociado:  %,15.2f%n", salaryInfo[MEDIAS][ASOCIADO]);
        System.out.printf("   Titular:   %,15.2f%n", salaryInfo[MEDIAS][TITULAR]);
        System.out.printf("   Todos:     %,15.2f%n", salaryInfo[MEDIAS][TODOS]);
    }

    private static double[][] procesarData(ArrayList<String[]> data) {
        double[][] info = new double[2][4];
        int[] contadores = new int[4];
        double[] sumas = new double[4];
        for (String[] dataLine : data) {
            if (dataLine[CATEGORIA].equals(categorias[ASISTENTE])) {
                contadores[ASISTENTE]++;
                sumas[ASISTENTE] += Double.valueOf(dataLine[SALARIO]);
            } else if (dataLine[CATEGORIA].equals(categorias[ASOCIADO])) {
                contadores[ASOCIADO]++;
                sumas[ASOCIADO] += Double.valueOf(dataLine[SALARIO]);
            } else if (dataLine[CATEGORIA].equals(categorias[TITULAR])) {
                contadores[TITULAR]++;
                sumas[TITULAR] += Double.valueOf(dataLine[SALARIO]);
            } else {
                System.out.println(dataLine[CATEGORIA]);
            }
        }
        contadores[TODOS] = contadores[ASISTENTE] + contadores[ASOCIADO] + contadores[TITULAR];
        sumas[TODOS] = sumas[ASISTENTE] + sumas[ASOCIADO] + sumas[TITULAR];
        System.arraycopy(sumas, 0, info[TOTALES], 0, sumas.length);
        for (int categoria = ASISTENTE; categoria <= TODOS; categoria++) {
            info[MEDIAS][categoria] = sumas[categoria] / contadores[categoria];
        }
        return info;
    }

    private static ArrayList<String[]> parseDataFromFile(File fichero) {
        ArrayList<String[]> data = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fichero);
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNext()) {
                data.add(scanner.nextLine().split(" "));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } 

        return data;
    }

}
/*
Salary Totals:
   Assistant: $20,246,511.91
   Associate: $28,844,146.58
   Full:      $35,678,051.41
   All:       $84,768,709.90
Salary Averages:
   Assistant: $65,949.55
   Associate: $83,849.26
   Full:      $102,229.37
   All:       $84,768.71
 */
