package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class gerarEmail extends UnicastRemoteObject implements IgerarEmail  {

    public gerarEmail() throws RemoteException {
    }
    
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    
    public ArrayList<Pessoa> getPessoas() {
    return pessoas;
    }  

    public String gerarEmail(Pessoa pessoa) throws RemoteException {
        String[] nomes = pessoa.getNome().trim().toLowerCase().split("\\s+");

        String primeiro = nomes[0];
        String ultimo = nomes[nomes.length - 1];

        String ano = pessoa.getDataNascimento().substring(6);
        
        String retorno = primeiro + "." + ultimo + "." + ano + "@ufn.edu.br";
        System.out.println("Servidor atendeu e retorna: " + retorno + " , pessoa cadastrada com sucesso");

        return retorno;
    }

    

}
