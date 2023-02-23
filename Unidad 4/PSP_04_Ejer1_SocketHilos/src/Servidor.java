
import java.io.*;
import java.net.*;
import java.util.concurrent.CountDownLatch;

class Servidor extends Thread {

    Socket skCliente;
    int cont;
    
   
      
    public Servidor(Socket sCliente) {
        skCliente = sCliente;        
    }
  

    public void run() {
        try {
            // Creo los flujos de entrada y salida
            
            DataInputStream flujo_entrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(skCliente.getOutputStream());
            // ATENDER PETICIÓN DEL CLIENTE
            //leo el número de cliente que se conecta
            cont = flujo_entrada.readByte();
            System.out.println("Acepto la conexión del cliente "+cont);
            
            flujo_salida.writeUTF("Se ha conectado el cliente "+cont+" de forma correcta");
             // Se cierra la conexión
             skCliente.close();
            System.out.println("Cliente "+cont +" desconectado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
