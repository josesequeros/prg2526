/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nidodeserpientes;

/**
 *
 * @author jossev
 */
public class NidoDeSerpientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int huevos = (int) (Math.random() * 10 + 10);
        //Nido nido = new Nido(huevos);
        NidoArrayList nido = new NidoArrayList(huevos);
        System.out.println("El nido esta formado por " + (huevos) + " serpientes\n");
        System.out.println(nido);

        int year = 1;
        while (nido.serpientesVivas() > 0) {
            System.out.println("Year: " + year++);
            Serpiente alfa = nido.serpienteAlfa();
            if (alfa != null) {
                System.out.println("Serpiente Alfa: " + nido.serpienteAlfa().getNombre() + " - " + nido.serpienteAlfa().getDominancia());
            }
            for (Serpiente serpiente : nido.getSerpientes()) {
                if (serpiente.isViva()) {
                    int porcentajeMorir = serpiente.equals(alfa) ? 2 : 1;
                    String motivo = serpiente.anyoVida(porcentajeMorir);
                    System.out.println("\t" + serpiente);
                    if (!serpiente.isViva()) {
                        System.out.println("\t\tMuerta por: " + motivo);
                    }
                }
            }
            /*
            for (int h = 0; h < huevos; h++) {
                if (nido.getSerpientes(h).isViva()) {
                    String motivo = nido.getSerpientes(h).anyoVida();
                    if (nido.getSerpientes(h).isViva()) {
                        System.out.println("\t" + nido.getSerpientes(h));
                    } else {
                        System.out.println("\t" + nido.getSerpientes(h));
                        System.out.println("\t\tMuerta por: " + motivo);
                    }
                }
            }
             */

        }
    }
}
