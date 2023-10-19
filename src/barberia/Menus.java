/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barberia;

import javax.swing.JOptionPane;

/**
 *
 * @author Ivan Dariocodigoc13
 */
public class Menus {
   Validaciones validar;
    Persona persona;
    CrudArchivoRegistro guardar;
    int id;

    Validaciones valida;

    //Validaciones
    public void principalMenuValue() {
        boolean resultadoValidar = false;
        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido a MenStyle Barberia \n como deseas registarte \n digite 1 para barbero\n digita 2 para cliente \n 3 para salir"));

        switch (id) {
            case 1:

                this.valida = new Validaciones();
                JOptionPane.showMessageDialog(null, "Validar registro");
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento"));

                resultadoValidar = valida.validarPersona(id, "listaBarberos.txt");
                if (resultadoValidar == true) {
                    JOptionPane.showMessageDialog(null, "BIENVENIDO \n ya estas registrado como barbero\n");
                    menuBarbero();
                } else {
                    JOptionPane.showMessageDialog(null, "Debes registrarte");
                    Barbero barbero = new Barbero();
                    registroInicial(barbero);

                }
                break;

            case 2:
                JOptionPane.showMessageDialog(null, "Validar registro ");

                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento"));
                this.valida = new Validaciones();
                resultadoValidar = valida.validarPersona(id, "listaClientes.txt");
                if (resultadoValidar == true) {
                    //metodo mostrar menu del cliente//  
                    JOptionPane.showMessageDialog(null, "BIENVENIDO \n ya estas registrado como cliente");
                } else {
                    JOptionPane.showMessageDialog(null, "aun no estas registrado \n debes registrarte");
                    Cliente cliente = new Cliente();
                    registroInicial(cliente);

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

    
    public void menuBarbero() {
        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la opcion que desea \n 1 para ver sus agendas \n 2 para editar tus datos  \n 3 para salir"));

        switch (id) {
            case 1:
                System.out.println("llamar al metodo ver sus agendas");
                break;

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

    //Si es cliente: Agendar una cita, ver horarios de barberos, eliminar cita, modificar sus dato
    public void menuCliente() {
 id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la opcion que desea \n 1 para agendar una cita \n 2 para ver hotarios de barberos  \n 3 para eliminar una cita \n 4 modificar sus datos \n 5 para salir"));
    }

    public void registroInicial(Persona persona) {
        boolean validacion = false;
        persona.setNombre(JOptionPane.showInputDialog(null, "Digite el Nombre"));
        persona.setApellido(JOptionPane.showInputDialog(null, "Digite el Apellido"));
        persona.setTelefono(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su Numero de Telefono")));
        persona.setId(Integer.parseInt(JOptionPane.showInputDialog("ingrese su identificacion")));

        this.guardar = new CrudArchivoRegistro();
        validacion = valida.validarPersona(persona.getId(), "listaBarberos.txt");
        System.out.println("v " +validacion);
        if (persona instanceof Barbero && validacion == false) {
            guardar.registroPersona(persona, "listaBarberos.txt");
            System.out.println("guardando en barberos");
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else if (persona instanceof Cliente && validacion == false) {
            guardar.registroPersona(persona, "listaClientes.txt");
            System.out.println("guardando en clientes");
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else if(validacion ==true){
            JOptionPane.showMessageDialog(null, "numero de identificacion ya existe en nuestro sistema");
            principalMenuValue();

        }

    }

}
  

