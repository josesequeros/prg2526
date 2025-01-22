/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jabue
 */
public class Estudiante extends Persona {

    private int idEstudiante;
    private LocalDate fechaMatriculacion;

    public Estudiante(int idEstudiante, LocalDate fechaMatriculacion, String nombre, int edad, LocalDate fechaNacimiento) {
        super(nombre, edad, fechaNacimiento);
        this.idEstudiante = idEstudiante;
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public void matricularCurso(Curso curso) {
        curso.agregarParticipante(this);
        System.out.println(this.getNombre() + " se ha matriculado en el curso " + curso.getNombreCurso());
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("ID Estudiante: " + idEstudiante);
        System.out.println("Fecha de Matriculación: " + fechaMatriculacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
