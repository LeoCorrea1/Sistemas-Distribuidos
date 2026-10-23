/**
 * pacote que coordena o frame do chat no que se  refere a interface gráfica e comunicação com o usuário
 */
package chatMulticast;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import util.ComunicadorUDP;
import javax.swing.DefaultListModel;

/**
 *
 * @author Turma Sistemas Distribuídos 2019-2
 */
public class JFrame_chatMulticast extends javax.swing.JFrame {

    public JFrame_chatMulticast() {
        initComponents();

        mdl.addElement("Todos");
        jList_usuariosOnline.setModel(mdl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Chat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Mensagens = new javax.swing.JTextArea();
        jTextField_textoDeEnvio = new javax.swing.JTextField();
        jButton_Enviar = new javax.swing.JButton();
        jLabel_Porta = new javax.swing.JLabel();
        jTextField_Porta = new javax.swing.JTextField();
        jLabel_ServidorIP = new javax.swing.JLabel();
        jButton_Sair = new javax.swing.JButton();
        jTextField_GrupoIP = new javax.swing.JTextField();
        jLabel_Nick = new javax.swing.JLabel();
        jTextField_Nick = new javax.swing.JTextField();
        jButton_Conectar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_usuariosOnline = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea_Mensagens.setEditable(false);
        jTextArea_Mensagens.setColumns(20);
        jTextArea_Mensagens.setRows(5);
        jTextArea_Mensagens.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea_Mensagens);

        jTextField_textoDeEnvio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_textoDeEnvioKeyPressed(evt);
            }
        });

        jButton_Enviar.setText("Enviar");
        jButton_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnviarActionPerformed(evt);
            }
        });

        jLabel_Porta.setText("Porta");

        jTextField_Porta.setText("3456");

        jLabel_ServidorIP.setText("Grupo IP:");

        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });

        jTextField_GrupoIP.setText("239.1.2.3");

        jLabel_Nick.setText("Nick:");

        jButton_Conectar.setText("Conectar");
        jButton_Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConectarActionPerformed(evt);
            }
        });

        jList_usuariosOnline.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Todos" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList_usuariosOnline);

        jLabel1.setText("CHAT");

        jLabel2.setText("Usuarios");

        javax.swing.GroupLayout jPanel_ChatLayout = new javax.swing.GroupLayout(jPanel_Chat);
        jPanel_Chat.setLayout(jPanel_ChatLayout);
        jPanel_ChatLayout.setHorizontalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel_ServidorIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_GrupoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Porta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Porta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_Nick)
                .addGap(18, 18, 18)
                .addComponent(jTextField_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton_Conectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton_Sair)
                .addGap(2, 2, 2))
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addComponent(jTextField_textoDeEnvio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Enviar))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ChatLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(249, 249, 249))
        );
        jPanel_ChatLayout.setVerticalGroup(
            jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ChatLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ChatLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ChatLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_textoDeEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Enviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ServidorIP)
                    .addComponent(jTextField_GrupoIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Porta)
                    .addComponent(jTextField_Porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Nick)
                    .addComponent(jTextField_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Conectar)
                    .addComponent(jButton_Sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_Chat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void atualizarUsuarios() {
        jList_usuariosOnline.setModel(mdl);
    }
    
   private void adicionarUsuario(String nick) {
    if (nick.isEmpty() || nick.equals(jTextField_Nick.getText().trim())) {
        return;
    }

    if (!nicks.contains(nick)) {
        nicks.add(nick);
        mdl.addElement(nick);
    }
}
    
    /**
     * classe interna que garante que o processo de ler/ouvir mensagens seja executado concomitantemente
     */
class ThreadReceptora extends Thread {

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                DatagramPacket pacote = ComunicadorUDP.recebeMensagem(socket);
                String msg = new String(pacote.getData(), 0, pacote.getLength()).trim();
                String meuNick = jTextField_Nick.getText().trim();

                if (msg.startsWith("ENTROU:")) {
                    String nick = msg.substring(7).trim();

                    adicionarUsuario(nick);

                    if (!nick.equals(meuNick)) {
                        jTextArea_Mensagens.append(
                            nick + " entrou na sala\n"
                        );

                        String resposta = "USUARIO:" + meuNick;

                        DatagramPacket pacoteResposta = ComunicadorUDP.montaMensagem(
                            resposta,
                            jTextField_GrupoIP.getText(),
                            Integer.parseInt(jTextField_Porta.getText())
                        );

                        socket.send(pacoteResposta);
                    }

                } else if (msg.startsWith("USUARIO:")) {
                    String nick = msg.substring(8).trim();

                    adicionarUsuario(nick);

                } else if (msg.startsWith("PV:")) {
                    String[] partes = msg.split(":", 4);

                    if (partes.length == 4
                            && partes[1].trim().equals(meuNick)) {
                        jTextArea_Mensagens.append(
                            "(Recebido PV do " + partes[2] + "): "
                            + partes[3] + "\n"
                        );
                    }

                } else if (msg.contains("saiu da sala")) {
                    String nick = msg.split(" saiu da sala")[0].trim();

                    nicks.remove(nick);
                    mdl.removeElement(nick);

                    jTextArea_Mensagens.append(
                        nick + " saiu da sala\n"
                    );

                } else {
                    jTextArea_Mensagens.append(msg + "\n");
                }

            } catch (IOException e) {
                if (!socket.isClosed()) {
                    e.printStackTrace();
                }

                break;
            }
        }
    }
}
    /**
     * método privado que avisa que um computador saiu do grupo e encerra a conexão
     * @throws IOException
     * @throws NumberFormatException
     * @throws NullPointerException 
     */                                             
    private void sairDoSistema() throws IOException, NumberFormatException, NullPointerException {
        try {
            String msg = jTextField_Nick.getText() + " saiu da sala";
            DatagramPacket pacote = ComunicadorUDP.montaMensagem(msg, jTextField_GrupoIP.getText(), Integer.parseInt(jTextField_Porta.getText()));
            socket.send(pacote);

        } catch (IOException | NumberFormatException | NullPointerException e) {
            if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
                JOptionPane.showMessageDialog(this, "Você está saindo sem ter se conectado");
            } else {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } finally {
            System.exit(0);
        }
    }

    /**
     * método privado que realiza a conexão do computador em um grupo multicast,
     * tendo como referência endereço virtual do grupo e a porta do socket. O processo de escuta/leitura
     * é circundado por thread de leitura
     * @param evt contém o evento recebido pelo tratador
     */
    private void jButton_ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConectarActionPerformed
    try {
        String meuNick = jTextField_Nick.getText().trim();

        if (meuNick.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha seu nick");
            return;
        }

        grupo = InetAddress.getByName(
            jTextField_GrupoIP.getText().trim()
        );

        socket = new MulticastSocket(
            Integer.parseInt(jTextField_Porta.getText().trim())
        );

        socket.joinGroup(grupo);

        ThreadReceptora tR = new ThreadReceptora();
        tR.start();

        jButton_Conectar.setEnabled(false);
        jTextField_Nick.setEnabled(false);
        jTextField_GrupoIP.setEnabled(false);
        jTextField_Porta.setEnabled(false);

        String msg = "ENTROU:" + meuNick;

        DatagramPacket pacote = ComunicadorUDP.montaMensagem(
            msg,
            jTextField_GrupoIP.getText(),
            Integer.parseInt(jTextField_Porta.getText())
        );

        socket.send(pacote);

        jTextArea_Mensagens.append(
            meuNick + " entrou na sala\n"
        );

        JOptionPane.showMessageDialog(
            this,
            "Conectado com sucesso!"
        );

    } catch (HeadlessException | IOException | NumberFormatException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_jButton_ConectarActionPerformed
   
    /**
     * método privado que captura a mensagem escrita na caixa de texto mais o apelido da caixa de texto nick
     * monta a mensagem e a envia ao grupo
     * @throws IOException
     * @throws NumberFormatException
     * @throws NullPointerException 
     */

    private void enviarMsg() throws IOException, NumberFormatException, NullPointerException {
        String texto = jTextField_textoDeEnvio.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escreva algo");
            return;
        }

        if (socket == null || socket.isClosed()) {
            JOptionPane.showMessageDialog(this, "Conecte primeiro");
            return;
        }

        String nick = jTextField_Nick.getText().trim();
        String destino = jList_usuariosOnline.getSelectedValue();
        int porta = Integer.parseInt(jTextField_Porta.getText().trim());

        if (destino == null || destino.equals("Todos")) {
            String msg = nick + ": " + texto;

            DatagramPacket pacote = ComunicadorUDP.montaMensagem(
                msg,
                jTextField_GrupoIP.getText(),
                porta
            );

            socket.send(pacote);

        } else {
            if (!nicks.contains(destino)) {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado");
                return;
            }

            String msg = "PV:" + destino + ":" + nick + ":" + texto;

            DatagramPacket pacote = ComunicadorUDP.montaMensagem(
                msg,
                jTextField_GrupoIP.getText(),
                porta
            );
            socket.send(pacote);

            jTextArea_Mensagens.append(
                "(PV para " + destino + "): " + texto + "\n"
            );
        }

        jTextField_textoDeEnvio.setText("");
        jTextField_textoDeEnvio.requestFocus();
    }

    /**
     * método privado que trata o envio de mensagens escritas na caixa de texto de mensagens 
     * @param evt contém o evento recebido pelo tratador
     */
    private void jButton_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnviarActionPerformed
        try {
            this.enviarMsg();
            jTextField_textoDeEnvio.requestFocus();
        } catch (IOException | NumberFormatException | NullPointerException e) {

        }
    }//GEN-LAST:event_jButton_EnviarActionPerformed

    /**
     * método privado que trata o evento do botão sair, ou seja, finaliza o sistema
     * @param evt contém o evento recebido pelo tratador
     */
    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        try {
            this.sairDoSistema();
        } catch (IOException | NumberFormatException | NullPointerException e) {

        }
    }//GEN-LAST:event_jButton_SairActionPerformed

    /**
     * método privado que trata o pressionamento das teclas Enter ou Esc quando o foco estiver na caixa de envio de texto
     * @param evt contém o evento recebido pelo tratador
     */
    private void jTextField_textoDeEnvioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_textoDeEnvioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                this.enviarMsg();
            } catch (IOException | NumberFormatException | NullPointerException e) {

            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            try {
                this.sairDoSistema();
            } catch (IOException | NumberFormatException | NullPointerException e) {

            }
        }
    }//GEN-LAST:event_jTextField_textoDeEnvioKeyPressed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame_chatMulticast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_chatMulticast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_chatMulticast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_chatMulticast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_chatMulticast().setVisible(true);
            }
        });
    }

    InetAddress grupo;
    MulticastSocket socket;
    LinkedList<String> nicks = new LinkedList<>();
    DefaultListModel<String> mdl = new DefaultListModel<>();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Conectar;
    private javax.swing.JButton jButton_Enviar;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Nick;
    private javax.swing.JLabel jLabel_Porta;
    private javax.swing.JLabel jLabel_ServidorIP;
    private javax.swing.JList<String> jList_usuariosOnline;
    private javax.swing.JPanel jPanel_Chat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_Mensagens;
    private javax.swing.JTextField jTextField_GrupoIP;
    private javax.swing.JTextField jTextField_Nick;
    private javax.swing.JTextField jTextField_Porta;
    private javax.swing.JTextField jTextField_textoDeEnvio;
    // End of variables declaration//GEN-END:variables
}
