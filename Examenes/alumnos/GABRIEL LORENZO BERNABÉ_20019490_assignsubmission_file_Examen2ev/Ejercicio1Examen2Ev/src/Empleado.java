public class Empleado extends Persona{
        int sueldo;
        public Empleado(int sueldo,String nombre, String apellidos, String correo) {
            super(nombre, apellidos, correo);
            this.sueldo = sueldo;
        }
    }

