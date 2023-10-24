
package CitasBarberia;

import Login.MiObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class CrudArchivosCitas {

 File archivoTexto;
    
    //ESTA CLASE LO QUE HACE ES EL TRABAJO DE ARCHIVOS, ME RECIBE LA INFORMACION DE LA CLASE CRUDPERSONASVALIDACIONES//
   
    /*EN ESTA CLASE VAMOS A ENCONTRAR LO QUE ES EL CRUD DE  LOS ARCHIVOS INICIANDO DESDE EL REGISTRO
    
      CREAR,LEER,  EDITAR Y ELIMINAR, TODO ESTO DESDE LOS ARCHIVOS
    */
    
    
    //REGISTRO PERSONA EN ARCHIVOS//
    public void registroAgenda(Agenda agenda, String nombreLista){
        
        try{
        archivoTexto = new File(nombreLista);
        if(archivoTexto.exists()){
        FileOutputStream aperturaArchivo1 = new FileOutputStream(nombreLista,true);
        MiObjectOutputStream salidaArchivo1 = new MiObjectOutputStream(aperturaArchivo1);
        salidaArchivo1.writeObject(agenda);  
        }else { 
            
        FileOutputStream aperturaArchivo = new FileOutputStream(nombreLista,true);
        ObjectOutputStream salidaArchivo = new ObjectOutputStream(aperturaArchivo);
        salidaArchivo.writeObject(agenda);
        salidaArchivo.close();
        aperturaArchivo.close();
        }    
        }catch(Exception e){
            
        }
    }
   
    //funcionalida para leer DESDE archivos//
    
public void leerPersona(Agenda agenda, String nombre){
         this.archivoTexto = new File (nombre);
    
        List<Agenda> listaAgenda = new ArrayList<>();
        try {
            if(archivoTexto.exists()){
       FileInputStream abrir = new FileInputStream(archivoTexto);
      //FileReader abrir = new FileReader(archivoTexto);
     // BufferedReader bufferedReader = new BufferedReader(abrir);
      ObjectInputStream in = new ObjectInputStream(abrir);
     
        while (true) {                    
            try {
              agenda =(Agenda) in.readObject();
           listaAgenda.add(agenda);
            } catch (Exception e) {
            break;    
            }
           
       }
        abrir.close();
        in.close();
        
        for(Agenda guardador: listaAgenda){
             //JOptionPane.showMessageDialog(null, "nombre " +guardador.getNombre()+ "\n apellido " + guardador.getApellido() 
                     //+ "\n identificacion " +guardador.getIdentificacion()+ " \n telefono " +guardador.getTelefono());
      }
            }
            
       
        } catch (Exception e) {
            
        }  
    }
   
//METODO PARA ELIMINAR ARCHIVOS*/
  public void eliminar (int idCita, String nombre){
     
   archivoTexto = new File (nombre);
      HashMap<Integer, Agenda> agendas = new HashMap<>();
  Agenda agenda = new Agenda ();
   
      try {
      if(archivoTexto.exists()){
         
        
        FileInputStream filr = new FileInputStream(archivoTexto);  
         ObjectInputStream leyendo = new ObjectInputStream(filr);      
          while (true) {              
              try {
               agenda = (Agenda)leyendo.readObject();
              agendas.put(agenda.getTiket(), agenda);
             
              } catch (Exception e) {
                  break;
              }
   
          }
  filr.close();
  leyendo.close();
  //boolean validador;
    if(agendas.containsKey(idCita)){
        agendas.remove(idCita);
       JOptionPane.showMessageDialog(null, "eliminacion exitosa");
        actualizar(agendas,nombre);
       
     }else{
      JOptionPane.showMessageDialog(null, "no existe la identificacion");      
    }
   
      }
       
       } catch (Exception e) {
       
       }
       
        }

  
       
  //METODO ACTUALIZAR ARCHIVOS//
 public void actualizar(HashMap<Integer, Agenda > Actual,  String nombre){
     
 archivoTexto = new File (nombre);
     try {
       if(archivoTexto.exists()){
           FileOutputStream file1 = new  FileOutputStream(nombre);
           ObjectOutputStream out = new ObjectOutputStream(file1);
           for(Agenda f: Actual.values()){
               out.writeObject(f);
                }
           file1.close();
           out.close();
           }
         
     } catch (Exception e){
          
     }
 }
 
 //Metodo para editar una cita desde el menu del cliente
  
 public void editarCita (int idCita, String nombre){
     
   archivoTexto = new File (nombre);
      HashMap<Integer, Agenda> agendas = new HashMap<>();
  Agenda agenda = new Agenda ();
   
      try {
      if(archivoTexto.exists()){
         
        
        FileInputStream filr = new FileInputStream(archivoTexto);  
         ObjectInputStream leyendo = new ObjectInputStream(filr);      
          while (true) {              
              try {
               agenda = (Agenda)leyendo.readObject();
              agendas.put(agenda.getTiket(), agenda);
             
              } catch (Exception e) {
                  break;
              }
   
          }
  filr.close();
  leyendo.close();
  //boolean validador;
    if(agendas.containsKey(idCita)){
        agendas.remove(idCita);
       JOptionPane.showMessageDialog(null, "eliminacion exitosa");
        actualizar(agendas,nombre);
       
     }else{
      JOptionPane.showMessageDialog(null, "no existe la identificacion");      
    }
   
      }
       
       } catch (Exception e) {
       
       }
       
        }
 
  }  
