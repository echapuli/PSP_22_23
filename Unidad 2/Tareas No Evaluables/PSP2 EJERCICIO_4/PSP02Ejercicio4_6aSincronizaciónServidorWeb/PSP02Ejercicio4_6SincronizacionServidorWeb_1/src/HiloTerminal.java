public class HiloTerminal extends Thread {
    
    private ServidorWeb s;
    
    public HiloTerminal(String nombreHilo, ServidorWeb s){
        //asigamos la puerta de entrada al jardin 
        //y un nombre a dicha puerta
        this.s=s;
        this.setName(nombreHilo);
    }
    
    public void run(){
        //para ese jardin invocamos al método para que incremente
        //sincronismo del monitor esta establecido en el método del seridorWeb
         s.accesoAlServidorWeb();    
    }
}
