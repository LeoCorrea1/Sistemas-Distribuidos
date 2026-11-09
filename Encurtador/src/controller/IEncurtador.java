package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import model.Pessoa;
import model.Url;

public interface IEncurtador extends Remote {
    public boolean cadastrar(Pessoa pessoa, String senha) throws RemoteException;
    public boolean login(String email, String senha) throws RemoteException;
    public String EncurtaUrl(String email, String url) throws RemoteException;
    public boolean existeUsuario(String email) throws RemoteException;
    public HashMap<String, Url> getUrlsPorPessoa(String email) throws RemoteException;
}