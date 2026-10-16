package controller;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    String HOST_URL = "rmi://localhost/Telefonia";

    public Servidor() {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Telefonia objetoRemoto = new Telefonia();
            Naming.rebind(HOST_URL, objetoRemoto);
            System.out.println("Servidor pronto para atender clientes....");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        new Servidor();
    }
}