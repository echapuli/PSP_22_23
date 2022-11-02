package psp02.ejer1crearhiloforma1a;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PSP02Ejer1CrearHiloForma1A extends Thread{
        String nombre;
        int tiempo;
        
        //metodos
        public PSP02Ejer1CrearHiloForma1A(String nombre, int tiempo){
            super(nombre);
            this.nombre=nombre;
            this.tiempo=tiempo;            
        }
        
        public void run(){
            try {            
                System.out.println(nombre+" se va a dormir "+ tiempo+" mseg....");
                Thread.sleep(tiempo);            
                
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP02Ejer1CrearHiloForma1A.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(nombre + " se ha despertado");
             
        }
    }

