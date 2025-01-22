/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ageofempires;

import java.util.ArrayList;

/**
 *
 * @author IEUser
 */
public class AgeOfEmpires {

    private ArrayList<Civilizacion> civilizaciones;
    private Mina mina;

    /**
     * Constructor de la Clase. Crea un ArrayList sin elementos
     */
    public AgeOfEmpires() {
        this.civilizaciones = new ArrayList<>();
        mina = new Mina();
    }

    public AgeOfEmpires(Mina mina) {
        this.civilizaciones = new ArrayList<>();
        this.mina = mina;
    }

    public void addCivilizacion(Civilizacion civilizacion) {
        this.civilizaciones.add(civilizacion);
    }

    public Aldeano crearAldeano() {
        Aldeano a = null;
        int n = (int) (Math.random() * 10);
        if (n < 6) {
            a = new Aldeano(getCivilizacion("Españoles"), 200);
        } else if (n < 8) {
            a = new Aldeano(getCivilizacion("Bizantinos"), 250);
        }
        return a;
    }

    public Civilizacion getCivilizacion(String nombre) {
        Civilizacion c = null;
        for (Civilizacion civilizacion : civilizaciones) {
            if (civilizacion.getNombre().equals(nombre)) {
                c = civilizacion;
            }
        }
        return c;
    }

    /**
     * @return the civilizaciones
     */
    public ArrayList<Civilizacion> getCivilizaciones() {
        return civilizaciones;
    }

    /**
     * @param civilizaciones the civilizacionesto set
     */
    public void setCivilizaciones(ArrayList<Civilizacion> civilizaciones) {
        this.civilizaciones = civilizaciones;
    }

    public void simular(int tiempoSimulacion, int tiempoCrearAldeano, int tiempoAtaqueMonje, int itemsMina) throws InterruptedException {
        Aldeano aldeano;
        Mina minaOro = new Mina(TipoMina.ORO, itemsMina);
        int segundos = 0;

        this.setMina(minaOro);

        while (segundos < tiempoSimulacion && this.getMina().getItems() > 0) {
            System.out.println("Segundo: " + ++segundos);
            // cada segundo
            mina.extraerItem(1);
            System.out.println("\tQuedan en la mina: " + mina.getItems() + " items.");
            
            // cada 2 segundos
            if (segundos % tiempoCrearAldeano == 0) {
                aldeano = this.crearAldeano();
                if (aldeano != null) {
                    mina.addAldeano(aldeano);
                    aldeano.getCivilizacion().getAldeanos().add(aldeano);
                    System.out.println("\t" + aldeano.getCivilizacion().getNombre());
                } else {
                    System.out.println("\t\tNada");
                }
            }

            // cada 5 segundos ataca el monje
            if (segundos % (tiempoAtaqueMonje * 2) == 0) {
                // obtener un aldeano español. Realmente seria de una civilización enemiga
                aldeano = mina.seleccionarAldeano(getCivilizacion("Españoles"));
                if (aldeano != null) {
                    //int pos = aldeano.getCivilizacion().buscarAldeano(aldeano);
                    System.out.println("Aldeano Convertido: " + aldeano);
                    aldeano.getCivilizacion().getAldeanos().remove(aldeano);
                    aldeano.setCivilizacion(getCivilizacion("Bizantinos"));
                    aldeano.getCivilizacion().getAldeanos().add(aldeano);
                    System.out.println("Aldeano Convertido: " + aldeano);
                    System.out.println("Convertido un aldeano");
                    mina.listarAldeanos();
                }
                // convertir, cambiar a la civilización del monje
            }
            //minaOro.extraer();
            System.out.println("\t" + this.mina);
            Thread.sleep(10);
        }
        System.out.println("Relación de Aldeanos de la mina: ");
        mina.listarAldeanos();
        System.out.println("");
        System.out.println("Estado de las Civilizaciones de la Simulación: ");
        for (int i = 0; i < this.civilizaciones.size(); i++) {
            System.out.println(getCivilizaciones().get(i));
        }
    }

    /**
     * @return the mina
     */
    public Mina getMina() {
        return mina;
    }

    /**
     * @param mina the mina to set
     */
    public void setMina(Mina mina) {
        this.mina = mina;
    }

}
