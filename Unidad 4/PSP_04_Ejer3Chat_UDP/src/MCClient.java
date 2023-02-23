
import java.io.*;
import java.net.*;

//Para probarlo, lanzar el MCServer y despues crear tantas
//instancias de este como se quiera, espera a que haga el
//join al grupo tarda unos segundos, y comienza a escribir
//en la instancia del servidor (lo escrito saldrá en todos
//estos clientes creados).
public class MCClient {

    public static void main(String[] args) throws IOException {
        System.out.println("Cliente esperando mensajes desde el MulticastServer");

//Creamos un socket multicast en el puerto 10000:
        MulticastSocket s = new MulticastSocket(10000);

//Configuramos el grupo (IP) a la que nos conectaremos:
        InetAddress group = InetAddress.getByName("231.0.0.1");

//Nos unimos al grupo:
        s.joinGroup(group);

//Leemos los paquetes enviados por el servidor multicast:
        String salida = new String();
        while (!salida.equals("salir")) {
           // Los paquetes enviados son de 256 bytes de maximo
           //(es adaptable)
            byte[] buffer = new byte[256];
            //Creamos el datagrama en el que recibiremos el paquete
            //del socket:
            DatagramPacket dgp = new DatagramPacket(buffer, buffer.length);

            // Recibimos el paquete del socket:
            s.receive(dgp);
/*
            // Adaptamos la información al tamaño de lo que se envió
            //(por si se envió menos de 256):
            byte[] buffer2 = new byte[dgp.getLength()];
            // Copiamos los datos en el nuevo array de tamaño adecuado:
            System.arraycopy(dgp.getData(), 0, buffer2, 0, dgp.getLength());
            //Vemos los datos recibidos por pantalla:
            salida = new String(buffer2);
  */          
            
            //tambien podríamos haber usado directamente
            //para quedarnos con el verdadero tamaño de la cadena
            //ya que el servidor envia en nuestro caso 256 
            salida = (new String(buffer)).trim();
            
            System.out.println("Cadena: "+salida+" ");            
        }
//Salimos del grupo multicast
        s.leaveGroup(group);
// Cerramos el socket:
        s.close();
    }
}
