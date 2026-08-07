package Desafio1EmJava.Principal;


import Desafio1EmJava.Metodos.SomaThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int tamanhoTotal = 10000;
        List<Integer> listaGeral = new ArrayList<>(tamanhoTotal);
        Random gerador = new Random();

        for (int i = 0; i < tamanhoTotal; i++) {
            listaGeral.add(gerador.nextInt(100));
        }

        int tamanhoParte = tamanhoTotal / 4;
        List<Integer> parte1 = listaGeral.subList(0, tamanhoParte);
        List<Integer> parte2 = listaGeral.subList(tamanhoParte, tamanhoParte * 2);
        List<Integer> parte3 = listaGeral.subList(tamanhoParte * 2, tamanhoParte * 3);
        List<Integer> parte4 = listaGeral.subList(tamanhoParte * 3, tamanhoTotal);

        SomaThread t1 = new SomaThread(parte1);
        SomaThread t2 = new SomaThread(parte2);
        SomaThread t3 = new SomaThread(parte3);
        SomaThread t4 = new SomaThread(parte4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long soma1 = t1.getSomaParcial();
        long soma2 = t2.getSomaParcial();
        long soma3 = t3.getSomaParcial();
        long soma4 = t4.getSomaParcial();

        long somaTotal = soma1 + soma2 + soma3 + soma4;

        System.out.println("Soma Parte 1 : " + soma1);
        System.out.println("Soma Parte 2 : " + soma2);
        System.out.println("Soma Parte 3 : " + soma3);
        System.out.println("Soma Parte 4 : " + soma4);
        System.out.println("Soma Total do Vetor: " + somaTotal);
    }
}