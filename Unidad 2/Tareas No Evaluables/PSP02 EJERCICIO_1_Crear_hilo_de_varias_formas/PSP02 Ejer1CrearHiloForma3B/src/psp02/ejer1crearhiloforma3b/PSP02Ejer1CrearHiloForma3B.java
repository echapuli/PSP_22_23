package psp02.ejer1crearhiloforma3B;
// clase que crea el hilo

import java.util.logging.Level;
import java.util.logging.Logger;

public class PSP02Ejer1CrearHiloForma3B implements Runnable{
        String nombre;
        int tiempo;
        Thread hiloaux;        
        
        //metodos
        public PSP02Ejer1CrearHiloForma3B(String nombre, int tiempo){
            this.nombre=nombre;
            this.tiempo=tiempo;            
        }
        
        public void start(){
            hiloaux = new Thread(this);
            hiloaux.start();
        }
        
        public void run(){
            try {
                System.out.println(nombre+" se va a dormir "+ tiempo+" mseg....");
                     Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP02Ejer1CrearHiloForma3B.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(nombre + " se ha despertado");
             
        }
    }
