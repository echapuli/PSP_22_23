package psp02.ejer1crearhiloforma1B;
// clase que crea el hilo

import java.util.logging.Level;
import java.util.logging.Logger;

public class PSP02Ejer1CrearHiloForma1B extends Thread{
        String nombre;
        int tiempo;
        
        //metodos
        public PSP02Ejer1CrearHiloForma1B(String nombre, int tiempo){
            super(nombre);
            this.nombre=nombre;
            this.tiempo=tiempo;            
        }
        
        public void run(){
            try {
                System.out.println(nombre+" se va a dormir "+ tiempo+" mseg....");
                     Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP02Ejer1CrearHiloForma1B.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(nombre + " se ha despertado");
             
        }
    }
