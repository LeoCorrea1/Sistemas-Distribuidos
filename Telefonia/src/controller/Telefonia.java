
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import model.Sessao;

public class Telefonia extends UnicastRemoteObject implements ITelefonia {

    private final HashMap<String, Sessao> sessoes;

    public Telefonia() throws RemoteException {
        super();
        sessoes = new HashMap<>();
        carregarBase();
    }

    private void carregarBase() throws RemoteException {
        InputStream arquivo = getClass().getResourceAsStream(
            "/model/telephony_sessions.txt"
        );

        if (arquivo == null) {
            throw new RemoteException(
                "Arquivo telephony_sessions.txt não encontrado."
            );
        }

        try (BufferedReader leitor = new BufferedReader(
                new InputStreamReader(arquivo, StandardCharsets.UTF_8))) {

            String linha;

            while ((linha = leitor.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] campos = linha.split(";", 2);

                if (campos.length == 2) {
                    Sessao sessao = new Sessao(
                        campos[0].trim(),
                        campos[1].trim()
                    );

                    sessoes.put(sessao.getNumeroCelular(), sessao);
                }
            }

            System.out.println(
                "Base carregada. Total de sessoes: " + sessoes.size()
            );

        } catch (IOException e) {
            throw new RemoteException("Erro ao ler a base de telefonia.", e);
        }
    }

    @Override
    public String consultaSessao(String numeroCelular) throws RemoteException {
        Sessao sessao = sessoes.get(numeroCelular.trim());

        if (sessao == null) {
            return null;
        }

        return sessao.toString();
    }
}
