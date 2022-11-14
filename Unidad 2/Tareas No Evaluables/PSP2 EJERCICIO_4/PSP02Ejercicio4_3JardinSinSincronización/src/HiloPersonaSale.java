public class HiloPersonaSale extends Thread {
    private Jardin j;
    
    public HiloPersonaSale(String nombreHilo, Jardin j){
        //asigamos la puerta de salida al jardin 
        //y un nombre a dicha puerta
        this.j=j;
        this.setName(nombreHilo);
    }
    
    public void run(){
        //para ese jardin invocamos al método para que incremente
        j.salePersonaDelJardin();
    }
}
