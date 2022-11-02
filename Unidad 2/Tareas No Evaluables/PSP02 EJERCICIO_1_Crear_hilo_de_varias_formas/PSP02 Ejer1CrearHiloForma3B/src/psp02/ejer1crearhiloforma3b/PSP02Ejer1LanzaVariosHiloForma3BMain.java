package psp02.ejer1crearhiloforma3B;
public class PSP02Ejer1LanzaVariosHiloForma3BMain {
   public static void main(String[] args) {
        int totalHilos =0;
        int i, tiempo;
        
        //recojo el valor de totalHilos de los argumentos pasados al llamar al programa
        if (args.length==0)
            System.out.println("MAL LLAMADO EL PROGRAMA. Se debe pasar el valor de totalHilos");
        else if (args.length>1)
        {
            //error, se pasa mas de un argumento
            System.out.println("MAL LLAMADO EL PROGRAMA. Se debe pasar solo el valor de totalHilos");
        }else{
            try{
                totalHilos=Integer.parseInt(args[0]);
            }catch(NumberFormatException e){
                System.out.println("ERROR en el valor de totalHilos. Debe pasar un valor numerico a totalHilos.");
                
            } 
                
        for(i=1; i<=totalHilos; i++){
          //generamos un tiempo aleatorio para lanzar el hilo  
            tiempo= (int)(Math.random()*6 + 1)*1000;  //en milisegundos
            String texto= "Hilo "+i;
            //creamos un objeto HILO implementado ya con el objeto runneable en la clase hilo
            PSP02Ejer1CrearHiloForma3B  hilo = new PSP02Ejer1CrearHiloForma3B(texto,tiempo);
            
            hilo.start();
        }
    }     
    }   
    
}
