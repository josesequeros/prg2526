/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioexcepciones02;

/**
 *
 * @author IEUser
 */
public class EjercicioExcepciones02 {

    private static class Excepcion1 extends Exception {

        public Excepcion1() {
        }
    }

    private static class Excepcion2 extends Exception {

        public Excepcion2() {
        }
    }

    static class Excepcion3 extends Exception {

        public Excepcion3() {
        }
    }

    static class InputFormatException extends Exception {

        public InputFormatException() {
        }
    }

    
    public static void metodo1() throws Excepcion1, Excepcion2 {
        //... (1)
        if (false) {
            throw new IndexOutOfBoundsException();
        }
        if (false) {
            throw new Excepcion1();
        }
        if (false) {
            throw new Excepcion2();
        }
    }

    public static void metodo2() {
        try {
            //... (2)
            if (false) {
                throw new InputFormatException();
            }
            if (false) {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("texto0");
        }
    }

    public static void metodo3() throws Excepcion3, Excepcion1 {
        //... (3)
        if (false) {
            throw new Excepcion3();
        }
        if (true) {
            throw new InputFormatException();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            metodo1();
            metodo2();
            metodo3();
            if (false) {
                throw new InputFormatException();
            }
        } catch (Excepcion1 e) {
            System.out.println("texto1");
        } catch (Excepcion2 e) {
            System.out.println("texto2");
        } catch (Excepcion3 e) {
            System.out.println("texto3");
        } catch (InputFormatException e) {
            System.out.println("texto4");
        } finally {
            System.out.println("texto5");
        }
    }

}
