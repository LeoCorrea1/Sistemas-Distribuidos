package controller;

import model.Filial;

public class Inicializadora {
    private SomaThread t1;
    private SomaThread t2;
    private SomaThread t3;
    private SomaThread t4;

    public void processarFaturamento() throws InterruptedException {
        Filial f1 = new Filial(10000);
        Filial f2 = new Filial(10000);
        Filial f3 = new Filial(10000);
        Filial f4 = new Filial(10000);

        t1 = new SomaThread(f1);
        t2 = new SomaThread(f2);
        t3 = new SomaThread(f3);
        t4 = new SomaThread(f4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

    public double getTotalT1() {
        return t1.getTotalLocal();
    }

    public double getTotalT2() {
        return t2.getTotalLocal();
    }

    public double getTotalT3() {
        return t3.getTotalLocal();
    }

    public double getTotalT4() {
        return t4.getTotalLocal();
    }

    public double getTotalGeral() {
        return getTotalT1() + getTotalT2() + getTotalT3() + getTotalT4();
    }
}