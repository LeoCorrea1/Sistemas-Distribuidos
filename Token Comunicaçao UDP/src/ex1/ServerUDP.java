
package ex1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Random;

public class ServerUDP {

    DatagramSocket socket;
    Random gerador = new Random();

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

                if (mensagem.equals("PEDIR_TOKEN")) {
                    enviaToken(
                            pacote.getAddress().getHostAddress(),
                            pacote.getPort()
                    );
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

    private void enviaToken(String endereco, int porta) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            lista.add(i);
        }

        Integer token = lista.get(gerador.nextInt(lista.size()));

        try {
            Thread.sleep(5000);

            DatagramPacket pacote = ComunicadorUDP.montaMensagem(
                    String.valueOf(token), endereco, porta
            );

            ComunicadorUDP.enviaMensagem(socket, pacote);

            System.out.println("Token enviado: " + token);

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
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
