package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IgerarEmail extends Remote {

    public String gerarEmail(Pessoa pessoa) throws RemoteException;
    
}
