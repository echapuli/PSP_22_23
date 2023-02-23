// MCServer.java
import java.io.*;
import java.net.*;

public class MCServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Arrancando el servidor multicast...\n");
//Creamos el MulticastSocket sin especificar puerto.
        MulticastSocket s = new MulticastSocket();
// Creamos el grupo multicast:
        InetAddress group = InetAddress.getByName("231.0.0.1");
// Creamos un datagrama vacío en principio:
        byte[] vacio = new byte[0];
        DatagramPacket dgp = new DatagramPacket(vacio, 0, group,10000);
//Cogemos los datos a encapsular de la entrada 
//estándar (el teclado)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea;

//El servidor enviará los datos que lea por teclado hasta que
//se escriba "salir":
       do {
            //Leemos de la entrada estandar para evitar bucles infinitos
           System.out.print(">"); 
           linea = br.readLine();
            //Creamos el buffer a enviar
            byte[] buffer = linea.getBytes();//Pasamos los datos al datagrama
            dgp.setData(buffer);
            //Establecemos la longitud
            dgp.setLength(buffer.length);
            // las dos ultimas instrucciones sería equivalente a
            // dgp = new DatagramPacket(buffer, buffer.length, group,10000);
            
            //Y por último enviamos:            
            s.send(dgp);
        } while (!linea.equals("salir"));
// Cerramos el socket.
        s.close();
    }
}