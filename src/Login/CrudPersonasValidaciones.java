
//original
package Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


public class CrudPersonasValidaciones {
    
    //
    

    CrudArchivoRegistro guardar;
    File archivo;
    Menus menu;

    //ESTOS METODOS SON DINAMICOS DE LA APP Y SE RELACIONAN CON LA CLASE DE CRUDARCHIVOSREGISTROS
    //LO QUE HACE ESTA CLASE ES MANDAR LA INFORMACION A LOS METODOS DE LA CLASECRUDARCHIVOSREGISTRO
    //EJEMPLO DE COMO SE MANDA INFORMACION: METODO REGISTRO INICIAL MANDA INFORMACION A LA CLASE DE ARCHIVOS
    
    //EJEMPLO DE RECIBIR INFORMACION: ME DEVUELVE LA INFORMACION DE LOS ARCHIVOS//
    
    //PARA QUE SEAN GUARDADOS EN LOS ARCHIVOS, TAMBIEN RECIBE LA INFORMACION Y LA PROCESA//
    //
    
    
    
    
    //metodo para validar si la persona existe con el numero de identificacion, me devuelve un booleano
  //este metodo se ejecuta en la clase menu //
    public boolean validarPersona(int id, String nombreLista) {
        boolean devolver = false;
        try {
            //Definiendo MAP
            Map<Integer, Integer> mapId = new HashMap<>();
            int i = 1;
            archivo = new File(nombreLista);
            Persona persona = new Persona();
            if (archivo.exists()) {
                FileInputStream aperturaArchivo = new FileInputStream(nombreLista);
                ObjectInputStream salidaArchivo = new ObjectInputStream(aperturaArchivo);
                while (true) {

                    try {
                        persona = (Persona) salidaArchivo.readObject();
                        mapId.put(i, persona.getIdentificacion());

                        System.out.println("" + persona.getIdentificacion());
                        i++;
                    } catch (Exception e) {
                        break;
                    }
                }
                devolver = mapId.containsValue(id);
            }

        } catch (Exception e) {
        }

        return devolver;
    }
    
    
    
    //metodo para registrar la persona, ya sea de tipo cliente o barbero//
//metodo se ejecuta en la clase Menu, en el menu principal, verificar //
    
    public void registroInicial(Persona persona) {
        boolean validacionBarbero = false;
        boolean validacionCliente = false;
        try {
            
           persona.setNombre(JOptionPane.showInputDialog(null, "Digite el Nombre"));
        persona.setApellido(JOptionPane.showInputDialog(null, "Digite el Apellido"));
        persona.setTelefono(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su Numero de Telefono")));
        persona.setIdentificacion(Integer.parseInt(JOptionPane.showInputDialog("ingrese su identificacion"))); 
        } catch (Exception e) {
            registroInicial(persona);
        }
        
        this.guardar = new CrudArchivoRegistro();
        
        validacionBarbero = validarPersona(persona.getIdentificacion(), "listaBarberos.txt");
        validacionCliente = validarPersona(persona.getIdentificacion(), "listaClientes.txt");
      
        if (persona instanceof Barbero && validacionBarbero == false) {
            guardar.registroPersona(persona, "listaBarberos.txt");
            JOptionPane.showMessageDialog(null, "Registro exitoso");
         
        } else if (persona instanceof Cliente && validacionCliente == false ) {
            guardar.registroPersona(persona, "listaClientes.txt");
            JOptionPane.showMessageDialog(null, "Registro exitoso");
         
        } else if (validacionBarbero == true  || validacionCliente == true) {
            JOptionPane.showMessageDialog(null, "numero de identificacion ya existe en nuestro sistema");
            menu.principalMenuValue();
           

        }

    }
    
    //METODO PARA LEER INFORMACION DEL ARCHIVO, //
    public void leer(Persona persona, String nombreLista){
     
     CrudArchivoRegistro leyendo = new CrudArchivoRegistro();
     
     leyendo.leerPersona(persona,nombreLista);
   
     
     
   } 
    
    
    
    public void Eliminar(Persona persona,String nombre){
        
   int id =  Integer.parseInt(JOptionPane.showInputDialog(null, "digite el numero de documento a eliminar"));
    
   if(persona instanceof Barbero ){
       guardar = new CrudArchivoRegistro();
    guardar.eliminar(id, nombre);
   }else if(persona instanceof Cliente){
     guardar = new CrudArchivoRegistro();
    guardar.eliminar(id, nombre);  
   }
        
        
        
    }
    
    

}
