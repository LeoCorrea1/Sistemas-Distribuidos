package RMI.CHAT;


import java.rmi.Naming;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ClienteChat {

    public static void main(String[] args) {
        boolean sair = true;

        try {
            IChat chat = (IChat) Naming.lookup("rmi://localhost/Chat");
            
            String apelido = JOptionPane.showInputDialog("Digite seu apelido: ");
            if (apelido == null || apelido.trim().isEmpty()) {
                return; 
            }

            while (sair == true) {
                String mensagem = JOptionPane.showInputDialog("Digite sua mensagem: ");
                
                if (mensagem != null && !mensagem.trim().isEmpty()) {
                    chat.receberMensagem(apelido + ": " + mensagem);
                    
                }
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja Continuar?");

                if (resposta == JOptionPane.YES_OPTION) {
                    sair = true;
                } else {
                    sair = false;
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }
}