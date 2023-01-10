package paquete.AccesoServidor;
public class ServidorWeb {
//clase que simula los accesos a un servidor
    private int cuenta;
    public ServidorWeb() {
        cuenta = 0;
    }
    public void  incrementaCuenta() {
        //método sincronizado (monitor)
        System.out.println("hilo " + Thread.currentThread().getName()
                + "----- Entra en Servidor");
        //muestra el hilo que entra en el Servidor.Para probar funcionamiento
        cuenta++;
        //se incrementa la cuenta de accesos
        System.out.println(cuenta + " accesos");
        //muestra el número de accesos. Para probar funcionamiento
    }
}
