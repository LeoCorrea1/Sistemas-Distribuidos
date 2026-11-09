package controller;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import model.Pessoa;
import model.Url;

public class Encurtador extends UnicastRemoteObject implements IEncurtador {

    private final HashMap<String, Pessoa> usuarios;
    private final HashMap<String, String> senhas;
    private final HashMap<String, HashMap<String, Url>> urlsPorUsuario;
    private final HashMap<String, Url> Urls;

    public Encurtador() throws RemoteException {
        super();
        senhas = new HashMap<>();
        urlsPorUsuario = new HashMap<>();
        usuarios = Pessoa.carregarUsuarios(senhas, urlsPorUsuario);
        Urls = new HashMap<>();
    }

    private String gerarhashSenha(String senha) {
        return Integer.toHexString(senha.hashCode());
    }

    @Override
    public boolean cadastrar(Pessoa pessoa, String senha) throws RemoteException {
        if (pessoa.getEmail() == null || pessoa.getEmail().isEmpty() || usuarios.containsKey(pessoa.getEmail())) {
            System.out.println("Tentativa de cadastro falhou: E-mail já existe ou inválido -> " + pessoa.getEmail());
            return false;
        }
        String senhaHash = gerarhashSenha(senha);
        usuarios.put(pessoa.getEmail(), pessoa);
        senhas.put(pessoa.getEmail(), senhaHash);
        urlsPorUsuario.put(pessoa.getEmail(), new HashMap<>());
        Pessoa.salvar(pessoa, senhaHash);
        System.out.println("Novo usuario cadastrado: " + pessoa.getNome() + " (" + pessoa.getEmail() + ")");
        return true;
    }

    @Override
    public boolean login(String email, String senha) throws RemoteException {
        String senhaHash = gerarhashSenha(senha);
        boolean sucesso = senhas.containsKey(email) && senhas.get(email).equals(senhaHash);
        if (sucesso) {
            System.out.println("Login realizado com sucesso pelo usuario: " + email);
        } else {
            System.out.println("Tentativa de login falhou para o e-mail: " + email);
        }
        return sucesso;
    }

    @Override
    public String EncurtaUrl(String email, String UrlOriginal) throws RemoteException {
        String hash = Integer.toHexString(UrlOriginal.hashCode());
        Url urlObj = new Url(UrlOriginal);
        
        Urls.put(hash, urlObj);
        if (email != null && urlsPorUsuario.containsKey(email)) {
            urlsPorUsuario.get(email).put(hash, urlObj);
        }

        String ipServidor = "localhost";
        try {
            ipServidor = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
        }

        String urlGerada = "https://" + ipServidor + "/" + hash;
        System.out.println("\nURL para encurta solicitada por [" + email + "]");
        System.out.println("URL original: " + UrlOriginal);
        System.out.println("URL rcebida/gerada: " + urlGerada);

        return urlGerada;
    }
    
    @Override
    public boolean existeUsuario(String email) throws RemoteException {
        return usuarios.containsKey(email);
    }

    @Override
    public HashMap<String, Url> getUrlsPorPessoa(String email) throws RemoteException {
        return urlsPorUsuario.getOrDefault(email, new HashMap<>());
    }
}