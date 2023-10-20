/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barberia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class CrudArchivoRegistro {
    File archivoTexto;
    
    //ESTA CLASE LO QUE HACE ES EL TRABAJO DE ARCHIVOS, ME RECIBE LA INFORMACION DE LA CLASE CRUDPERSONASVALIDACIONES//
   
    /*EN ESTA CLASE VAMOS A ENCONTRAR LO QUE ES EL CRUD DE  LOS ARCHIVOS INICIANDO DESDE EL REGISTRO
    
      CREAR,LEER,  EDITAR Y ELIMINAR, TODO ESTO DESDE LOS ARCHIVOS
    */
    
    
    //REGISTRO PERSONA EN ARCHIVOS//
    public void registroPersona(Persona persona, String nombreLista){
        try{
        archivoTexto = new File(nombreLista);
        if(archivoTexto.exists()){
        FileOutputStream aperturaArchivo1 = new FileOutputStream(nombreLista,true);
        MiObjectOutputStream salidaArchivo1 = new MiObjectOutputStream(aperturaArchivo1);
        salidaArchivo1.writeObject(persona);  
        }else { 
            
        FileOutputStream aperturaArchivo = new FileOutputStream(nombreLista,true);
        ObjectOutputStream salidaArchivo = new ObjectOutputStream(aperturaArchivo);
        salidaArchivo.writeObject(persona);
        salidaArchivo.close();
        aperturaArchivo.close();
        }    
        }catch(Exception e){
            
        }
    }
   
    //funcionalida para leer DESDE archivos//
    
public void leerPersona(Persona persona, String nombre){
         this.archivoTexto = new File (nombre);
    
        List<Persona> listaPersonas = new ArrayList<>();
        try {
            if(archivoTexto.exists()){
       FileInputStream abrir = new FileInputStream(archivoTexto);
      //FileReader abrir = new FileReader(archivoTexto);
     // BufferedReader bufferedReader = new BufferedReader(abrir);
      ObjectInputStream in = new ObjectInputStream(abrir);
     
        while (true) {                    
            try {
              persona =(Persona) in.readObject();
           listaPersonas.add(persona);
            } catch (Exception e) {
            break;    
            }
           
       }
        abrir.close();
        in.close();
     
        for(Persona guardador: listaPersonas){
             JOptionPane.showMessageDialog(null, "nombre " +guardador.getNombre()+ "\n apellido " + guardador.getApellido() 
                     + "\n identificacion " +guardador.getId() + " \n telefono " +guardador.getTelefono());
      }
            }
       
        } catch (Exception e) {
        }  
    }
   



//METODO PARA ELIMINAR ARCHIVOS*/
  public void eliminar (int id, String nombre){
   archivoTexto = new File (nombre);
      HashMap<Integer, Persona> personas = new HashMap<>();
  Persona persona = new Persona ();
     
      try {
      if(archivoTexto.exists()){
        FileInputStream filr = new FileInputStream(archivoTexto);  
         ObjectInputStream leyendo = new ObjectInputStream(filr);      
          while (true) {              
              try {
               persona = (Persona)leyendo.readObject();
              personas.put(persona.getId2(), persona);
             
              } catch (Exception e) {
                  break;
              }
   
          }
  filr.close();
  leyendo.close();
  //boolean validador;
    if(personas.containsKey(id)){
        personas.remove(id);
        actualizar(personas,nombre);
       
     }
   
      }
       
       } catch (Exception e) {
       }
       
        }  
       
  
  
  //METODO ACTUALIZAR ARCHIVOS//
 public void actualizar(HashMap<Integer, Persona > Actual,  String nombre){
 archivoTexto = new File (nombre);
     try {
       if(archivoTexto.exists()){
           FileOutputStream file1 = new  FileOutputStream(nombre);
           ObjectOutputStream out = new ObjectOutputStream(file1);
           for(Persona f: Actual.values()){
               out.writeObject(f);
                }
           file1.close();
           out.close();
           }
         
     } catch (Exception e){
         
     }
 }
     
  }  

   
   



           
     
     
        
    

