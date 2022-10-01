/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesomultiplefichero;

import java.io.*;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args Argumentos de la línea de comando
     * El primer argumento pasado, será el número de orden de creación del proceso
     * El segundo argumento, será la ruta del fichero
     */
    public static void main(String[] args) {
      int orden = 0;
      String nombreFichero = "";
      File archivo = null;
      FileReader leer = null;
      BufferedReader br = null;
      FileWriter escribir = null;
      PrintWriter pw = null;
      int valor = 0;
      //Comprobamos si estamos recibiendo argumentos en la línea de comandos
      if (args.length > 0)
          orden = Integer.parseInt(args[0]);
          //Número de orden de creación de este proceso
      try{
          PrintStream ps = new PrintStream(
                             new BufferedOutputStream(new FileOutputStream(
                             new File("."+File.separator+"javalog.txt"),true)), true);
            System.setOut(ps);
            System.setErr(ps);
      }catch(Exception e){
            System.err.println("P"+orden+" No he podido redirigir salidas.");
      }
      //Identificamos el sistema operativo para poder acceder por su ruta al
      //fichero de forma correcta.
      String osName = System.getProperty("os.name");
      if (osName.toUpperCase().contains("WIN")){ //Windows
        if (args.length > 1)
            nombreFichero = args[1].replace("\\", "\\\\");
            //Hemos recibido la ruta del fichero en la línea de comandos
        else{
            nombreFichero = "."+File.separator+"valor.txt";
            //Fichero que se utilizará por defecto
          }
      }else{ //GNU/Linux
          if (args.length > 1)
            nombreFichero = args[1];
          //Hemos recibido la ruta del fichero en la línea de comandos
          else{
               nombreFichero = "."+File.separator+"valor.txt";
               //Fichero que se utilizará por defecto
        }
      }
      archivo = new File(nombreFichero);
      //Preparamos el acceso al fichero
      if (!archivo.exists()){
          //Si no existe el fichero
        try {
            archivo.createNewFile(); //Lo creamos
            escribir = new FileWriter(nombreFichero);
            pw = new PrintWriter(escribir);
            pw.println(String.valueOf(0)); //Escribimos el valor 0 en el fichero
            System.out.println("Proceso"+ orden + ": Creando el fichero.");
        }catch(Exception e){
            System.err.println("P"+orden+" Error al crear el fichero");            
        }finally{
            try{
            // Nos asegurarnos que se cierra el fichero.
                if (null != escribir)
                    escribir.close();
               } catch (Exception e2) {
                    System.err.println("Error al cerrar el fichero");
                    System.exit(1); //Si hay error, finalizamos
               }
        }
       }
      //Leemos de fichero
      try{
         leer = new FileReader(archivo);
         br = new BufferedReader(leer);
         // Lectura del fichero
         String linea;
         linea = br.readLine();
         valor = Integer.parseInt(linea);
         System.out.println("Proceso"+ orden +
                 ": Valor leído del fichero: " + valor);
      }catch(Exception e){
         System.err.println("P"+orden+" Error al leer del fichero");
      }finally{
         // En el finally cerramos el escribir, para asegurarnos
         // que se cierra tanto si todo va bien como si salta
         // una excepcion.
         try{
            if( null != leer ){
               leer.close();
            }
         }catch (Exception e2){
            System.err.println("P"+orden+" Error al cerrar el fichero");
            System.exit(1);  //Si hay error, finalizamos
         }         
      }
      //Incrementamos
      valor ++;

      //Escribimos en fichero
      try {
            escribir = new FileWriter(nombreFichero);
            pw = new PrintWriter(escribir);           
            pw.println(String.valueOf(valor));
            System.out.println("Proceso"+ orden +
                 ": Valor escrito en el fichero: " + valor);
      }
      catch(Exception e){
         System.err.println("P"+orden+" Error al escribir en el fichero");
      }finally{
        try{
           // Nos asegurarnos de que se cierra el fichero.
           if (null != escribir)
              escribir.close();
           } catch (Exception e2) {
              System.err.println("P"+orden+" Error al cerrar el fichero");
              System.exit(1);  //Si hay error, finalizamos
           }         
      }
    }

}
