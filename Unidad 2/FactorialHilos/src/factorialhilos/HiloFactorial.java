/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialhilos;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Eduardo
 */
public class HiloFactorial extends Thread{
    private int valor;
   @Override
    public void run() {
        if (valor==1) {  //caso base
            Valores.setFactorial(1);
            Valores.setCadena("1");
        }else{
            HiloFactorial hilo=new HiloFactorial(valor-1); //crea un nuevo hilo con valor-1
            hilo.start();
            try {
                hilo.join(); //para el hilo actual hasta que termine el hilo 'hilo'
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloFactorial.class.getName()).log(Level.SEVERE, null, ex);
            }
            Valores.setCadena(valor+"*"+Valores.getCadena());
            Valores.setFactorial(Valores.getFactorial()*valor);
            
        }
    }

    public HiloFactorial(int num) {
       valor=num;

    }
    
}
