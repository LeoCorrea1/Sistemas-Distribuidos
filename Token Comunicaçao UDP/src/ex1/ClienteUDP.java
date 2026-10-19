
package ex1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class ClienteUDP {

    DatagramSocket socket;
    Scanner scanner = new Scanner(System.in);

    public ClienteUDP() {
        criaClientSocket();

        if (socket == null) {
            return;
        }

        System.out.println("Deseja pedir token? 1 para sim, 2 para nao");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            try {
                DatagramPacket pedido = ComunicadorUDP.montaMensagem(
                        "PEDIR_TOKEN", "localhost", 1234
                );

                ComunicadorUDP.enviaMensagem(socket, pedido);

                byte[] dados = new byte[1024];
                DatagramPacket resposta = new DatagramPacket(
                        dados, dados.length
                );

                socket.setSoTimeout(10000);
                socket.receive(resposta);

                String token = new String(
                        resposta.getData(), 0, resposta.getLength()
                );

                System.out.println("Token recebido: " + token);

            } catch (Exception ex) {
                System.out.println("Erro ao receber token: " + ex.getMessage());
            }
        }

        socket.close();
        scanner.close();
    }

    private void criaClientSocket() {
        try {
            socket = new DatagramSocket();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClienteUDP enviador = new ClienteUDP();
    }
}
