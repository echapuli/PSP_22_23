package psp02ejercicio4_6asincronizaciónservidorweb;


public class ServidorWeb {
        private int contAcceso;
        
        public ServidorWeb(){
            contAcceso=0;
        }
        
        public synchronized void accesoAlServidorWeb(int i){
            //establecemos la sincronización al método
            //muestra el hilo que entra en el método
            System.out.println("hilo: "+ Thread.currentThread().getName()+
                    " ----- Accedo al Servidor Web "+i+" vez");
            //incrementa el número de personas que hay en el jardin
            contAcceso++;
            //mostramos el total de personas que hay
            System.out.println("Total de Accesos: "+contAcceso);
        }        
}
