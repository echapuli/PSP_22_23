
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Mchat {
        
        public static void main(String[] args) throws IOException
        {
                String strin;        
                int port=10000;
                byte[] vacio = new byte[0];

                InetAddress grupo = InetAddress.getByName("231.0.0.1");
                if (!grupo.isMulticastAddress()) {
                         System.out.println( "La ip: " + grupo + " no es una ip multicas de la Clase D");
                         System.exit(0);
                }

                try {                         
                        MulticastSocket s = new MulticastSocket(port);
                 
                        s.joinGroup(grupo);
                       
                        System.out.println("Reunida al Grupo Mulicast: 231.0.0.1   Puerto:10000");

                        //creamos un datagrama vacio
                        DatagramPacket dp = new DatagramPacket(vacio, 0,grupo, port);
                          
                        // ChatThread will handle the incoming Data and print it out to STDN output.
                        new ChatThread(s).start();

                        // Leemos desde el teclado y enviamos los datos al grupo.                       
                        BufferedReader entrada = new BufferedReader(
                                       new InputStreamReader(System.in));  


                        System.out.println("Escribe cualquier cosa y RETURN, o salir para finalizar");
                        for(;;)
                        {
                                System.out.print(">");    
                                //Read from the STDN input
                                strin=entrada.readLine();
                               
                                System.out.println("mensaje"+ strin + " Longitud: " + strin.length());
                       
                                if (strin.equals("salir")) break; 
                                //cargamos el mensaje y su longitud
                                dp.setData(strin.getBytes());
                                dp.setLength(strin.length());
                                s.send(dp);
                        }

                        System.out.println("Dejando el grupo...");
                        s.leaveGroup(grupo);
                        s.close();
                } catch (Exception err){
                          System.err.println("ERR: Can not join the group " + err);
                          err.printStackTrace();
                          System.exit(1);
                }
        }
      
}


