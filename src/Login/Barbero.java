
package Login;

import java.io.Serializable;



public class Barbero extends Persona implements Serializable{
    private static final long serializarVersionUID=1L;

    public Barbero() {
    }

    public Barbero(String nombre, String apellido, String correo, long id, long telefono) {
        super(nombre, apellido, correo, id, telefono);
    }
 
}

