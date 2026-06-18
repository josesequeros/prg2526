/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funciones_y_excepciones;

import java.util.Scanner;

/**
 *
 * @author josgimgar3
 */
public class Funciones_Y_Excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean seguir = true;
        Scanner dato = new Scanner(System.in);
        System.out.print("Introduzca el numero entre 1 y 3: ");
        int f = dato.nextInt();
        switch (f) {
            case 1 -> {
                while (seguir) {
                    System.out.println("Introduzca el numero entre 1 y 9");
                    try {
                        System.out.print("Introduzca el numero entre 0 y 9: ");
                        int n = dato.nextInt();
                        if (n > 9 || n < 0) {
                            System.out.println("valor erroneo");
                            continue;
                        } else {
                            int cap = 0;
                            for (int i = 0; i < n; i++) {
                                String s = i + "";
                                if (capicua(s, 0, s.length())) {
                                    System.out.println(i);
                                    cap++;
                                }
                            }
                            System.out.print("Capicuas de 1 cifras: " + cap);
                        }

                    } catch (Exception e) {
                        System.out.println("Datos introducidos erroneos");
                    }

                }
            }
            case 2 -> {
                while (seguir) {
                    System.out.println();
                    try {
                        System.out.print("Introduzca el numero de digitos: ");
                        int n = dato.nextInt();
                        int cap = 0;
                        int ex = n * 10;
                        if (n == 0) {
                            System.out.println("Valores capicua con 0 digitos no hay ");
                        } else if (n == 1) {
                            for (int i = 0; i < n; i++) {
                                String s = i + "";
                                if (capicua(s, 0, s.length())) {
                                    System.out.println(i);
                                    cap++;
                                }
                            }
                            System.out.print("Capicuas de 1 cifras: " + cap);
                        } else if (n < 0) {
                            System.out.println("Valores capicua con" + n + "digitos no hay ");
                        } else {
                            for (int i = ex; i < (ex * 10); i++) {
                                String s = i + "";
                                if (capicua(s, 0, s.length())) {
                                    if(i < (i + 5) || i > ((ex * 10) - 5) ){
                                    System.out.println(i);
                                    }
                                    cap++;
                                }
                            }
                            System.out.print("Capicuas de" + n + "cifras: " + cap);
                        }

                        for (int i = 0; i < n; i++) {
                            String s = i + "";
                            if (capicua(s, 0, s.length())) {
                                cap++;
                            }
                        }
                        System.out.print("Capicuas de 1 cifras: " + cap);

                    } catch (Exception e) {
                        System.out.println("Datos introducidos erroneos");
                    }

                }
            }
        }

    }

    public static boolean capicua(String num, int cur1, int cur2) {
        if (cur1 >= cur2) {
            return true;
        } else {
            return capicua(num, (cur1 + 1), (cur2 - 1));
        }
    }

}
