
package CitasBarberia;

import Login.Barbero;
import Login.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.JOptionPane;


public class Agenda {
 private int tiket;
 private Cliente cliente;
 private Barbero barbero;
 private boolean estadoCita;
 LocalTime horaActual;
 
  private Servicios servicio;
//private MetodoPago pago;

  
  //LocalTime horaActual;  LocalTime.now();

        // Imprimir la hora actual
public Agenda(){
    
}


    public Agenda(int tiket, Cliente cliente, Barbero barbero, boolean estadoCita, LocalTime horaActual) {
        this.tiket = tiket;
        this.cliente = cliente;
        this.barbero = barbero;
        this.estadoCita = estadoCita;
     
        
    }

    public int getTiket() {
        return tiket;
    }

    public void setTiket(int tiket) {
        this.tiket = tiket;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }

    public boolean isEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(boolean estadoCita) {
        this.estadoCita = estadoCita;
    }


  

    
}
    
    
    

