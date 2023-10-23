//original


package Login;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Menus {

    CrudPersonasValidaciones validar;
    Persona persona;
    int id;
    CrudPersonasValidaciones valida;
    Barbero barbero;

    //EN ESTA CLASE VAMOS A VISUALIZAR TODOS LOS MENUS, ESTA EL MENU PRINCIPAL
    //DEPENDIENDO DE LA NECESIDAD DEL USUARIO ESTE MENU PRINCIPAL ME DISTRIBUYE A OTROS MENUS
    //ESTOS SE LLAMAN MENUCLIENTE Y OTRO QUE ES EL DE MENUBARBERO//
    //SE AGREGARAN MAS SEGUN NECESITEMOS//
    //MENU PRINCIPAL//
    public void principalMenuValue() {

        String correo = "codigoc13@gmail.com";
        int contrasena = 123456789;
        String administrador;
        int clave;
        boolean resultadoValidar = false;
Icon icono = new ImageIcon (getClass().getResource("/Login/cabello+barba.jpg"));


  JOptionPane.showMessageDialog(null, "Validar Administrador","",JOptionPane.INFORMATION_MESSAGE,icono);

        id = Integer.parseInt(JOptionPane.showInputDialog(null, "\nBIENVENIDO a MENSTYLEBARBER \n"
                + " como deseas ingresar  \n digite 1 si eres el administrador \n"
                + " digite 2 para barbero\n digita 3 para cliente \n digita 4 para salir"," "
                        + "       MENU PRINCIPAL",JOptionPane.INFORMATION_MESSAGE));

        switch (id) {

            case 1:

                JOptionPane.showMessageDialog(null, "Validar Administrador");
                administrador = (JOptionPane.showInputDialog(null, "Ingresa tu correo"));
                clave = Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa tu contraseña"));

                if (administrador.equals(correo) && clave == contrasena) {
                    JOptionPane.showMessageDialog(null, "BIENVENIDO A SU PELUQUERIA " + administrador);

                    Administracion();

                } else {
                    JOptionPane.showMessageDialog(null, "NO ERES EL ADMINISTRADOR \n inicio de secion invalido");
                    principalMenuValue();
                }

                break;
                  
            case 2:

                this.valida = new CrudPersonasValidaciones();

                JOptionPane.showMessageDialog(null, "Validar registro");
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento"));

                resultadoValidar = valida.validarPersona(id, "listaBarberos.txt");
                System.out.println("validar barbero " + resultadoValidar);

                if (resultadoValidar == true) {
                    JOptionPane.showMessageDialog(null, "BIENVENIDO \n ya estas registrado como barbero\n");
                    menuBarbero();
                } else {
                    JOptionPane.showMessageDialog(null, "Debes registrarte, contacta con administracion");
                      principalMenuValue();
                }
                break;

            case 3:
                JOptionPane.showMessageDialog(null, "Validar registro ");

                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento"));
                this.valida = new CrudPersonasValidaciones();
                resultadoValidar = valida.validarPersona(id, "listaClientes.txt");
                System.out.println("validar cliente" + resultadoValidar);
                if (resultadoValidar == true) {
                    //metodo mostrar menu del cliente//  
                    JOptionPane.showMessageDialog(null, "BIENVENIDO \n ya estas registrado como cliente");
                    menuCliente();
                } else {
                    JOptionPane.showMessageDialog(null, "aun no estas registrado \n debes registrarte");
                    Cliente cliente = new Cliente();
                    valida.registroInicial(cliente);
                      principalMenuValue();

                }
                break;

            case 4:
                JOptionPane.showMessageDialog(null, "Programa cerrado con exito");
                throw new AssertionError();
            default:
                JOptionPane.showMessageDialog(null, "opcion no valida");
                principalMenuValue();
        }

    }

    //MENU BARBERO//
    //-Si es barbero: ver sus agendas, editar sus datos
    public void menuBarbero() {

        id = Integer.parseInt(JOptionPane.showInputDialog(null, "\nDigite la opcion que desea \n 1 para ver Agendas \n 2 para editar los datos de las agendas  \n 3 para salir \n","\t              MENU BARBERO",JOptionPane.INFORMATION_MESSAGE));

        switch (id) {
            case 1:

                System.out.println("ver agendas");

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

    //MENU CLIENTE//
    //Si es cliente: Agendar una cita, ver horarios de barberos, eliminar cita, modificar sus datos
    public void menuCliente() {
        id = Integer.parseInt(JOptionPane.showInputDialog(null, " "
            +"  \nDigite la opcion que desea \n "
                + " 1 para agendar una cita  \n 2 para"
                + " ver horario de barberos \n 3 para eliminar una cita \n "
                + "4 para modificar sus datos \n 5 para eliminar tu usuario \n 6 para salir","\t MENU CLIENTE",JOptionPane.INFORMATION_MESSAGE));

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
                System.out.println("modificar sus datos");
                break;
            case 5:
                
                 this.valida = new CrudPersonasValidaciones();
               Cliente cliente = new Cliente();
                valida.Eliminar(cliente, "listaClientes.txt");
               principalMenuValue();
                break;

            case 6:
                System.out.println("te esperamos pronto!");
                break;

            default:
                JOptionPane.showMessageDialog(null, "opcion no valida");
                menuCliente();
        }

    }

    public void Administracion() {
        boolean administrar = false;
        id = Integer.parseInt(JOptionPane.showInputDialog(null, " Digite la opcion que desea \n "
                + "1 para registrar un Barbero \n 2 para ver la lista de barberos "
                + "\n 3 para ver la lista de clientes \n 4 para eliminar un barbero"
                + " \n 5 para editar datos del barbero \n 6 para salir","\tMENU ADMINISTRACION",JOptionPane.INFORMATION_MESSAGE));
        switch (id) {

            case 1:

                this.valida = new CrudPersonasValidaciones();

                JOptionPane.showMessageDialog(null, "Validar registro del barbero");
                id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el documento"));

                administrar = valida.validarPersona(id, "listaBarberos.txt");
                if (administrar == true) {
                    JOptionPane.showMessageDialog(null, "el barbero ya se encuentra registrado \n");
                    Administracion();
                } else {
                    JOptionPane.showMessageDialog(null, "Debes registrar al barbero");
                    this.barbero = new Barbero();

                    valida.registroInicial(barbero);
                    Administracion();
                }

                break;

            case 2:
                JOptionPane.showMessageDialog(null, "lista barberos");
                this.valida = new CrudPersonasValidaciones();
                this.barbero = new Barbero();
                valida.leer(barbero, "listaBarberos.txt");
                Administracion();
                break;
            case 3:

                JOptionPane.showMessageDialog(null, "lista clientes");
                this.valida = new CrudPersonasValidaciones();
                Cliente cliente = new Cliente();
                valida.leer(cliente, "listaClientes.txt");
                Administracion();
                break;

            case 4:

                this.valida = new CrudPersonasValidaciones();
                Barbero barbero = new Barbero();
                valida.Eliminar(barbero, "listaBarberos.txt");
                Administracion();
                break;
            case 5:

                break;

            case 6:
                JOptionPane.showMessageDialog(null, "Te esperamos pronto");

                break;

            default:
                JOptionPane.showMessageDialog(null, "opcion no valida");
                Administracion();
        }

    }

}
