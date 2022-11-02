package psp02.ejer1crearhiloforma2A;
public class PSP02Ejer1LanzaVariosHiloForma2AMain {
    public static void main(String[] args) {
        int totalHilos =20;
        int i, tiempo;
                
        for(i=1; i<=totalHilos; i++){
          //generamos un tiempo aleatorio para lanzar el hilo  
          tiempo= (int)(Math.random()*6 + 1)*1000;  //en milisegundos
          String texto= "Hilo "+i;
          PSP02Ejer1CrearHiloForma2A  hiloRunneable = 
new PSP02Ejer1CrearHiloForma2A(texto,tiempo);
          Thread hilo = new Thread(hiloRunneable);
          hilo.start();
        }
    }     
    
}
