package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    
    String HOST_URL = "rmi://localhost/gerarEmail";
    
    public Server(){
        
        try {
            
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            gerarEmail objetoRemoto = new gerarEmail();
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
