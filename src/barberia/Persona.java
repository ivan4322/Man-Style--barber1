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
public class Persona implements Serializable {
    private static final long serializarVersionUID=1L;

    private String nombre;
    private String apellido;
    private String correo;
    private long id;
    private long telefono;
    private int id2;
    public static int contPersonas;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String correo, long id, long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.id = id;
        this.telefono = telefono;
        this.id2=++Persona.contPersonas;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getId2(){
        return id2;
        
    }

}
   
    


