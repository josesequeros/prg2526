/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

/**
 *
 * @author pabbermor3
 */
public class Persona {

    import Persona.time.LocalDate ;
    import Persona.time.format.DateTimeFormatter ;

    public class Persona {

        private String nombre;
        private String apellidos;
        private String pais;
        private String email; // @gmail, @hotmail, etc...
        private LocalDate fechaNacimiento; //fnac
        private String genero; // Chico o chica

        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public Persona() {
        }

        public Persona(String nombre, String apellidos, String pais, String email,
                LocalDate fechaNacimiento, String genero) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.pais = pais;
            this.email = email;
            this.fechaNacimiento = fechaNacimiento;
            this.genero = genero;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getFechaNacimientoStr() {
            return fechaNacimiento != null ? fechaNacimiento.format(FORMATTER) : "";
        }

        @Override
        public String toString() {
            return apellidos + ", " + nombre + " - " + pais;
        }
    }
}
