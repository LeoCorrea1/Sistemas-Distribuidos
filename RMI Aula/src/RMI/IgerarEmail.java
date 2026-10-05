/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Guilherme
 */
public interface IgerarEmail extends Remote {

    public String gerarEmail(Pessoa pessoa) throws RemoteException;
    
}
