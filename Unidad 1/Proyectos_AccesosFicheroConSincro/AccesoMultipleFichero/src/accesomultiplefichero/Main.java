/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesomultiplefichero;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.PrintStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.channels.FileLock;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args Argumentos de la línea de comando El primer argumento pasado,
     * será el número de orden de creación del proceso El segundo argumento,
     * será la ruta del fichero
     */
    public static void main(String[] args) {
        int orden = 0;
        String nombreFichero = "";
        File archivo = null;
        RandomAccessFile raf = null;
        FileLock bloqueo = null;
        int valor = 0;
        Boolean existe;
        //Comprobamos si estamos recibiendo argumentos en la línea de comandos
        if (args.length > 0) {
            orden = Integer.parseInt(args[0]);
            //Número de orden de creación de este proceso
        }
        try {
            //Rediregimos salida y error estándar a un fichero
            PrintStream ps = new PrintStream(
                    new BufferedOutputStream(new FileOutputStream(
                            new File("javalog.txt"), true)), true);
            System.setOut(ps);
            System.setErr(ps);
        } catch (Exception e) {
            System.err.println("P" + orden + " No he podido redirigir salidas.");
        }
        //Identificamos el sistema operativo para poder acceder por su ruta al
        //fichero de forma correcta.
        String osName = System.getProperty("os.name");
        if (osName.toUpperCase().contains("WIN")) { //Windows
            if (args.length > 1) {
                nombreFichero = args[1].replace("\\", "\\\\");
            } //Hemos recibido la ruta del fichero en la línea de comandos
            else {
                nombreFichero = "valor.txt";
                //Fichero que se utilizará por defecto
            }
        } else { //GNU/Linux
            if (args.length > 1) {
                nombreFichero = args[1];
            } //Hemos recibido la ruta del fichero en la línea de comandos
            else {
                nombreFichero = "valor.txt";
                //Fichero que se utilizará por defecto
            }
        }
        //Preparamos el acceso al fichero
        archivo = new File(nombreFichero);

        try {
            if (!archivo.exists()) //crea el fichero con el valor 0 en caso de que no exista
            {
                existe = false;
            } else {
                existe = true;
            }

            raf = new RandomAccessFile(archivo, "rw"); //Abrimos el fichero para lectura/escritura y en caso de que no exista lo crea
            //***************
            //Sección crítica
            bloqueo = raf.getChannel().lock();
            //bloqueamos el canal de acceso al fichero. Obtenemos el objeto que
            //representa el bloqueo para después poder liberarlo
            System.out.println("Proceso" + orden
                    + ": ENTRA sección");
            if (existe) { //si el fichero existe incrementamos en uno el valor guardado 
                // Lectura del fichero
                String linea;
                linea = raf.readLine(); //leemos el valor
                valor = Integer.parseInt(linea);
                System.out.println("Proceso" + orden
                        + ": lee valor " + valor);
                valor++;
                raf.seek(0); //volvemos a colocarnos al principio del fichero
                raf.writeBytes(String.valueOf(valor));//escribimos el valor incrementado en 1
                System.out.println("Proceso" + orden
                        + ": escribe valor " + valor);
                System.out.println("Proceso" + orden
                        + ": SALE sección");
            } else {  //si el fichero no existe metemos el valor inicial 1
                System.out.println("Proceso" + orden
                        + ": Crea fichero ");
                raf.writeBytes("1"); //escribimos el valor
                System.out.println("Proceso" + orden
                        + ": escribe valor " + 1);
                System.out.println("Proceso" + orden
                        + ": SALE sección");
            }
            bloqueo.release(); //Liberamos el bloqueo del canal del fichero
            bloqueo = null;
            //Fin sección crítica
            //*******************
        } catch (Exception e) {
            System.err.println("P" + orden + " Error al acceder al fichero");
            System.err.println(e.toString());
        } finally {
            try {
                if (null != bloqueo) {
                    bloqueo.release();
                }
                if (null != raf) {
                    raf.close();
                }
            } catch (Exception e2) {
                System.err.println("P" + orden + " Error al cerrar el fichero");
                System.err.println(e2.toString());
                System.exit(1);  //Si hay error, finalizamos
            }
        }

    }

}
