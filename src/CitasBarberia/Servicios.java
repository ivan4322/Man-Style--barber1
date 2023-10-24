/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CitasBarberia;

public class Servicios {
   
    private int id;
    private float precio;
    private String nombre;
    private int descuento;

    
    
    public Servicios(){
        
    }
    public Servicios(int id, float precio, String nombre, int descuento) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
}
