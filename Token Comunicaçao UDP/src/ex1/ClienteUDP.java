
package ex1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class ClienteUDP {

    DatagramSocket socket;
    Scanner scanner = new Scanner(System.in);

    public ClienteUDP() {

    }

    public void criaClientSocket() {
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
