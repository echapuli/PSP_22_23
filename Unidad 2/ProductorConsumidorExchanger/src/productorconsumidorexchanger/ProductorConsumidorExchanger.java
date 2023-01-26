/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productorconsumidorexchanger;

import java.util.concurrent.Exchanger;

/**
 *
 * @author eduardo
 */
public class ProductorConsumidorExchanger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Exchanger<String> v_exchanger = new Exchanger<String>();
       ProductorConsumidor productor = new ProductorConsumidor("Productor",v_exchanger);
       ProductorConsumidor consumidor = new ProductorConsumidor("Consumidor",v_exchanger);
       productor.start();
       consumidor.start();
    }
    
}
