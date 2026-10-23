
package ex1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import model.Pessoa;

public class ServerUDP {

    DatagramSocket socket;
    Random gerador = new Random();
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private HashMap<String, Integer> tokens = new HashMap<>();
    private HashMap<String, Long> horarios = new HashMap<>();
    private final long TEMPO_TOKEN = 60000;
        
public ArrayList<Pessoa> getPessoas() {
    return pessoas;
    }   

private void mstrlista() {
    System.out.println("\nUsuarios Cadastrados : (" + pessoas.size() + ") =");
    for (Pessoa p : pessoas) {
        System.out.println(" - " + p.getNome() );
    }
}

private void atenderCliente(DatagramPacket pacote) {
    try {
        String mensagem = new String(
                pacote.getData(), 0, pacote.getLength()
        ).trim();

        String[] dados = mensagem.split(";");

        if (dados.length != 2) {
            String resposta = "ERRO;Formato de mensagem inválido!";
            DatagramPacket retorno = ComunicadorUDP.montaMensagem(
                    resposta,
                    pacote.getAddress().getHostAddress(),
                    pacote.getPort()
            );
            ComunicadorUDP.enviaMensagem(socket, retorno);
            return;
        }
        String nome = dados[0].trim();
        String email = dados[1].trim();
        Pessoa pessoa = new Pessoa(nome, email);
        Pessoa existente = null;

        synchronized (pessoas) {
            for (Pessoa p : pessoas) {
                if (p.getNome() != null && p.getNome().equalsIgnoreCase(nome)) {
                    existente = p;
                    break;
                }
            }
            if (existente == null) {
                pessoas.add(pessoa);
                System.out.println("Pessoa cadastrada: " + pessoa.getNome());
                existente = pessoa;
                mstrlista();
            } else {
                System.out.println("Pessoa ja cadastrada! " );
                String resposta = "ERRO;Pessoa ja cadastrada!";

                DatagramPacket retorno = ComunicadorUDP.montaMensagem(
                        resposta,
                        pacote.getAddress().getHostAddress(),
                        pacote.getPort()
                );

                ComunicadorUDP.enviaMensagem(socket, retorno);
                return;
            }
        }
        String resposta = existente.getNome() + ";" + existente.getEmail();

        DatagramPacket retorno = ComunicadorUDP.montaMensagem(
                resposta,
                pacote.getAddress().getHostAddress(),
                pacote.getPort()
        );
        ComunicadorUDP.enviaMensagem(socket, retorno);

    } catch (Exception e) {
        System.out.println("ERRO: " + e.getMessage());
        e.printStackTrace(); 
    }
}
    public ServerUDP() {
        criaServerSocket();
        if (socket == null) {
            return;
        }
        System.out.println("Servidor ativo a espera do cliente");

        recebeSolicitacoes();
    }

    private void recebeSolicitacoes() {
        try {
            while (true) {
                byte[] dados = new byte[1024];
                DatagramPacket pacote = new DatagramPacket(
                        dados, dados.length
                );
                socket.receive(pacote);
                String mensagem = new String(
                        pacote.getData(), 0, pacote.getLength()
                );
                System.out.println("Solicitacao recebida: " + mensagem);
                if (mensagem.startsWith("PEDIR_TOKEN")) {
                    String[] partes = mensagem.split(";");
                    String nomeCliente = (partes.length > 1) ? partes[1] : pacote.getAddress().getHostAddress();
                    enviaToken(nomeCliente, pacote.getAddress().getHostAddress(), pacote.getPort());
                } else {
                    atenderCliente(pacote);
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao receber solicitacao: " + ex.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

private void enviaToken(String nomeCliente, String endereco, int porta) {
    try {
        long agora = System.currentTimeMillis();

        if (!tokens.containsKey(nomeCliente)
                || agora - horarios.get(nomeCliente) >= TEMPO_TOKEN) {

            int token = gerador.nextInt(100000) + 1;

            tokens.put(nomeCliente, token);
            horarios.put(nomeCliente, agora);
        }

        int token = tokens.get(nomeCliente);

        DatagramPacket pacote = ComunicadorUDP.montaMensagem(
                String.valueOf(token), endereco, porta
        );

        ComunicadorUDP.enviaMensagem(socket, pacote);

        System.out.println("Token enviado para " + nomeCliente + ": " + token);

    } catch (Exception ex) {
        System.out.println("Erro: " + ex.getMessage());
    }
}

    private void criaServerSocket() {
        try {
            socket = new DatagramSocket(1234);
        } catch (Exception ex) {
            System.out.println("Erro ao criar o socket: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new ServerUDP();
    }

    @Override
    public String toString() {
        return "ServerUDP{" + "socket=" + socket
                + ", gerador=" + gerador + '}';
    }
}
