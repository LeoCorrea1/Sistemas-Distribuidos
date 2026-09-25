package Controller;

import Model.Pessoa;
import View.ServidorGUI;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorTCP {

    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private ServidorGUI tela;

    public ServidorTCP(ServidorGUI tela) {
        this.tela = tela;
    }
    
   public ArrayList<Pessoa> getPessoas() {
    return pessoas;
    }   

    public ServidorTCP() {
    }

    public String gerarEmail(Pessoa pessoa) {

        String[] nomes = pessoa.getNome().trim().toLowerCase().split("\\s+");

        String primeiro = nomes[0];
        String ultimo = nomes[nomes.length - 1];

        String ano = pessoa.getDataNascimento().substring(6);

        return primeiro + "." + ultimo + "." + ano + "@ufn.edu.br";
    }

public synchronized void salvarPessoas(ArrayList<Pessoa> pessoas, String nomeDoTxt) {

    try (FileWriter arquivo = new FileWriter(nomeDoTxt)) {

        for (Pessoa pessoa : pessoas) {

            arquivo.write("Nome: " + pessoa.getNome() + "\n");
            arquivo.write("Data Nascimento: " + pessoa.getDataNascimento() + "\n");
            arquivo.write("Email: " + pessoa.getEmail() + "\n");
            arquivo.write("\n");
        }

    } catch (IOException e) {
        System.out.println("Erro ao salvar pessoas: " + e.getMessage());
    }
}

    public void iniciarServidor() {

        try {

            ServerSocket servidor = new ServerSocket(50000);

            tela.log("Servidor iniciado na porta 50000.");

            while (true) {

                Socket cliente = servidor.accept();

                tela.log("Cliente conectado.");

                new Thread(() -> atenderCliente(cliente)).start();
            }

        } catch (Exception e) {

            tela.log("Erro: " + e.getMessage());
        }
    }

    private void atenderCliente(Socket cliente) {

        try {

            ObjectInputStream entrada =
                    new ObjectInputStream(cliente.getInputStream());

            Pessoa pessoa = (Pessoa) entrada.readObject();

            Pessoa existente = null;

            synchronized (pessoas) {

                for (Pessoa p : pessoas) {

                    if (p.getNome().equalsIgnoreCase(pessoa.getNome())
                            && p.getDataNascimento().equals(pessoa.getDataNascimento())) {

                        existente = p;
                        break;
                    }
                }

                if (existente == null) {

                    pessoa.setEmail(gerarEmail(pessoa));

                    pessoas.add(pessoa);

                    tela.adicionarTabela(pessoa);

                    tela.log("Pessoa cadastrada: " + pessoa.getNome());

                    existente = pessoa;

                } else {

                    tela.log("Pessoa já cadastrada: " + pessoa.getNome());
                }
            }

            ObjectOutputStream saida =
                    new ObjectOutputStream(cliente.getOutputStream());

            saida.writeObject(existente);
            saida.flush();
            cliente.close();

        } catch (Exception e) {

            tela.log("Erro: " + e.getMessage());
        }
    }
}