/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author jabue
 */
public class TestPersonal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        leerPersonas("personal.txt");
    }

    public static void leerPersonas(String nomFich) {
        //ArrayList<Persona> personal = new ArrayList<>();
        Personal personal = new Personal();
        int male = 0;
        int female = 0;
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
            //Scanner lector = new Scanner(f);

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
                    String pais = partes[5];
                    //Persona persona = new Persona(nombre, apellido, email, genero, nacimiento, pais);
                    if (genero.equalsIgnoreCase("male")) {
                        male++;
                        fwMale.write(linea + "\n");
                    } else {
                        female++;
                        fwFemale.write(linea + "\n");
                    }
                    //personal.addPersona(persona);
                }
                fwMale.flush();
                fwMale.close();
                fwFemale.flush();
                fwFemale.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Error leyendo datos");
                //personal = null;
            }
            // f.close
            //return personal;

            System.out.println("Male: " + male);
            System.out.println("Female: " + female);

            //pw.flush();
            //pw.close();
        } catch (IOException e) {
            // En caso de excepción mostramos el error
            System.out.println("Error: " + e);
            e.printStackTrace();
        }

    }
}
