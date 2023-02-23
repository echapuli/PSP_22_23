
import java.net.ServerSocket;
import java.net.Socket;


public class MainServidor {
    public static void main(String[] arg) {
        int cont = 0;
        try {            
            // Inicio el servidor en el puerto
            ServerSocket skServidor = new ServerSocket(2000);
            System.out.println("Escucho el puerto " + 2000);            
            while (true) {
                cont++;
                // Se conecta un cliente
                Socket skCliente = skServidor.accept();
                System.out.println("Cliente conectado");
                // Atiendo al cliente mediante un thread
                new Servidor(skCliente).start();
            }
        } catch (Exception e) {;}
    } 
}
