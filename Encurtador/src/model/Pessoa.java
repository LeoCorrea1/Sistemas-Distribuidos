package model;

import java.io.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Pessoa implements Serializable {

    private String nome;
    private String dataNascimento;
    private String email;
    private static final String ARQUIVO = "src/model/usuarios.txt";

    public Pessoa(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa(String nome, String dataNascimento, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public Pessoa(String email) {
        this.email = email;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static synchronized void salvar(Pessoa pessoa, String senha) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO, true))) {
            pw.println(pessoa.getEmail() + ";" + senha + ";" + pessoa.getNome() + ";" + pessoa.dataNascimento);
        } catch (Exception e) {}
    }

    public static synchronized HashMap<String, Pessoa> carregarUsuarios(HashMap<String, String> mapaSenhas, HashMap<String, HashMap<String, Url>> mapaUrls) {
        HashMap<String, Pessoa> usuarios = new HashMap<>();
        File file = new File(ARQUIVO);
        
        if (!file.exists()) return usuarios;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 4) {
                    String email = partes[0];
                    String senha = partes[1];
                    String nome = partes[2];
                    String dataNasc = partes[3];
                    Pessoa p = new Pessoa(nome, dataNasc, email);
                    usuarios.put(email, p);
                    mapaSenhas.put(email, senha);
                    mapaUrls.put(email, new HashMap<>());
                }
            }
        } catch (Exception e) {}
        return usuarios;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pessoa outra = (Pessoa) obj;

        return Objects.equals(nome, outra.nome)
                && Objects.equals(dataNascimento, outra.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNascimento);
    }
}