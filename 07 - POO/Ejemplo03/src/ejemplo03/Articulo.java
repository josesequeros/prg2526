/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo03;

/**
 *
 * @author IEUser
 */
public class Articulo {

    // Atributos de la Clase
    private String cod;
    private String titulo;
    private String formato;
    private float precio_alquiler;

    // Métodos de la Clase
    public void modificaValores(String cod, String titulo, String formato, float precio_alquiler) {
        this.cod = cod;
        this.titulo = titulo;
        this.formato = formato;
        this.precio_alquiler = precio_alquiler;
    }
    
    float precio1() {
        return getPrecio_alquiler();
    }

    float precio2() {
        float precio_total;
        precio_total = getPrecio_alquiler() * 1.8f;
        return precio_total;
    }

    float precio_semana() {
        float precio_total;
        precio_total = getPrecio_alquiler() * 5;
        return precio_total;
    }

    // Refactorizamos Setters y Getters
    /**
     * @return the cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * @return the precio_alquiler
     */
    public float getPrecio_alquiler() {
        return precio_alquiler;
    }

    /**
     * @param precio_alquiler the precio_alquiler to set
     */
    public void setPrecio_alquiler(float precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }

}
