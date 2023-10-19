/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barberia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

public class CrudArchivoRegistro {
    File archivoTexto;
    
    
    
    
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
   
    //funcionalida para leer archivos//
    
    public void leerPersona(String nombre){
        
    
     this.archivoTexto = new File (nombre);
     
        try {
         FileReader abrir = new FileReader(archivoTexto);
      BufferedReader bufferedReader = new BufferedReader(abrir);
            
        
        } catch (Exception e) {
        }
     

           
     
     
        
    }
}
