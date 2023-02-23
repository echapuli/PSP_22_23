// mchat.java : multicast chat
// Synopsis: java mchat mip port

import java.io.*;
import java.net.*;

class ChatThread extends Thread {

    private MulticastSocket msocket;
    private DatagramPacket recv;

    public ChatThread(MulticastSocket msock) {
        msocket = msock;
    }

    public void run() {

        String mensaje;
        try {
            for (;;) {
                byte[] buf = new byte[1000];
                recv = new DatagramPacket(buf, buf.length);
                msocket.receive(recv);
                           //para coger el tamaño justo del mensaje

                mensaje = (new String(buf)).trim();

                System.out.println("\n\nRecibido: \"" + mensaje + "\"\nMensaje Longitud: " + mensaje.length());
            }

        } catch (IOException e) {
            System.out.println("Cerrando el hilo");
            //e.printStackTrace();
        } finally {
            msocket.close();
        }
    }

}
