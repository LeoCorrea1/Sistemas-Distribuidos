/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import ex1.ComunicadorUDP;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClienteGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClienteGUI.class.getName());

    public ClienteGUI() {
        initComponents();
  
    }
                   DatagramSocket socket;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tokenRecbTxt = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        nomeLb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        emailTxt = new javax.swing.JTextPane();
        enviarBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        nomeTxt = new javax.swing.JTextPane();
        limparbtn = new javax.swing.JButton();
        btnToken = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tokenRecbTxt.setEditable(false);
        tokenRecbTxt.setEnabled(false);
        jScrollPane2.setViewportView(tokenRecbTxt);

        jLabel3.setText("Token Recebido");

        nomeLb.setText("Digite seu nome completo : ");

        jLabel1.setText("Digite Seu Email :");

        jScrollPane4.setViewportView(emailTxt);

        enviarBtn.setText("Enviar pro Servidor");
        enviarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarBtnActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(nomeTxt);

        limparbtn.setText("Limpar");
        limparbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparbtnActionPerformed(evt);
            }
        });

        btnToken.setText("Pedir Token");
        btnToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTokenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(nomeLb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 223, Short.MAX_VALUE)
                .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(enviarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(limparbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLb))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(limparbtn)
                                    .addComponent(enviarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(25, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnToken)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarBtnActionPerformed
    String nome = nomeTxt.getText().trim();
    String email = emailTxt.getText().trim();

    if (nome.isEmpty() || email.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Preencha o nome e o email."
        );
        return;
    }

    try (DatagramSocket socket = new DatagramSocket()) {
        socket.setSoTimeout(10000);

        String mensagem = nome + ";" + email;

        DatagramPacket pedido = ComunicadorUDP.montaMensagem(
                mensagem, "localhost", 1234
        );

        ComunicadorUDP.enviaMensagem(socket, pedido);

        byte[] dados = new byte[1024];
        DatagramPacket resposta = new DatagramPacket(
                dados, dados.length
        );

        socket.receive(resposta);

        String retorno = new String(
                resposta.getData(), 0, resposta.getLength()
        );

        if (retorno.startsWith("ERRO;")) {
            String[] partesErro = retorno.split(";", 2);
            String mensagemErro = (partesErro.length > 1) ? partesErro[1] : "Erro desconhecido";
            
            javax.swing.JOptionPane.showMessageDialog(
                    this, mensagemErro, "Erro no Cadastro", javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        javax.swing.JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");

    } catch (Exception ex) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Erro ao enviar: " + ex.getMessage()
        );
    }
    }//GEN-LAST:event_enviarBtnActionPerformed

    private void limparbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparbtnActionPerformed
        nomeTxt.setText("");
        emailTxt.setText("");
        tokenRecbTxt.setText("");

    }//GEN-LAST:event_limparbtnActionPerformed

    private void btnTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTokenActionPerformed
      String nome = nomeTxt.getText().trim();
    
    if (nome.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Digite seu nome primeiro para pedir o token!");
        return;
    }

    try (DatagramSocket socket = new DatagramSocket()) {
        String mensagem = "QueroToken;" + nome;
        DatagramPacket pedido = ComunicadorUDP.montaMensagem(
                mensagem, "localhost", 1234
        );

        socket.setSoTimeout(10000);
        ComunicadorUDP.enviaMensagem(socket, pedido);

        byte[] dados = new byte[1024];
        DatagramPacket resposta = new DatagramPacket(dados, dados.length);

        socket.receive(resposta);

        String token = new String(
                resposta.getData(), 0, resposta.getLength()
        );

        tokenRecbTxt.setText(token);

    } catch (java.net.SocketTimeoutException ex) {
        tokenRecbTxt.setText("Tempo esgotado: servidor não respondeu.");
    } catch (Exception ex) {
        System.out.println("Erro ao receber token: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnTokenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ClienteGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnToken;
    private javax.swing.JTextPane emailTxt;
    private javax.swing.JButton enviarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton limparbtn;
    private javax.swing.JLabel nomeLb;
    private javax.swing.JTextPane nomeTxt;
    private javax.swing.JTextPane tokenRecbTxt;
    // End of variables declaration//GEN-END:variables
}
