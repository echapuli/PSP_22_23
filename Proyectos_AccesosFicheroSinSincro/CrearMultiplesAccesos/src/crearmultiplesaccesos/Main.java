/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package crearmultiplesaccesos;

import java.io.*;
/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Process nuevoProceso; //Definimos una variable de tipo Process
        String nombreFichero;
        try {
            //Redirigimos salida estándar y de error a un fichero
            PrintStream ps = new PrintStream(
                    new BufferedOutputStream(new FileOutputStream(
                            new File("javalog.txt"), true)), true);
            System.setOut(ps);
            System.setErr(ps);
        } catch (Exception e) {
            System.err.println("Error al redirigir las salidas");
            System.err.println(e.toString());
        }

        //Identificamos el sistema operativo para poder acceder por su ruta al
        //fichero de forma correcta.
        String osName = System.getProperty("os.name");
        if (osName.toUpperCase().contains("WIN")) { //Windows
            if (args.length > 0) {
                nombreFichero = args[0].replace("\\", "\\\\");
            } //Hemos recibido la ruta del fichero en la línea de comandos
            else {
                nombreFichero = "valor.txt";
                //Fichero que se utilizará por defecto
            }
        } else { //GNU/Linux
            if (args.length > 0) {
                nombreFichero = args[0];
            } //Hemos recibido la ruta del fichero en la línea de comandos
            else {
                nombreFichero = "." + File.separator + "valor.txt";
                //Fichero que se utilizará por defecto
            }
        }

        //Creamos un grupo de procesos que accederán al mismo fichero
        try {
            for (int i = 1; i <= 25; i++) {
                nuevoProceso = Runtime.getRuntime().exec("java -jar "+
                 "AccesoMultipleFichero.jar " + i + " " + nombreFichero);
                //Creamos el nuevo proceso y le indicamos el número de orden y
                //el fichero que debe utilizar.
                System.out.println("Creado el proceso " + i);
                //Mostramos en consola que hemos creado otro proceso               
            }
        } catch (SecurityException ex) {
            System.err.println("Ha ocurrido un error de Seguridad."
                    + "No se ha podido crear el proceso por falta de permisos.");
        } catch (Exception ex) {
            System.err.println("Ha ocurrido un error, descripción: "
                    + ex.toString());
        }
    }

}
