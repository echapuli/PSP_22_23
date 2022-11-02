package psp02.ejer1crearhiloforma1a;

// clase principal que lanza varios hilos
public class PSP02Ejer1LanzaVariosHiloForma1AMain {
    public static void main(String[] args) {
        int totalHilos =20;
        int i, tiempo;
                
        for(i=1; i<=totalHilos; i++){
          //generamos un tiempo aleatorio para lanzar el hilo  
            tiempo= (int)(Math.random()*6 + 1)*1000;  //en milisegundos
            String texto= "Hilo "+i;
            PSP02Ejer1CrearHiloForma1A  hilo = new PSP02Ejer1CrearHiloForma1A(texto,tiempo);
            hilo.start();
        }
    }         
}

