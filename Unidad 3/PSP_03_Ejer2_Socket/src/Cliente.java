
import java.io.*;
import java.net.*;

class Cliente {

    static final String HOST = "localhost";
    static final int Puerto = 2000;

    public Cliente() {
        System.out.println("CLIENTE");
        try {
            Socket sCliente = new Socket(HOST, Puerto);
            // … aqui irían las TAREAS QUE REALIZA EL CLIENTE 
            OutputStream aux = sCliente.getOutputStream();
            DataOutputStream flujo_salida = new DataOutputStream(aux);
            int num = (int) (Math.random() * 9) + 1;
            System.out.println("Mensaje a enviar al servidor. Salio un "+num);
            flujo_salida.writeUTF("Mensaje de salida que el cliente envia al servidor, He pensado en el número  " + num);
            
            //fin de las tareas del cliente
            sCliente.close();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Cliente();
    }
}
