
package psp02ejercicio4_12_exchanger;

import java.util.concurrent.Exchanger;

public class PSP02Ejercicio4_12_Exchanger {

    public static void main(String[] args) {
       Exchanger<String> v_exchanger = new Exchanger<String>();
       Amigo amigo1 = new Amigo("amigo1",v_exchanger);
       Amigo amigo2 = new Amigo("amigo2",v_exchanger);
       
       amigo1.start();
       amigo2.start();
    }
}
