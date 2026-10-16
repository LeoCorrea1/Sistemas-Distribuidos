package view;

import javax.swing.JOptionPane;
import controller.ITelefonia;
import java.rmi.Naming;


public class ClienteInterface extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClienteInterface.class.getName());
    private ITelefonia telefonia;
    /**
     * Creates new form JFrameServidor
     */
    public ClienteInterface() {
         initComponents();
    jPanelResultados.setVisible(true);

    try {
        telefonia = (ITelefonia) Naming.lookup(
            "rmi://localhost/Telefonia"
        );

        System.out.println("Conectado ao servidor RMI.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            "Erro ao conectar com o servidor RMI: " + e.getMessage()
        );
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelResultados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNumeroCelularPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaResultadoPesquisa = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sessões em Telefonia");
        setResizable(false);

        jLabel2.setText("Número celular para pesquisa");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(this::jButtonPesquisarActionPerformed);

        jTextAreaResultadoPesquisa.setColumns(20);
        jTextAreaResultadoPesquisa.setRows(5);
        jTextAreaResultadoPesquisa.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaResultadoPesquisa);

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNumeroCelularPesquisa))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jButtonPesquisar)
                        .addGap(0, 291, Short.MAX_VALUE))
                    .addGroup(jPanelResultadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNumeroCelularPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed

    String numero = jTextFieldNumeroCelularPesquisa.getText().trim();

    if (numero.isEmpty()) {
        JOptionPane.showMessageDialog(
            this,
            "Número de celular não informado"
        );
        jTextFieldNumeroCelularPesquisa.requestFocus();
        return;
    }

    if (telefonia == null) {
        JOptionPane.showMessageDialog(
            this,
            "Não há conexão com o servidor."
        );
        return;
    }

    try {
        String resultado = telefonia.consultaSessao(numero);

        if (resultado == null) {
            JOptionPane.showMessageDialog(
                this,
                "Número de celular não encontrado"
            );
            jTextAreaResultadoPesquisa.setText("");
            jTextFieldNumeroCelularPesquisa.requestFocus();
            return;
        }

        jTextAreaResultadoPesquisa.setText(resultado);
        jTextAreaResultadoPesquisa.setEditable(true);

    } catch (java.rmi.RemoteException e) {
        JOptionPane.showMessageDialog(
            this,
            "Erro na consulta ao servidor: " + e.getMessage()
        );
    }

    }//GEN-LAST:event_jButtonPesquisarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ClienteInterface().setVisible(true));
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaResultadoPesquisa;
    private javax.swing.JTextField jTextFieldNumeroCelularPesquisa;
    // End of variables declaration//GEN-END:variables
}
