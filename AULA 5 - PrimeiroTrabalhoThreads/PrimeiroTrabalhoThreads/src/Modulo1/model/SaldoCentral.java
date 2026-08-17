package Modulo1.model;

public class SaldoCentral {
    private double saldoCentral = 0.0;

    public synchronized double getSaldoCentral() {
        return saldoCentral;
    }

    public synchronized void adicionarSaldo(double valor) {
        this.saldoCentral += valor;
    }
}