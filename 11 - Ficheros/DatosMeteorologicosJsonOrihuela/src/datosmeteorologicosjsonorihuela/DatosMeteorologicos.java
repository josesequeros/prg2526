/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosmeteorologicosjsonorihuela;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *
 * @author jabue
 */
public class DatosMeteorologicos {

    private String fecha;
    private String indicativo;
    private String nombre;
    private String provincia;
    private int altitud;
    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private double tmed;
    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private double prec;
    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private double tmin;
    private String horatmin;
    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private double tmax;
    private String horatmax;
    private int dir;
    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private double velmedia;
    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private double racha;
    private String horaracha;
    private int hrMedia;
    private int hrMax;
    private String horaHrMax;
    private int hrMin;
    private String horaHrMin;

    // Constructor vacío necesario para Jackson
    public DatosMeteorologicos() {
    }

    // Getters y Setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIndicativo() {
        return indicativo;
    }

    public void setIndicativo(String indicativo) {
        this.indicativo = indicativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public double getTmed() {
        return tmed;
    }

    public void setTmed(double tmed) {
        this.tmed = tmed;
    }

    public double getPrec() {
        return prec;
    }

    public void setPrec(double prec) {
        this.prec = prec;
    }

    public double getTmin() {
        return tmin;
    }

    public void setTmin(double tmin) {
        this.tmin = tmin;
    }

    public String getHoratmin() {
        return horatmin;
    }

    public void setHoratmin(String horatmin) {
        this.horatmin = horatmin;
    }

    public double getTmax() {
        return tmax;
    }

    public void setTmax(double tmax) {
        this.tmax = tmax;
    }

    public String getHoratmax() {
        return horatmax;
    }

    public void setHoratmax(String horatmax) {
        this.horatmax = horatmax;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public double getVelmedia() {
        return velmedia;
    }

    public void setVelmedia(double velmedia) {
        this.velmedia = velmedia;
    }

    public double getRacha() {
        return racha;
    }

    public void setRacha(double racha) {
        this.racha = racha;
    }

    public String getHoraracha() {
        return horaracha;
    }

    public void setHoraracha(String horaracha) {
        this.horaracha = horaracha;
    }

    public int getHrMedia() {
        return hrMedia;
    }

    public void setHrMedia(int hrMedia) {
        this.hrMedia = hrMedia;
    }

    public int getHrMax() {
        return hrMax;
    }

    public void setHrMax(int hrMax) {
        this.hrMax = hrMax;
    }

    public String getHoraHrMax() {
        return horaHrMax;
    }

    public void setHoraHrMax(String horaHrMax) {
        this.horaHrMax = horaHrMax;
    }

    public int getHrMin() {
        return hrMin;
    }

    public void setHrMin(int hrMin) {
        this.hrMin = hrMin;
    }

    public String getHoraHrMin() {
        return horaHrMin;
    }

    public void setHoraHrMin(String horaHrMin) {
        this.horaHrMin = horaHrMin;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + "\n"
                + "Indicativo: " + indicativo + "\n"
                + "Nombre: " + nombre + "\n"
                + "Provincia: " + provincia + "\n"
                + "Altitud: " + altitud + "m\n"
                + "Temperatura Media: " + tmed + "°C\n"
                + "Precipitación: " + prec + "mm\n"
                + "Temp. Mínima: " + tmin + "°C a las " + horatmin + "\n"
                + "Temp. Máxima: " + tmax + "°C a las " + horatmax + "\n"
                + "Dirección Viento: " + dir + "\n"
                + "Velocidad Media Viento: " + velmedia + " km/h\n"
                + "Racha Máxima: " + racha + " km/h a las " + horaracha + "\n"
                + "Humedad Media: " + hrMedia + "%\n"
                + "Humedad Máxima: " + hrMax + "% a las " + horaHrMax + "\n"
                + "Humedad Mínima: " + hrMin + "% a las " + horaHrMin;
    }
}
