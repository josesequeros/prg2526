/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad;

import java.time.LocalDate;

/**
 *
 * @author jabue
 */
public class Empleado extends Persona {

    private int idEmpleado;
    private RoleEmpleado role;

    public Empleado(String nombre, int edad, LocalDate fechaNacimiento, int idEmpleado, RoleEmpleado role) {
        super(nombre, edad, fechaNacimiento);
        this.idEmpleado = idEmpleado;
        this.role = role;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("ID Empleado: " + idEmpleado);
        System.out.println("Rol: " + role);
    }

    public void matricularCurso(Curso curso) {
        curso.agregarParticipante(this);
        System.out.println(this.getNombre() + " " + this.role.name() + " Profesor del curso " + curso.getNombreCurso());
    }
}
