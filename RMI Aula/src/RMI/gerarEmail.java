package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class gerarEmail extends UnicastRemoteObject implements IgerarEmail {

    public gerarEmail() throws RemoteException {
        super();
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
        
        synchronized (pessoas) {
            boolean existe = false;

            for (Pessoa p : pessoas) {
                if (p.getNome().equalsIgnoreCase(pessoa.getNome()) && p.getDataNascimento().equals(pessoa.getDataNascimento())) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                pessoa.setEmail(retorno);
                pessoas.add(pessoa);
                System.out.println("Servidor atendeu e retorna: " + retorno + " , pessoa cadastrada com sucesso");
            } else {
                System.out.println("Pessoa ja cadastrada: " + pessoa.getNome());
                return "cadastrado";
            }
        }
        
        System.out.println("LISTA ATUAL DE PESSOAS (Total: " + pessoas.size() + "):");
        for(int i = 0; i < pessoas.size(); i++){
            System.out.println("- " + pessoas.get(i).getNome()); 
        }

        return retorno;
    }
}