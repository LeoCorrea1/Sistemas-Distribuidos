package view;

import controller.Inicializadora;

public class SaldoFinalView {
    public static void main(String[] args) throws InterruptedException {
        Inicializadora threads = new Inicializadora();
        threads.processarVendas();

        System.out.printf("Saldo Final Centralizado: R$" + threads.getSaldoFinal());
    }
}