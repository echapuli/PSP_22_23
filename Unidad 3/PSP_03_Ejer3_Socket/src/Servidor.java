
import java.io.*;
import java.net.*;
class Servidor {
    static final int Puerto = 2000;
    int suma = 0;
    public Servidor() {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escucho el puerto " + Puerto);
            System.out.println("Servidor esperando el mensaje que tiene que mostrar procedente desde el cliente que se conecta");
            for (int nCli = 1; nCli <= 3; nCli++) {
                
                Socket sCliente = skServidor.accept();
                
                InputStream aux = sCliente.getInputStream();
                DataInputStream flujo_entrada = new DataInputStream(aux);
                //muestro en pantalla el flujo de entrada procedente del cliente
                int num =flujo_entrada.readInt();
                if (nCli < 3)
                    System.out.print(num +"+");
                else
                    System.out.print(num +"=");
                suma = suma + num;
                //fin de peticiones del cliente
                
                sCliente.close();
            }
            System.out.println(suma);
            System.out.println("Ya se han atendido los 3 clientes");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Servidor();
    }
}
