package psp02ejercicio4_6asincronizaciónservidorweb;

public class HiloTerminal extends Thread {

    private ServidorWeb servidor;

    public HiloTerminal(String nombreHilo, ServidorWeb servidor) {
        //asigamos el recurso compartido al atributo servidor
        //y asignamos un nombre al hilo
        this.servidor = servidor;
        this.setName(nombreHilo);
    }

    public void run() {
        //para ese jardin invocamos al método para que incremente
        //sincronismo del monitor esta establecido en el método del seridorWeb
        for (int i = 1; i <= 20; i++) {
            servidor.accesoAlServidorWeb(i);
            yield(); //forzamos a que abandone el procesador despues de acceder una vez 
        }
    }
}
