
//original
package Login;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, int identificacion, long telefono ) {
        super(nombre, apellido, correo, identificacion, telefono);
    }
    
}