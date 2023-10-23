//original
package Login;

import java.io.Serializable;



public class Barbero extends Persona implements Serializable{
    private static final long serializarVersionUID=1L;

    public Barbero() {
    }

    public Barbero(String nombre, String apellido, String correo, int identificacion, long telefono) {
        super(nombre, apellido, correo, identificacion, telefono);
    }
 
}

