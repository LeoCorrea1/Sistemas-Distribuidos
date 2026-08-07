package Desafio1EmJava.Metodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TarefaPopular extends Thread {
    private List<Integer> lista;
    private int quantidade;

    public TarefaPopular(List<Integer> lista, int quantidade) {
        this.lista = lista;
        this.quantidade = quantidade;
    }

    @Override
    public void run() {
        Random gerador = new Random();
        for (int i = 0; i < this.quantidade; i++) {
            // Bloco sincronizado para evitar condições de corrida (Race Condition)
            synchronized (lista) {
                lista.add(gerador.nextInt(200));
            }
        }
    }
}