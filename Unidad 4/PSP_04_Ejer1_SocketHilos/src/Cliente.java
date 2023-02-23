
import java.io.*;
import java.net.*;
class Cliente extends Thread {
    static final String HOST = "localhost";
    static final int Puerto=2000;
    Socket skCliente;
    int cont;

    public Cliente( int cont) {         
        this.cont = cont;
    }
    public void run( ) {
        try{
            skCliente = new Socket( HOST , Puerto );
            // Creo los flujos de entrada y salida
            DataInputStream flujo_entrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujo_salida= new DataOutputStream(skCliente.getOutputStream());

            flujo_salida.writeByte(cont);
            // TAREAS QUE REALIZA EL CLIENTE
            String datos=flujo_entrada.readUTF();
            System.out.println(datos);
            skCliente.close();
        } catch( Exception e ) {
             System.out.println( e.getMessage() );
        }
    }
     

  }


