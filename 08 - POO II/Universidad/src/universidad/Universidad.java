/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package universidad;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jabue
 */
public class Universidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Crear instancias para probar las clases
        Estudiante estudiante1 = new Estudiante(1,LocalDate.of(2024, 2, 5), "Estudiante1", 20, LocalDate.of(2004, 1, 11));
        Estudiante estudiante2 = new Estudiante(2,LocalDate.of(2024, 2, 6),"Estudiante2", 22, LocalDate.of(2005, 2, 12));
        Empleado empleado1 = new Empleado("Empleado1", 30, LocalDate.of(1980, 1, 1), 101, RoleEmpleado.ADMINISTRADOR);
        Curso curso1 = new Curso("Programación Java", 1);

        // Mostrar información de cada persona
        System.out.println("Información del Estudiante 1:");
        estudiante1.mostrarInformacion();

        System.out.println("\nInformación del Estudiante 2:");
        estudiante2.mostrarInformacion();
        System.out.println(estudiante2);

        System.out.println("\nInformación del Profesor:");
        empleado1.mostrarInformacion();
        System.out.println(empleado1);

        // Matricular estudiantes en el curso
        estudiante1.matricularCurso(curso1);
        estudiante2.matricularCurso(curso1);
        empleado1.matricularCurso(curso1);

        // Obtener y mostrar participantes del curso
        ArrayList<Persona> participantes = curso1.getParticipantes();
        System.out.println("\nParticipantes del Curso " + curso1.getNombreCurso() + ":");
        for (Persona participante : participantes) {
            participante.mostrarInformacion();
            System.out.println();
        }
    }
}
