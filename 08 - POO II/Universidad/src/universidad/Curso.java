/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad;

import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public class Curso {

    private String nombreCurso;
    private int idCurso;
    private ArrayList<Persona> participantes;

    public Curso(String nombreCurso, int idCurso) {
        this.nombreCurso = nombreCurso;
        this.idCurso = idCurso;
        this.participantes = new ArrayList<>();
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public ArrayList<Persona> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Persona> participantes) {
        this.participantes = participantes;
    }
    
    public void agregarParticipante(Persona persona) {
        participantes.add(persona);
    }
}
