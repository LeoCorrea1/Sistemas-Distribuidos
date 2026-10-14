package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import RMI.CHAT.Chat;

public class Server {
    
    
    //String HOST_URL = "rmi://localhost/gerarEmail";
    String HOST_URL = "rmi://localhost/Chat";
    
    public Server(){
        
        try {
            
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            //gerarEmail objetoRemoto = new gerarEmail();
            Chat objetoRemoto = new Chat();
            Naming.bind(HOST_URL, objetoRemoto);
            System.out.println("Servidor online e no aguardo....");
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    

    public static void main(String args[]) {
        new Server();
    }
}
