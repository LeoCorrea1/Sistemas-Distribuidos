package view;

import controller.SomaThread;
import model.Filial;

public class FaturamentoView {
    public static void main(String[] args) throws InterruptedException {
        Filial f1 = new Filial(10000);
        Filial f2 = new Filial(10000);
        Filial f3 = new Filial(10000);
        Filial f4 = new Filial(10000);

        SomaThread t1 = new SomaThread(f1);
        SomaThread t2 = new SomaThread(f2);
        SomaThread t3 = new SomaThread(f3);
        SomaThread t4 = new SomaThread(f4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        double totalGeral = t1.getTotalLocal() + t2.getTotalLocal() +
                t3.getTotalLocal() + t4.getTotalLocal();

        System.out.printf("Faturamento pela Thread 1: R$ %.2f%n", t1.getTotalLocal());
        System.out.printf("Faturamento pela Thread 2: R$ %.2f%n", t2.getTotalLocal());
        System.out.printf("Faturamento pela Thread 3: R$ %.2f%n", t3.getTotalLocal());
        System.out.printf("Faturamento pela Thread 4: R$ %.2f%n", t4.getTotalLocal());
        System.out.printf("Faturamento Total do Evento: R$ %.2f%n", totalGeral);
    }
}
