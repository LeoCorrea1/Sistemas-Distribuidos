package Controller;

import Model.Pessoa;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteTCP {

    public Pessoa Conectar(String nome, String data) throws Exception {

        Socket cliente = new Socket("localhost", 50000);

        Pessoa pessoa = new Pessoa(nome, data);

        ObjectOutputStream saida =
                new ObjectOutputStream(cliente.getOutputStream());

        saida.writeObject(pessoa);
        saida.flush();

        ObjectInputStream entrada =
                new ObjectInputStream(cliente.getInputStream());

        Pessoa resposta = (Pessoa) entrada.readObject();

        cliente.close();

        return resposta;
    }
}
