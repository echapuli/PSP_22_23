
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Example1Sender {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Se requieren 3 argumentos (servidor,puerto, mensaje) en el main");
        } else {
            try {
                System.out.println(args[0] + args[1] + args[2]);
                InetAddress receiverHost = InetAddress.getByName(args[0]);
                int receiverPort = Integer.parseInt(args[1]);
                String message = args[2];
                System.out.println("host: " + receiverHost);
                System.out.println("puerto: " + receiverPort);
                System.out.println("menseja: " + message);
                // instanciamos un datagram socket para enviar los datos
                DatagramSocket mySocket = new DatagramSocket();
                byte[] buffer = message.getBytes();
                DatagramPacket datagram =
                        new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);
                mySocket.send(datagram);
                System.out.println("enviado datagrama");
                mySocket.close();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Example1Sender.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SocketException ex) {
                Logger.getLogger(Example1Sender.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Example1Sender.class.getName()).log(Level.SEVERE, null, ex);
            }
        }// fin else        
    } // fin main
} // fin class