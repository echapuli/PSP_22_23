/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekker1;

/**
 *
 * @author eduardo
 */
public class Dekker1 {

    /**
     * @param args the command line arguments
     */
    //Primer Algoritmo de Dekker. Alternancia estricta. 
    //Garantiza la exclusión mutua, pero su desventaja es que acopla los procesos fuertemente, esto significa que los procesos lentos atrasan 
    //a los procesos rápidos

    public static void main(String[] args) {
        ClaseHilo h1=new ClaseHilo(1);
        ClaseHilo h2=new ClaseHilo(2);
        
        h1.start();
        h2.start();

    }
    
}
