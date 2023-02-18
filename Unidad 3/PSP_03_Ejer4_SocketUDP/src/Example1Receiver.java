import java.net.*;
import java.io.*;

public class Example1Receiver {
  public static void main(String[] args) {
    if (args.length != 1)
      System.out.println("Se requieren 1 argumento en el main");
    else {
      int port = Integer.parseInt(args[0]);
      final int MAX_LEN = 10;
      // Máxima longitud en byte del datagrama a ser recibido.
      try {
        DatagramSocket  mySocket = new DatagramSocket(port);
        // instanciamos un datagram socket para recibir el dato
        byte[ ] buffer = new byte[MAX_LEN];
        DatagramPacket datagram = new DatagramPacket(buffer, MAX_LEN);
        mySocket.receive(datagram);
        String message = new String(buffer);
        System.out.println(message);
        mySocket.close( );
      } // fin try
      catch (Exception ex) {
        ex.printStackTrace( );
      }
    } // fin else
  } // fin main
} // fin class