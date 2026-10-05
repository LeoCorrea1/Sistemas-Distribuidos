/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RMI;

import java.rmi.Naming;
import javax.swing.JOptionPane;

public class Client {

    public static void main(String[] args) {
        boolean sair = true;
        
        while(sair == true){
        try {
            

            IgerarEmail c = (IgerarEmail) Naming.lookup("rmi://localhost/ServerString");
            String nome = JOptionPane.showInputDialog("Digite seu nome: ");
            String data = JOptionPane.showInputDialog("Digite sua data de nascimento (00/00/0000): ");
            Pessoa pessoa = new Pessoa(nome, data);
            String email = c.gerarEmail(pessoa);
            JOptionPane.showMessageDialog(null,"Seu email foi cadastrado! : "+ email);
            int resposta = JOptionPane.showConfirmDialog(null,"Deseja Sair?");
            if (resposta == JOptionPane.YES_OPTION) {
                    sair = true;
                }
  
        } catch (Exception e) {
           JOptionPane.showInputDialog("Error: " + e);
        }
        }
    }

}
