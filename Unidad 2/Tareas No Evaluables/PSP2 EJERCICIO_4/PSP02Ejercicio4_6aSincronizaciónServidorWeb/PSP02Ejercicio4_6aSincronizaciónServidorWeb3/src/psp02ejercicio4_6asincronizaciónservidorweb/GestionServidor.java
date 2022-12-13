package psp02ejercicio4_6asincronizaciónservidorweb;


public class GestionServidor {

    public static void main(String[] args) {
        //creamos el servidor web
        ServidorWeb sitioWeb = new ServidorWeb();
        
        //Creamos 4 hilos cada uno de los cuales intentará acceder 10 veces al 
        //servidor web        
        for(int i=1; i<=4;i++){
            new HiloTerminal("ClienteTerminal "+i,sitioWeb).start();
        }        
       
    }
}
