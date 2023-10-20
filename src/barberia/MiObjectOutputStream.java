
package barberia;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

//ESTA CLASE ES PARA CREAR LOS ARCHIVOS SIN CABECERA, SU FUNCIONALIDAD SE EJECUTA EN LA CLASE DE ARCHIVOS//

public class MiObjectOutputStream extends ObjectOutputStream {
    
    public void writeStreamHeader()throws IOException{
    }
    public MiObjectOutputStream ()throws IOException {
        super();
    }
     public MiObjectOutputStream (OutputStream out)throws IOException {
        super(out); 
    }
}
