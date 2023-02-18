package prueba;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataTimeCliente {
    
     public DataTimeCliente() {  
 }
                    
     public static void visualizarDatagramPacket(DatagramPacket packet,String opcion){
       
            System.out.println("-------------------------CLIENTE--------------------------------");
            System.out.println("Visualizando información del DatagramPacket que se "+opcion);
            System.out.println("informacion paquete: "+new String(packet.getData()));
            System.out.println("longitud paquete: "+packet.getLength());
            System.out.println("packet.getAddress(): "+packet.getAddress());
            System.out.println("packet.getPort(): "+packet.getPort());
            System.out.println("packet.getAddress().getHostAddress(): "+packet.getAddress().getHostAddress());
            System.out.println("packet.getSocketAddress(): "+packet.getSocketAddress());            
            System.out.println("-------------------------------------------------------------------------");  
     }
             
    public static void main(String args[]) {
        byte[] buffer = new byte[256];
        DatagramSocket socket;
        try {
            socket = new DatagramSocket();
            InetAddress address= InetAddress.getByName("localhost");            
            String mensaje="Cliente Solicitando Conexión";//mensaje enviado al server
            System.out.println("Cliente solicitando conexion para enviar el mensaje...."+mensaje);
            
            buffer = mensaje.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,9090);
            
            //mostramos la información del paquete e enviar
            System.out.println("****  Cliente: información del paquete a enviar  *****");
            visualizarDatagramPacket(packet,"ENVIA");
            
            socket.send(packet);
            System.out.println("Enviado el datagrama al servidor");
            
            //creamos el paquete donde el servidor nos enviara la información.
            packet = new DatagramPacket(buffer,buffer.length);
            socket.receive(packet);
            
             //mostramos la información del paquete que se recibe
             System.out.println("\n****  Cliente: información del paquete  recibido  *****");
            visualizarDatagramPacket(packet,"RECIBE");
            
            System.out.println(new String(packet.getData()));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }       
    }
}
