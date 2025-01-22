/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ageofempires;

/**
 *
 * @author IEUser
 */
public class Aldeano {
    private Civilizacion civilizacion;
    private int vida;
    private int oro;
    private int piedra;
    private int madera;
    private int[] almacen;  // ejemplo de uso enumerados
    
    static final private int vaciarMochila = 1;

    public Aldeano(Civilizacion civilizacion, int vida) {
        this.civilizacion = civilizacion;
        this.vida = vida;
        oro = 0;
        piedra = 0;
        madera = 0;
        // Ejemplo de uso enumerados
        almacen = new int[TipoMina.values().length];
        for (TipoMina tp: TipoMina.values()) {
            almacen[tp.ordinal()] = 0;
        }
    }

 
    /**
     * @return the civilizacion
     */
    public Civilizacion getCivilizacion() {
        return civilizacion;
    }

    /**
     * @param civilizacion the civilizacion to set
     */
    public void setCivilizacion(Civilizacion civilizacion) {
        this.civilizacion = civilizacion;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the oro
     */
    public int getOro() {
        return oro;
    }

    /**
     * @param oro the oro to set
     */
    public void setOro(int oro) {
        this.oro = oro;
    }

    /**
     * @return the piedra
     */
    public int getPiedra() {
        return piedra;
    }

    /**
     * @param piedra the piedra to set
     */
    public void setPiedra(int piedra) {
        this.piedra = piedra;
    }

    /**
     * @return the madera
     */
    public int getMadera() {
        return madera;
    }

    /**
     * @param madera the madera to set
     */
    public void setMadera(int madera) {
        this.madera = madera;
    }

    @Override
    public String toString() {
        return "Aldeano{" + "civilizacion=" + civilizacion + ", vida=" + vida + ", oro=" + oro + ", piedra=" + piedra + ", madera=" + madera + '}';
    }
    
    public void sumarItem(String tipo, int ctd){
        if (tipo.equals(TipoMina.ORO.name())) {
            setOro(this.oro + ctd);
            if (this.oro >= vaciarMochila) {
                //System.out.println("Vaciar Mochila Oro");
                this.civilizacion.setOro(this.civilizacion.getOro() + ctd);
            }
        }
        else {
            System.out.println("Tipo de item: " + tipo + "Tipo de mina: "+ TipoMina.ORO);
        }
    }
    public void sumarItem(TipoMina tipo, int ctd){
        switch (tipo) {
            case ORO:
                setOro(this.oro + ctd);
                break;
            case PIEDRA:
                setPiedra(this.piedra + ctd);
                break;
            case MADERA:
                setMadera(this.madera + ctd);
                break;
        }
        if (this.oro >= vaciarMochila) {
                //System.out.println("Vaciar Mochila Oro");
                this.civilizacion.setOro(this.civilizacion.getOro() + ctd);
            }
    }
}
