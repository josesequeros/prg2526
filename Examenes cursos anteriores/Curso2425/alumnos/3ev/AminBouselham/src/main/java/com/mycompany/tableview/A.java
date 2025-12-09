package com.mycompany.tableview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class A {

    private static ArrayList<Autor> misDatos = new ArrayList<>();
    private static File saveFile = new File("src/main/resources/info.txt");

    public A() {
        try {
            saveFile.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Autor> load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(saveFile));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                String imagen = partes[1];
                String DNI = partes[2];
                String Apellidos = partes[3];
                String fechaNacimiento = partes[4];
                getMisDatos().add(new Autor(nombre, imagen, DNI, Apellidos, fechaNacimiento));
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return getMisDatos();
    }

    public static void save(ArrayList<Autor> misDatosMod) {
        try {
            setMisDatos(misDatosMod);
            PrintWriter writer = new PrintWriter(saveFile);
            for (Autor misDato : misDatos) {
                writer.printf("%s,%s,%s,%s,%s\n", misDato.getNombre(), misDato.getPahtImagen(), misDato.getDNI(), misDato.getApellidos(), misDato.getFechaNacimiento());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Autor> getMisDatos() {
        return misDatos;
    }

    private static void setMisDatos(ArrayList<Autor> aMisDatos) {
        misDatos = aMisDatos;
    }

}
