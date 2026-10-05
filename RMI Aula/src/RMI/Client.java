package RMI;

import java.rmi.Naming;
import javax.swing.JOptionPane;

public class Client {

    public static void main(String[] args) {
        boolean sair = true;
        
        while(sair == true){
        try {
            //CONEXAO
            IgerarEmail c = (IgerarEmail) Naming.lookup("rmi://localhost/gerarEmail");
            
            String nome = JOptionPane.showInputDialog("Digite seu nome: ");
            String data = JOptionPane.showInputDialog("Digite sua data de nascimento (00/00/0000): ");
            
            Pessoa pessoa = new Pessoa(nome, data);
            String resultado = c.gerarEmail(pessoa);
            
            if (resultado.equals("cadastrado")) {
                JOptionPane.showMessageDialog(null, "Pessoa Ja Cadastrada!");
            } else {
                JOptionPane.showMessageDialog(null, "Seu email foi cadastrado! : " + resultado);
            }
            
            int resposta = JOptionPane.showConfirmDialog(null,"Deseja Continuar?");
            
            if (resposta == JOptionPane.YES_OPTION) {
                    sair = true;
                }
            else{
                sair = false;
            }
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        }
    }
}