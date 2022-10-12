/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package consumidor;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Vamos a leer de la entrada estándar del proceso (los números del 1 al 9)
        // los datos que se reciben en la salida estándar del proceso.
        int calculo;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader (isr);
        // Obtenemos el stream de lectura de la entrada estándar
        // utilizamos un lector con Buffered, para no perder ningún dato
        String lineaTeclado = null;
        try{
            //leyendo los datos.
            while ((lineaTeclado = bf.readLine())!= null){
                //Vamos leyendo y mulriplicando por 5
                calculo=Integer.parseInt(lineaTeclado)*5;
                System.out.println(lineaTeclado+" X 5 = "+String.valueOf(calculo));
            }
        }catch(IOException ex){
            System.err.println("Se ha producido un error de E/S.");
            System.err.println(ex.toString());
        }
    }

}
