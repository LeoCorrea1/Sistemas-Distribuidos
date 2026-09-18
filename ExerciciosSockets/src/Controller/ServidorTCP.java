/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Pessoa;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author laboratorio
 */
public class ServidorTCP {
    
    public String gerarEmail(Pessoa pessoa) {

    String[] nomes = pessoa.getNome().trim().toLowerCase().split("\\s+");

    String primeiro = nomes[0];
    String ultimo = nomes[nomes.length - 1];

    String ano = pessoa.getDataNascimento().substring(6);

    return primeiro + "." + ultimo + "." + ano + "@ufn.edu.br";
    
    
}
    
public synchronized void salvarPessoas(ArrayList<Pessoa> pessoas, String nomeDoTxt) {

    try (FileWriter arquivo = new FileWriter(nomeDoTxt)) {

        for (Pessoa pessoa : pessoas) {

            arquivo.write("Nome: " + pessoa.getNome() + "\n");
            arquivo.write("Data Nascimento: " + pessoa.getDataNascimento() + "\n");
            arquivo.write("Email: " + pessoa.getEmail() + "\n");
            arquivo.write("\n");
        }

    } catch (IOException e) {
        System.out.println("Erro ao salvar pessoas: " + e.getMessage());
    }
}

  
}
