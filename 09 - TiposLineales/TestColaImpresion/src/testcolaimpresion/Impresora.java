/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testcolaimpresion;

/**
 *
 * @author ja.buenoseva
 */
public class Impresora {
    private String id;
    private EstadoImpresora estado;
    private TrabajoImpresora trabajo;

    public Impresora(String id) {
        this.id = id;
        this.estado= EstadoImpresora.LIBRE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EstadoImpresora getEstado() {
        return estado;
    }

    public void setEstado(EstadoImpresora estado) {
        this.estado = estado;
    }

    public TrabajoImpresora getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(TrabajoImpresora trabajo) {
        this.trabajo = trabajo;
        this.estado = EstadoImpresora.IMPRIMIENDO;
    }
    public void trabajoFinalizado() {
        this.trabajo = null;
        this.estado = EstadoImpresora.FINALIZADO;
    }

    @Override
    public String toString() {
        return "Impresora{" + "id=" + id + ", estado=" + estado + ", trabajo=" + trabajo + '}';
    }
    
    
}
