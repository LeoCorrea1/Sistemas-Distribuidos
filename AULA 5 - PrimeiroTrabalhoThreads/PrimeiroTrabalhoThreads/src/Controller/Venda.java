package Controller;

import model.SaldoCentral;

public class Venda {
    private final SaldoCentral sd = new SaldoCentral();

    public synchronized void realizarVenda() {
        sd.adicionarSaldo(10.00);
        System.out.println(Thread.currentThread().getName() + " Realizou a venda! , Valor do saldo Central : R$" + sd.getSaldoCentral() );
    }

    public SaldoCentral getSaldoCentral() {
        return sd;
    }
}