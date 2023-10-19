/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barberia;

import java.io.Serializable;

/**
 *
 * @author Ivan Dariocodigoc13
 */
public class Barbero extends Persona implements Serializable{
    private static final long serializarVersionUID=1L;

    public Barbero() {
    }

    public Barbero(String nombre, String apellido, String correo, long id, long telefono) {
        super(nombre, apellido, correo, id, telefono);
    }
 
}

