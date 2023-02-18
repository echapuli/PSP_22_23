package prueba;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import static prueba.DataTimeCliente.visualizarDatagramPacket;

public class TimeServidor {

    static DatagramSocket socket;

    public TimeServidor() {
    }

    public static void visualizarDatagramPacket(DatagramPacket packet, String opcion) {

        System.out.println("-------------------------SERVIDOR--------------------------------");
        System.out.println("Visualizando información del DatagramPacket que se " + opcion);
        System.out.println("informacion paquete: " + new String(packet.getData()));
        System.out.println("longitud paquete: " + packet.getLength());
        System.out.println("packet.getAddress(): " + packet.getAddress());
        System.out.println("packet.getPort(): " + packet.getPort());
        System.out.println("packet.getAddress().getHostAddress(): " + packet.getAddress().getHostAddress());
        System.out.println("packet.getSocketAddress(): " + packet.getSocketAddress());
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        try {
            socket = new DatagramSocket(9090);
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                System.out.println("Escuchando...");
                socket.receive(packet);

                //mostramos la información del paquete e enviar
                System.out.println("****  Servidor: información del paquete recibido  *****");
                visualizarDatagramPacket(packet, "RECIBE");

                //muestro el mensaje que le envia el cliente
                System.out.println("mensaje del cliente: " + new String(buffer));

                //genero cadena  fecha
                String toClient = new Date().toString();

                //cargo el buffer
                buffer = toClient.getBytes();
                System.out.println("mensaje a enviar al cliente...." + new String(buffer));

                InetAddress address = packet.getAddress();  //del paquete recibido cogemos la ip y el puerto              
                int port = packet.getPort();

                //creo el datagrama y lo envio al cliente
                packet = new DatagramPacket(buffer, buffer.length, address, port);

               
                //mostramos la información del paquete e enviar
                System.out.println("\n****  Servidor: información del paquete que se va a enviar  *****");
                visualizarDatagramPacket(packet, "ENVIA");

                //enviando fecha
                socket.send(packet);

            }

        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
