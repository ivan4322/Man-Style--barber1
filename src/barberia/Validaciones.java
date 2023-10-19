
package barberia;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;


public class Validaciones {
    File archivo;
    public boolean validarPersona(long id, String nombreLista){
       boolean devolver = false;
       
         try{
        //Definiendo MAP
        Map<Integer,Long>mapId= new HashMap<>();
        int i=1;
        archivo=new File(nombreLista);
        Persona persona = new Persona();
        if(archivo.exists()){
        FileInputStream aperturaArchivo = new FileInputStream(nombreLista);
        ObjectInputStream salidaArchivo = new ObjectInputStream(aperturaArchivo);
            while (true) {
                
            try{
            persona=(Persona)salidaArchivo.readObject();
            mapId.put(i, persona.getId());
            
            System.out.println("" + persona.getId());   
            i++;    
            }catch(Exception e){
            break;
            }   
            }
          devolver= mapId.containsValue(id);
           
           
        }
        
    }catch(Exception e){
    }
       
              
    return devolver;     
 }
   
}
    
 

