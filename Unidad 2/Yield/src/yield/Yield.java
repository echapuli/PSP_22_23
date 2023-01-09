/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yield;

/**
 *
 * @author Eduardo
 */
public class Yield {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo h;
        Turno t=new Turno();
        for (int i = 1; i<=3 ; i++) {
            h=new Hilo (i,t);
            h.start();
        }
        
    }
    
}
