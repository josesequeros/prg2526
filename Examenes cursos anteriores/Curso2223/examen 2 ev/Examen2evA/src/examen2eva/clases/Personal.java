/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2eva.clases;

import examen2eva.excepciones.EmailExcepcion;
import examen2eva.excepciones.NombreExcepcion;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author IEUser
 */
public class Personal {

    private String apellidos;
    private String email;
/*
    public Personal(String apellidos, String email) {
        Pattern pat = Pattern.compile("^[A-Za-z]+(\\.[A-Za-z]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$");
        Matcher mat = pat.matcher(email);
        Pattern pat2 = Pattern.compile("[a-zA-Z]+[a-zA-Z ]*");
        Matcher mat2 = pat2.matcher(apellidos);
        try {
            if (mat.find()) {
                if (mat2.matches()) {
                    this.apellidos = apellidos;
                    this.email = email;
                } else {
                    throw new NombreExcepcion();
                }
            } else {
                throw new EmailExcepcion();
            }

        } catch (EmailExcepcion e) {
            System.out.println(email + ": " + e.getMessage());
        } catch (NombreExcepcion e) {
            System.out.println(apellidos + ": " + e.getMessage());
        }
    }
*/
    
        public Personal(String apellidos, String email) {
        Pattern pat = Pattern.compile("^[A-Za-z]+(\\.[A-Za-z]+)*@[A-Za-z]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,3})$");
        Matcher mat = pat.matcher(email);
        Pattern pat2 = Pattern.compile("[a-zA-Z]+[a-zA-Z ]*");
        Matcher mat2 = pat2.matcher(apellidos);
         
        try {
            if (email.matches("^[A-Za-z]+(\\.[A-Za-z]+)*@[A-Za-z]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,3})$")) {    
                if (apellidos.matches("[a-zA-Z]+[a-zA-Z ]*")) {
                    this.apellidos = apellidos;
                    this.email = email;
                } else {
                    throw new NombreExcepcion();
                }
            } else {
                throw new EmailExcepcion();
            }

        } catch (EmailExcepcion e) {
            System.out.println(email + ": " + e.getMessage());
        } catch (NombreExcepcion e) {
            System.out.println(apellidos + ": " + e.getMessage());
        }
    }
    
    @Override
    public String toString() {
        return "Nombre: " + getApellidos() + " - email= " + getEmail();
    }

    //static public Personal buscarPersonal(Personal[] lista, String email) {
    static public Personal buscarPersonal(ArrayList<Personal> lista, String email) {
        //System.out.println("Tamaño lista: " + lista.size());
        Personal aux = null;//new Personal("", "");
        for (Personal lista1 : lista) {
            if (lista1.getEmail() != null && lista1.getEmail().equals(email)) {
                aux = lista1;
                break;
            }
        }
        return aux;
    }

    //static public Personal[] aleatorios5(Personal[] lista) {
    static public ArrayList<Personal> aleatorios5(ArrayList<Personal> lista) {
        //Personal[] listaSeleccionada = new Personal[5];
        ArrayList<Personal> listaSeleccionada = new ArrayList<>();
        Integer[] aleatorio = new Integer[lista.size()];
        for (int i = 0; i < aleatorio.length; i++) {
            aleatorio[i] = i;
        }
        shuffle(aleatorio);
        if (lista.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Personal aux = lista.get(aleatorio[i]);
                listaSeleccionada.add(aux);
            }
        } else {
            listaSeleccionada = lista;
        }
        return listaSeleccionada;
    }

    /**
     * Swap two items of an array....Intercambiar 2 items de un array
     *
     * @param <Integer>
     * @param array
     * @param i posición a intercambiar
     * @param j posición a intercambiar
     */
    protected static <Integer> void swap(Integer[] array, int i, int j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Shuffle an arbitrary array with Knut's algorithm.... Desordenar (Barajar)
     * un array con el algoritmo de Knut
     *
     * @param array
     */
    public static void shuffle(Integer[] array) {
        if (array.length > 0) {
            Random random = new Random();
            int i = 0;
            for (int j : random.ints(array.length, 0, array.length).toArray()) {
                swap(array, i++, j);
            }
        }
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
