/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package psp02.ejer1crearhiloforma3A;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J
 */
public class PSP02Ejer1CrearHiloForma3A implements Runnable{
    String nombre;
    int tiempo;
    Thread hiloaux;
    public PSP02Ejer1CrearHiloForma3A(String nombre,int tiempo){
        this.nombre=nombre;
        this.tiempo=tiempo;
        
    }
    public void start(){
        hiloaux=new Thread(this);
        hiloaux.start();
    }
    
    public void run(){
        System.out.println(nombre+" se va a dormir "+tiempo+" mseg ...");
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP02Ejer1CrearHiloForma3A.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre+"ha despertado");
    }
}