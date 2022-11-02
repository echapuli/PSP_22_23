
package psp02.ejer1crearhiloforma3A;
public class PSP02Ejer1LanzaVariosHiloForma3AMain {
     public static void main(String[] args) {
        // TODO code application logic here
        int totalHilos=20;
        int i,tiempo;
                
        for(i=1;i<=totalHilos;i++)
        {
            //genero un tiempo aleatorio entre 1000 y 6000 milisengundos (1 y 6 seg)
            //tiempo = (int) (Math.random()*(max-min))+min
            tiempo=((int) (Math.random()*5000)+1000);
            PSP02Ejer1CrearHiloForma3A hiloRunnable=new PSP02Ejer1CrearHiloForma3A("Hilo"+i,tiempo);
            
            hiloRunnable.start();
        }
        
    }
}
