package view;

import controller.IEncurtador;
import javax.swing.JOptionPane;


public class ClienteInterface extends javax.swing.JFrame {

private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClienteInterface.class.getName());
    private IEncurtador iencurtador;
    private String emailUsuario;

    public ClienteInterface(String emailUsuario, IEncurtador iencurtador) {
        this.emailUsuario = emailUsuario;
        this.iencurtador = iencurtador;
        initComponents();
        jPanelResultados.setVisible(true);
    }

    private ClienteInterface() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelResultados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUrlParaEncurtar = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        txtUrlGerado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sessões em Telefonia");
        setResizable(false);

        jLabel2.setText("Insira a URL a ser encurtada :");

        jButtonPesquisar.setText("Gerar Url");
        jButtonPesquisar.addActionListener(this::jButtonPesquisarActionPerformed);

        txtUrlGerado.setEditable(false);

        jLabel1.setText("Url Encurtado :");

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtUrlParaEncurtar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultadosLayout.createSequentialGroup()
                .addGap(0, 137, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtUrlGerado, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUrlParaEncurtar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUrlGerado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26))
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
                .addComponent(jPanelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
    String Url = txtUrlParaEncurtar.getText().trim();

        if (Url.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Url não informada");
            txtUrlParaEncurtar.requestFocus();
            return;
        }

        if (iencurtador == null) {
            JOptionPane.showMessageDialog(this, "Não há conexão com o servidor.");
            return;
        }

        try {
            String resultado = iencurtador.EncurtaUrl(emailUsuario, Url);

            if (resultado == null) {
                JOptionPane.showMessageDialog(this, "URL não encurtada");
                txtUrlGerado.setText("");
                txtUrlParaEncurtar.requestFocus();
                return;
            }

            txtUrlGerado.setText(resultado);
            txtUrlGerado.setEditable(true);

        } catch (java.rmi.RemoteException e) {
            JOptionPane.showMessageDialog(this, "Erro na consulta ao servidor: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(() -> new ClienteInterface().setVisible(true));
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JTextField txtUrlGerado;
    private javax.swing.JTextField txtUrlParaEncurtar;
    // End of variables declaration//GEN-END:variables
}

