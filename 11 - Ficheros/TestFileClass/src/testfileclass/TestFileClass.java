/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testfileclass;

/**
 *
 * @author jabue
 */
public class TestFileClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        java.io.File file = new java.io.File("src/testfileclass/archivo.txt");
        System.out.println("¿Existe? " + file.exists());
        System.out.println("El archivo tiene " + file.length() + " bytes");
        System.out.println("¿Se puede leer? " + file.canRead());
        System.out.println("¿Se puede escribir? " + file.canWrite());
        System.out.println("¿Es un directorio? " + file.isDirectory());
        System.out.println("¿Es un archivo? " + file.isFile());
        System.out.println("¿Es absoluto? " + file.isAbsolute());
        System.out.println("¿Está oculto? " + file.isHidden());
        System.out.println("La ruta absoluta es "
                + file.getAbsolutePath());
        System.out.println("Modificado por última vez el "
                + new java.util.Date(file.lastModified()));

    }

}
