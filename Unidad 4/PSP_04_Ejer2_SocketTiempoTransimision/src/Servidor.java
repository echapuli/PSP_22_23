
import java.io.*;
import java.net.*;
import java.util.Date;

class Servidor {

    static final int Puerto = 2000;

    public Servidor() {
        try {
            // Inicio el servidor en el puerto
            ServerSocket sServidor = new ServerSocket(Puerto);
            System.out.println("Escucho el puerto " + Puerto);
            // Se conecta un cliente
            Socket sCliente = sServidor.accept(); // Crea objeto
            System.out.println("Cliente conectado");

            // Creo los flujos de salida 
            DataOutputStream flujo_salida = new DataOutputStream(sCliente.getOutputStream());

            // CUERPO DEL ALGORITMO
            long tiempo1 = (new Date()).getTime();
            flujo_salida.writeUTF(Long.toString(tiempo1));

            // Se cierra la conexión
            sCliente.close();
            System.out.println("Cliente desconectado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Servidor();
    }
}
