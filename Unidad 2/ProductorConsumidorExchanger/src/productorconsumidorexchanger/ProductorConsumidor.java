/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productorconsumidorexchanger;

import java.util.concurrent.Exchanger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo
 */
public class ProductorConsumidor extends Thread {

    private String nombre;
    private Exchanger<String> comunicacion;
    private final String[] productos = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};

    public ProductorConsumidor(String nombre, Exchanger<String> comunicacion) {
        this.nombre = nombre;
        this.comunicacion = comunicacion;
    }

    @Override
    public void run() {
        String producto;
        String mensaje = "1";
        if (nombre.equals("Productor")) { //Productor
            while (mensaje.equals("1")) {
                producto = productos[(int) (10 * Math.random())];
                try {
                    mensaje = comunicacion.exchange(producto);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProductorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(nombre + " produjo " + producto);
            }
        } else { //consumidor
            for (int i = 0; i < 50; i++) {
                try {
                    mensaje = comunicacion.exchange("1");
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProductorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(nombre + " consumio " + mensaje);
            }
            try {
                mensaje = comunicacion.exchange("0");
            } catch (InterruptedException ex) {
                Logger.getLogger(ProductorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(nombre + " consumio " + mensaje);
        }
    }

}
