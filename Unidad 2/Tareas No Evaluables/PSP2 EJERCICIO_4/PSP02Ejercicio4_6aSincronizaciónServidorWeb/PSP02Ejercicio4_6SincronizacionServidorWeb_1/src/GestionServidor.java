
public class GestionServidor {

    public static void main(String[] args) {
        //creamos el jardin ya con 100 personas
        ServidorWeb sitioWeb = new ServidorWeb();
        //podriamos crear varios servidores web 
        //cada uno de ellos contabilizaría sus accesos
        
        for(int i=1; i<=20;i++){
            new HiloTerminal("ClienteTerminal "+i,sitioWeb).start();
        }        
       
    }
}
