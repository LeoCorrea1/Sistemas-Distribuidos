package view;

import controller.ThreadDeTrabalho;
import controller.Venda;

public class SaldoFinalView {
    public static void main(String[] args) throws InterruptedException {
        Venda CaixaCentral = new Venda();


        Thread t1 = new ThreadDeTrabalho(CaixaCentral, 1000);
        Thread t2 = new ThreadDeTrabalho(CaixaCentral, 1000);
        Thread t3 = new ThreadDeTrabalho(CaixaCentral, 1000);
        Thread t4 = new ThreadDeTrabalho(CaixaCentral, 1000);
        Thread t5 = new ThreadDeTrabalho(CaixaCentral, 1000);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.printf("Saldo Final Centralizado: R$" + CaixaCentral.getSaldoCentral().getSaldoCentral());

    }
}
