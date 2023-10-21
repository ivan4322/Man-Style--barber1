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
    public boolean validarPersona(long id, String nombreLista) {
        boolean devolver = false;
        try {
            //Definiendo MAP
            Map<Integer, Long> mapId = new HashMap<>();
            int i = 1;
            archivo = new File(nombreLista);
            Persona persona = new Persona();
            if (archivo.exists()) {
                FileInputStream aperturaArchivo = new FileInputStream(nombreLista);
                ObjectInputStream salidaArchivo = new ObjectInputStream(aperturaArchivo);
                while (true) {

                    try {
                        persona = (Persona) salidaArchivo.readObject();
                        mapId.put(i, persona.getId());

                        System.out.println("" + persona.getId());
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
        persona.setId(Integer.parseInt(JOptionPane.showInputDialog("ingrese su identificacion"))); 
        } catch (Exception e) {
            registroInicial(persona);
        }
        

        this.guardar = new CrudArchivoRegistro();
        
       
      
        validacionBarbero = validarPersona(persona.getId(), "listaBarberos.txt");
       
        System.out.println("cliente" + validacionCliente);
        validacionCliente = validarPersona(persona.getId(), "listaClientes.txt");
        System.out.println("barbero" +validacionBarbero);
        if (persona instanceof Barbero && validacionBarbero == false) {
            guardar.registroPersona(persona, "listaBarberos.txt");
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            System.out.println("dentrando a barberos");
        } else if (persona instanceof Cliente && validacionCliente == false ) {
            guardar.registroPersona(persona, "listaClientes.txt");
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            System.out.println("dentrando a clientes");
        } else if (validacionBarbero == true  || validacionCliente == true) {
            JOptionPane.showMessageDialog(null, "numero de identificacion ya existe en nuestro sistema");
            menu.principalMenuValue();
            System.out.println("dentrando en linea que ya esta ");

        }

    }
    
    //METODO PARA LEER INFORMACION DEL ARCHIVO, //
    public void leer(Persona persona, String nombreLista){
     
     CrudArchivoRegistro leyendo = new CrudArchivoRegistro();
     
     leyendo.leerPersona(persona,nombreLista);
   
     
     
   }  

}
