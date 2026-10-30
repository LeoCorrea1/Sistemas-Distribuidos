package comunicacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class Comunicador extends ReceiverAdapter {

    JChannel channel;
    List<Address> listaMembros = new ArrayList<>();
    String frase;
    Message mensagem;
    JFrame_chatJGROUPS meuFrame;
    StringBuffer membrosStringBuffer;
    ArrayList<String> historico = new ArrayList<>();  //
    boolean primeiraView = true;

    public void iniciar(JFrame_chatJGROUPS meuFrame) throws Exception {

        /*
         * JGroups utiliza um JChannel como principal forma de conectar
         * a um cluster/grupo. É atraves dele que enviaremos e recebermos mensagens
         * bem como registrar os eventos callback quando acontecer alguma
         * mudança (por exemplo, entrada de um membro no grupo).
         * 
         * Neste caso, criamos uma instancia deste objeto, utilizando configurações default.
         */
        this.meuFrame = meuFrame;
        this.channel = new JChannel();
        /*
         * Definimos através do método setReceiver qual classe implementará
         * o método callback receive, que será chamado toda vez que alguém
         * enviar uma mensagem ao cluster/grupo. Neste caso, a própria classe
         * implementa o método receive mais abaixo.
         */
        this.channel.setReceiver(this);
        /*
         * O método connect faz com que este processo entre no cluster/grupo ChatCluster.
         * Não há a necessidade de se criar explicitamente um cluster, pois o método connect
         * cria o cluster caso este seja o primeiro membro a entrar nele.
         */
        this.channel.setName(meuFrame.getjTextField_apelido().getText());
        this.channel.connect(meuFrame.getTitle());
    }

    public void enviar(String frase, String participante) {
        try {
            if (participante == null) {
                /*
                 * cria uma instancia da classe Message do JGrupos com a mensagem.
                 * O primeiro parâmetro é o endereço do destinatário. Caso seja null, a mensagem é enviada para todos do grupo
                 * O segundo parâmetro é a mensagem enviada através de um buffer de bytes (convertida automaticamente)
                 */
                this.mensagem = new Message(null, frase);
                this.channel.send(this.mensagem);
            } else {
                for (int i = 0; i < listaMembros.size(); i++) {
                    if (participante.equals(listaMembros.get(i).toString())) {
                        this.mensagem = new Message(listaMembros.get(i), frase);
                        this.channel.send(this.mensagem);
                        break;
                    }
                }
            }
            /*
            * envia a mensagem montada acima ao grupo
             */
        } catch (Exception e) {
            JOptionPane.showMessageDialog(meuFrame, "Algo ocorreu de errrado ao enviar sua mensagem!!");
        }
    }

    public void finalizar() {
        if (channel != null && channel.isConnected()) {
            this.channel.close();
        }
    }

    /*
     * O método abaixo é callback, e é chamado toda vez que alguem
     * envia uma mensagem ao processo/grupo/canal. Esta mensagem é recebida no parâmetro
     * Message msg. Nessa implementação, mostramos na tela o originador
     * da mensagem em msg.getSrc() e a mensagem propriamente dita em
     * msg.getObject
     */
    @Override
    public void receive(Message msg) { 

        String texto = msg.getObject().toString();  //

        if (texto.equals("HISTORICO_PEDIR")) {//
            try {
                channel.send(new Message(msg.getSrc(), "HISTORICO" + String.join("\n", historico)));
            } catch (Exception e) {
                System.out.println("Erro ao enviar histórico.");
            }
            return;
        }

        if (texto.startsWith("HISTORICO")) {//
            String mensagens = texto.substring("HISTORICO".length());
            meuFrame.getjTextArea_mensagensGerais().setText("");
            historico.clear();

            for (String mensagemAntiga : mensagens.split("\n")) {
                if (!mensagemAntiga.isEmpty()) {
                    meuFrame.getjTextArea_mensagensGerais().append(mensagemAntiga + "\n");
                    historico.add(mensagemAntiga);
                }
            }
            return;
        }

        String horario = new SimpleDateFormat("HH:mm").format(new Date());//
        String nome = msg.getSrc().toString();

        if (texto.startsWith("[privado para ")) {
            texto = texto.substring(texto.indexOf("] ") + 2);
            meuFrame.getjTextArea_mensagensGerais().append(
                    "[" + horario + "] Privado de " + nome + ": " + texto + "\n"
            );
            return;
        }

        String mensagemChat = "[" + horario + "] " + nome + " disse: " + texto;
        meuFrame.getjTextArea_mensagensGerais().append(mensagemChat + "\n");
        historico.add(mensagemChat);
    }

    /*
     * O método abaixo é callback, e é chamado toda vez que uma nova
     * instancia entra no grupo, ou se alguma instancia sai do grupo.
     * Ele recebe uma View como parâmetro. Este objeto possui informações
     * sobre todos os membros do grupo.
     * Na nossa implementação, quando damos um print no objeto new_view
     * ele mostra, respectivamente:
     *      [Criador do grupo | ID da View]  [Membros do grupo]
     * 
     * Cada View possui uma ID, que a identifica. 
     * O ID da View é um Relógio de Lamport que marca a ocorrência de eventos.
     */
    @Override
    public void viewAccepted(View view_atual) {

        List<Address> membrosAntigos = new ArrayList<>(listaMembros);  //
        listaMembros = new ArrayList<>(view_atual.getMembers());
        membrosStringBuffer = new StringBuffer();

        meuFrame.getjComboBox_listaParticipantesGrupo().removeAllItems();
        meuFrame.getjComboBox_listaParticipantesGrupo().addItem("Selecione o participante");

        for (Address membro : listaMembros) {
            membrosStringBuffer.append(membro).append("\n");

            if (!membro.equals(channel.getAddress())) {
                meuFrame.getjComboBox_listaParticipantesGrupo().addItem(membro.toString());
            }
        }

        meuFrame.getjTextArea_listaMembros().setText(membrosStringBuffer.toString());

        if (primeiraView) {
            primeiraView = false;
            meuFrame.getjTextArea_mensagensGerais().append(channel.getName() + " entrou no grupo!\n");//

            if (listaMembros.size() > 1) {
                int resposta = JOptionPane.showConfirmDialog(
                        meuFrame,
                        "Deseja carregar o histórico de mensagens?",//
                        "Histórico do chat",
                        JOptionPane.YES_NO_OPTION
                );

                if (resposta == JOptionPane.YES_OPTION) {
                    try {
                        channel.send(new Message(listaMembros.get(0), "HISTORICO_PEDIR"));//
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(meuFrame, "Erro ao solicitar histórico.");
                    }
                }
            }
            return;
        }

        for (Address membro : listaMembros) {
            if (!membrosAntigos.contains(membro)) {
                String evento = membro + " entrou no grupo!";
                this.meuFrame.getjTextArea_mensagensGerais().append(evento + "\n");
                historico.add(evento);
            }
        }

        for (Address membro : membrosAntigos) {
            if (!listaMembros.contains(membro)) {
                String evento = membro + " saiu do grupo!";
                this.meuFrame.getjTextArea_mensagensGerais().append(evento + "\n");
                historico.add(evento);
            }
        }
    }

    /*
     * Este método callback é chamado toda vez que um membro é 
     * suspeito de ter falhado, porém ainda não foi excluído
     * do grupo. Esse método só é executado no coordenador do grupo.
     */
    @Override
    public void suspect(Address mbr) {
        JOptionPane.showMessageDialog(meuFrame, "PROCESSO SUSPEITO DE FALHA: " + mbr);
    }
}