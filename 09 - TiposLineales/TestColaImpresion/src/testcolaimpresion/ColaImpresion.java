/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testcolaimpresion;

import java.util.ArrayList;

/**
 *
 * @author ja.buenoseva
 */
public class ColaImpresion {

    private int tiempo = 0;
    private final int duracionMinima = 30;
    private final int duracionMaxima = 1000;
    private int tiempoGeneracionTrabajo = 100;
    private int trabajo = 1;
    private int totalTrabajos = 30;
    private int trabajosFinalizados = 0;
    private ArrayList<Impresora> impresoras = new ArrayList<>();
    private ColaGenerica<TrabajoImpresora> colaTrabajosImpresion = new ColaGenerica<>();

    public void encender() {
        // Generar Trabajo?
        while (trabajo <= totalTrabajos) {
            System.out.println("Tiempo: " + tiempo);
            //colaTrabajosImpresion.imprimirCola();
            //colaTrabajosImpresion.mostrarLista();
            if (tiempo % tiempoGeneracionTrabajo == 0) {
                TrabajoImpresora t = generarTrabajo();
                System.out.println("Trabajo encolado: " + trabajo + " tiempo = " + tiempo);
                System.out.println(t);
                colaTrabajosImpresion.encolar(t);
                colaTrabajosImpresion.imprimirCola();
                trabajo++;
            }
            // comprobar trabajos en impresion
            Impresora impresora = seleccionarImpresoraLibreConMayorPrioridad();
            if (impresora != null) {
                System.out.println("Impresora: " + impresora);
            }
            //impresora.setTrabajo(colaTrabajosImpresion.desencolar());
            tiempo++;
        }
        System.out.println(colaTrabajosImpresion.getTalla());
        System.out.println(tiempo);
    }

    public TrabajoImpresora generarTrabajo() {
        int duracion = (int) (Math.random() * (duracionMaxima - duracionMinima) + duracionMinima);
        //System.out.println(duracion);
        TrabajoImpresora t = new TrabajoImpresora(trabajo, duracion);
        return t;
    }

    public void addImpresora(Impresora impresora) {
        // prioridad en orden añadido
        this.impresoras.add(impresora);
    }

    private Impresora seleccionarImpresoraLibreConMayorPrioridad() {
        Impresora aux = null;
        for (Impresora impresora : impresoras) {
            if (impresora.getEstado() == EstadoImpresora.LIBRE) {
                aux = impresora;
                break;
            }
        }
        return aux;
    }
}
