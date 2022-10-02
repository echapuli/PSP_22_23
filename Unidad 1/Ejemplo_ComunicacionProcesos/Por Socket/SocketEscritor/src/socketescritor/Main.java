/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package socketescritor;

import java.net.*;
import java.io.*;
/**
 *
 * @author Usuario
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket conexion = null; //Socket para aceptar conexiones
        Socket canal = null; //Socket para establecer canal de comunicación
        PrintWriter streamSalida = null;
        try{
           conexion = new ServerSocket( 12345 );
           //Solicitamos al sistema operativo que abra un puerto de escucha
           //de conexiones. El número del puerto es el 12345
        }catch(IOException ex){
            System.err.println("No se ha podido abrir el puerto de escucha.");
            System.err.println(ex.toString());
        }
        if (conexion != null) //Si hemos podido abrir el puerto
            try{
                System.out.println("Proceso escritor, esperando "+
                        "la conexión del proceso lector....");
                canal = conexion.accept();
                //Esperamos hasta que se produzca una conexión al puerto
                //El método ServerSocket.accept(); bloquea (hace dormir)
                //el proceso hasta que se produce una conexión
                streamSalida = new PrintWriter(canal.getOutputStream());
                //Creamos un objeto PrintWriter a partir del Stream de salida
                //del socket o canal de comunicación
                //El objeto PrintWriter, nos permitirá utilizar los métodos
                //print y write para mandar datos al proceso que está
                //escuchando al otro lado del canal.
                System.out.println("Conexión establecida, mandando datos "+
                        "al proceso lector....");
                for (int i=0; i<10; i++){
                    streamSalida.println(i); //Mandamos del 0 al 9
                    streamSalida.flush(); //Forzamos que mande cada número
                }
                System.out.println("Comunicación finalizada.");
            }catch(Exception ex){
                System.err.println("No se ha podido establecer conexión, " +
                    "o no ha ocurrido un fallo al escribir en el canal.");
                 System.err.print(ex.toString());
            }finally{
            //Nos aseguramos de que se cierren los recursos
            //que estamos utilizando
                if (streamSalida != null)//PrintWriter
                    streamSalida.close(); //su cierre no genera excepciones
                if (canal != null) //Socket
                    try{
                        canal.close();
                    }catch (IOException ex) {
                        System.err.println("Error al cerrar el socket.");
                        System.err.print(ex.toString());
                    }
                if (conexion != null) //ServerSocket
                    try{
                    conexion.close();
                    }catch (IOException ex) {
                        System.err.println("Error al cerrar ServerSocket.");
                        System.err.print(ex.toString());
                    }
            }
    }

}
