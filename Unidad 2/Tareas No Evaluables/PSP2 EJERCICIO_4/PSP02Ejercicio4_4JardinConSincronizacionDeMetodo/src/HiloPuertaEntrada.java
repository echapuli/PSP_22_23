public class HiloPuertaEntrada extends Thread {
    private Jardin j;
    
    public HiloPuertaEntrada(String nombreHilo, Jardin j){
        //asigamos la puerta de entrada al jardin 
        //y un nombre a dicha puerta
        this.j=j;
        this.setName(nombreHilo);
    }
    
    public void run(){
        //para ese jardin invocamos al método para que incremente
        j.entraPersonaAlJardin();
    }
}
