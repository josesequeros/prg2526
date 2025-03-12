/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploficheroobjetos;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jabue
 */
public class EjemploFicheroObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Persona persona;
        
        try {
            fileOutputStream = new FileOutputStream("./recursos/personas.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            persona = new Persona("11223344", "Pepe", "Gotera", 20);
            System.out.println(persona);
            objectOutputStream.writeObject(persona);
           
            persona = new Persona("12345678", "Angel", "Gómez", 30);
            System.out.println(persona);
            objectOutputStream.writeObject(persona);
            persona = new Persona("10102020", "María", "Martínez", 40);
            System.out.println(persona);
            objectOutputStream.writeObject(persona);
        } catch (FileNotFoundException e) {
            System.out.println("1" + e.getMessage());
        } catch (IOException e) {
            System.out.println("2 - " + e.getMessage());
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println("3" + e.getMessage());
            }
        }
    
    // leer el fichero
    try {
            // Abrir un flujo de entrada para leer desde el archivo
            FileInputStream fileIn = new FileInputStream("./recursos/personas.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // Leer y mostrar cada objeto Persona desde el archivo
            System.out.println("Personas recuperadas del archivo:");
            while (true) {
                try {
                    persona = (Persona) objectIn.readObject();
                    System.out.println("Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad());
                    System.out.println(persona);
                    System.out.println("");
                } catch (EOFException e) {
                    break; // Se alcanzó el final del archivo
                }
            }

            // Cerrar el flujo de entrada
            objectIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocurrió un error al leer las personas: " + e.getMessage());
        }
    
    }
    
    
    
}
