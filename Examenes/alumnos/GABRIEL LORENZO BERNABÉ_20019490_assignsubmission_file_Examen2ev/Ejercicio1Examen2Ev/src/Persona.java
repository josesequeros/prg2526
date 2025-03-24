  class Persona {
    String nombre;
    String apellidos;
    String correo;

    public Persona(String nombre, String apellidos, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    public  void mostrarDetalles() {
        System.out.println("Datos del trabajador:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        if (correo.endsWith("@contabilidad.es")) {
            if (correo.endsWith("@gestion.es")) {
                System.out.println("Correo: " + correo);
            } else {
                System.out.println("Correo no válido");
        }
     }
    }
    }
