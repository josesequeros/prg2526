/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nidodeserpientes;

import java.util.Objects;

/**
 *
 * @author jossev
 */
public class Serpiente {

    private String nombre;
    private String cuerpo;
    private int edad;
    private boolean viva;
    private int dominancia;

    public Serpiente(String nombre) {
        this.nombre = nombre;
        this.cuerpo = "";
        this.edad = 0;
        this.viva = true;
        this.dominancia = (int) (Math.random() * 100) + 1;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isViva() {
        return viva;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setViva(boolean viva) {
        this.viva = viva;
    }

    @Override
    public String toString() {
        //return "Serpiente{" + "nombre=" + nombre + ", cuerpo=" + cuerpo + ", edad=" + edad + ", viva=" + viva + '}';
        return nombre + ", " + cuerpo + ", " + edad + " years" + " dominancia "+ dominancia;
    }

    public String ultimoAnillo() {
        String color = "";
        if (this.cuerpo.length() > 0) {
            return this.cuerpo.substring(this.cuerpo.length() - 1);
        } else {
            return "";
        }
    }

    public String generarAnillo() {
        int n = (int) (Math.random() * 3);
        String[] colores = {"R", "N", "A"};

        String color = colores[n];
        if (color.equals(this.ultimoAnillo())) {
            color = colores[(n + 1) % colores.length];
        }
        return color;
    }

    public String anyoVida(int porcentajeMorir) {
        String motivo = "";
        int probabilidadMorir = (int) (Math.random() * 10 * porcentajeMorir);
        //System.out.println("prob " + probabilidadMorir);
        if (probabilidadMorir < 1) {
            this.viva = false;
            int causa = (int) (Math.random() * 100);
            if (causa < 25) {
                motivo = "Accidentalmente";
            } else if (causa < 40) {
                motivo = "Ataque de una Mangosta";
            } else {
                motivo = "Ataque de un Aguila";
            }
        } else {
            int n = (int) (Math.random() * 10);
            if (this.edad < 10) {
                // crecer o mudar

                if (n < 8) {
                    this.cuerpo += generarAnillo();
                    this.dominancia += 10;
                } else {
                    mudarPiel();
                    //this.cuerpo += generarAnillo();
                }
            } else {
                // decrecer o mudar
                if (n < 9) {
                    if (this.cuerpo.length() > 1) {
                        this.cuerpo = this.cuerpo.substring(0, this.cuerpo.length() - 1);
                        this.dominancia -= 5;
                    } else {
                        this.viva = false;
                        this.cuerpo = this.cuerpo.substring(0, this.cuerpo.length() - 1);   // ""
                        //System.out.println("Muerta");
                        motivo = "Vejez";
                    }
                } else {
                    mudarPiel();
                    //this.cuerpo += generarAnillo();
                }
            }
        }
        this.edad++;
        return motivo;
    }

    public void mudarPiel() {
        String aux = "";
        int anillos = this.cuerpo.length();
        for (int i = 0; i < anillos; i++) {
            cuerpo += generarAnillo();
        }
        this.cuerpo = this.cuerpo.substring(anillos);
    }

    public int getDominancia() {
        return dominancia;
    }

    public void setDominancia(int dominancia) {
        this.dominancia = dominancia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Serpiente other = (Serpiente) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    
}
