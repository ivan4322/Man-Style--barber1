/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, long id, long telefono, int identificacion) {
        super(nombre, apellido, correo, id, telefono);
    }
    
}
