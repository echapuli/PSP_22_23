
import java.io.*;
import java.net.*;
class Servidor {
    static final int Puerto = 2000;
    public Servidor() {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escucho el puerto " + Puerto);
            for (int nCli = 0; nCli < 3; nCli++) {
                System.out.println("Servidor esperando el mensaje que tiene que mostrar procedente desde el cliente que se conecta");
                Socket sCliente = skServidor.accept();
                
                //peticiones del cliente
                System.out.println("Sirvo al cliente " + nCli);
                InputStream aux = sCliente.getInputStream();
                DataInputStream flujo_entrada = new DataInputStream(aux);
                //muestro en pantalla el flujo de entrada procedente del cliente
                System.out.println(flujo_entrada.readUTF());
                //fin de peticiones del cliente
                
                sCliente.close();
            }

            System.out.println("Ya se han atendido los 3 clientes");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Servidor();
    }
}
