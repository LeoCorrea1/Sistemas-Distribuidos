package controller;

import model.Filial;

public class SomaThread extends Thread {
    private Filial filial;
    private double totalLocal = 0.0;

    public SomaThread(Filial filial) {
        this.filial = filial;
    }

    @Override
    public void run() {
        for (double venda : filial.getVendas()) {
            totalLocal += venda;
        }
    }

    public double getTotalLocal() {
        return totalLocal;
    }
}