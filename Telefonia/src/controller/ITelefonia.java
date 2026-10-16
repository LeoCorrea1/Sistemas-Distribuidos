
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITelefonia extends Remote {
    public String consultaSessao(String numeroCelular) throws RemoteException;
}
