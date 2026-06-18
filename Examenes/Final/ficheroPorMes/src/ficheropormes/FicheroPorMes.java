/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficheropormes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author ja.buenoseva
 */
public class FicheroPorMes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        leerPersonas("personal.csv");
    }

    public static void leerPersonas(String nomFich) {
        //ArrayList<Persona> personal = new ArrayList<>();

        int male = 0;
        int female = 0;
        int enero = 0;
        int diciembre = 0;
        File fileMale;
        File fileFemale;
        FileWriter fwMale;
        FileWriter fwFemale;
        try {
            // Intentamos abrir el fichero
            fileMale = new File("male.txt");
            fileFemale = new File("female.txt");
            fwMale = new FileWriter(fileMale);
            fwFemale = new FileWriter(fileFemale);

            FileWriter fw01 = new FileWriter("enero");
            FileWriter fw12 = new FileWriter("diciembre");

            // Declarando el Scanner en el try tenemos el cierre automático del mismo
            try (Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US)) {
                //Scanner f = new Scanner(new File(nomFich)).useLocale(Locale.US);
                while (f.hasNext()) {
                    String linea = f.nextLine();
                    String[] partes = linea.split(",");
                    String nombre = partes[0];
                    String apellido = partes[1];
                    String email = partes[2];
                    String genero = partes[3];
                    String nacimiento = partes[4];
                    DateTimeFormatter formatoFechaNacimiento = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate fechaNacimiento = LocalDate.parse(nacimiento, formatoFechaNacimiento);
                    String pais = partes[5];
                    //Persona persona = new Persona(nombre, apellido, email, genero, nacimiento, pais);
                    int mes = fechaNacimiento.getMonthValue();
                    if (mes == 1 || mes == 12) {
                        if (genero.equalsIgnoreCase("male")) {
                            male++;
                            fwMale.write(linea + "\n");
                        } else {
                            female++;
                            fwFemale.write(linea + "\n");
                        }
                    }
                    if (mes == 1) {
                        enero++;
                        fw01.write(linea + "\n");
                    }
                    if (mes == 12) {
                        diciembre++;
                        fw12.write(linea + "\n");
                    }
                    //personal.addPersona(persona);
                }
                fwMale.flush();
                fwMale.close();
                fwFemale.flush();
                fwFemale.close();
                fw01.flush();
                fw01.close();
                fw12.flush();
                fw12.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Error leyendo datos");
            }

            System.out.println("En enero y diciembre: ");
            System.out.println("\tMale: " + male);
            System.out.println("\tFemale: " + female);

            if (enero > diciembre) {
                System.out.println("Enero tiene " + (enero - diciembre) + " mas personas que diciembre");
            } else {
                System.out.println("diciembre tiene " + (diciembre - enero) + " mas personas que enero");
            }

        } catch (IOException e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }

    }
}
