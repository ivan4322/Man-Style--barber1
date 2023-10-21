


package Login;

import javax.swing.JOptionPane;



public class Menus {
   CrudPersonasValidaciones validar;
    Persona persona;
    int id;
    CrudPersonasValidaciones valida;

   
    
    //EN ESTA CLASE VAMOS A VISUALIZAR TODOS LOS MENUS, ESTA EL MENU PRINCIPAL
    //DEPENDIENDO DE LA NECESIDAD DEL USUARIO ESTE MENU PRINCIPAL ME DISTRIBUYE A OTROS MENUS
    //ESTOS SE LLAMAN MENUCLIENTE Y OTRO QUE ES EL DE MENUBARBERO//
    //SE AGREGARAN MAS SEGUN NECESITEMOS//
    
    
    
    
    //MENU PRINCIPAL//
    public void principalMenuValue() {
        boolean resultadoValidar = false;
        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido a MenStyle Barberia \n como deseas registarte \n digite 1 para barbero\n digita 2 para cliente \n 3 para salir"));

        switch (id) {
            case 1:
               this.valida = new CrudPersonasValidaciones();
               
                JOptionPane.showMessageDialog(null, "Validar registro");
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento"));
              
                resultadoValidar = valida.validarPersona(id, "listaBarberos.txt");
                if (resultadoValidar == true) {
                    JOptionPane.showMessageDialog(null, "BIENVENIDO \n ya estas registrado como barbero\n");
                    menuBarbero();
                } else {
                    JOptionPane.showMessageDialog(null, "Debes registrarte");
                    Barbero barbero = new Barbero();
                    valida.registroInicial(barbero);
                  
                 
                }
                break;

            case 2:
                JOptionPane.showMessageDialog(null, "Validar registro ");

                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento"));
                this.valida = new CrudPersonasValidaciones();
                resultadoValidar = valida.validarPersona(id, "listaClientes.txt");
                if (resultadoValidar == true) {
                    //metodo mostrar menu del cliente//  
                    JOptionPane.showMessageDialog(null, "BIENVENIDO \n ya estas registrado como cliente");
                    menuCliente();
                } else {
                    JOptionPane.showMessageDialog(null, "aun no estas registrado \n debes registrarte");
                    Cliente cliente = new Cliente();
                    valida.registroInicial(cliente);

                }
                break;

            case 3:
                JOptionPane.showMessageDialog(null, "Programa cerrado con exito");
                throw new AssertionError();
            default:
                JOptionPane.showMessageDialog(null, "opcion no valida");
                principalMenuValue();
        }

    }

    
   
    //MENU BARBERO//
    public void menuBarbero() {
        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la opcion que desea \n 1 para ver Agendas \n 2 para editar los datos de las agendas  \n 3 para salir"));

        switch (id) {
            case 1:
                
                System.out.println("ver agendas");
                /*
               Cliente cliente = new Cliente();
                valida.leer(cliente,"listaClientes.txt");
                break;
*/
            case 2:
                System.out.println("llamar al metodo editar tus datos datos");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Programa cerrado con exito");
                break;
            default:
                JOptionPane.showMessageDialog(null, "opcion no valida");
                menuBarbero();
        }

    }

    //Si es cliente: Agendar una cita, ver horarios de barberos, eliminar cita, modificar sus datos
    //MENU CLIENTE//
    public void menuCliente() {
 id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la opcion que desea \n 1 para ver la lista de usuarios \n 2 para ver hotarios de barberos  \n 3 para eliminar una cita \n 4 modificar sus datos \n 5 para salir"));
        switch (id) {
            case 1:
                System.out.println("agendar citas");
                break;
                
                
            case 2:
                System.out.println("ver horarios de citas disponibles");
             break;
              case 3:
                System.out.println("eliminar una cita");
             break;
              case 4:
                System.out.println("salir o regresar algun menu");
             break;
             
            default:
                throw new AssertionError();
        }
 
    }
 
    
    
  

}
  

