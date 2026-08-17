package view;

import Controller.ThreadDeTrabalho;
import Controller.Venda;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Venda listaCompartilhada = new Venda();

        Thread t1 = new ThreadDeTrabalho(listaCompartilhada, 1000);
        Thread t2 = new ThreadDeTrabalho(listaCompartilhada, 1000);
        Thread t3 = new ThreadDeTrabalho(listaCompartilhada, 1000);
        Thread t4 = new ThreadDeTrabalho(listaCompartilhada, 1000);
        Thread t5 = new ThreadDeTrabalho(listaCompartilhada, 1000);

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

        System.out.printf("Saldo Final Centralizado: R$" + listaCompartilhada.getSaldoCentral().getSaldoCentral());
    }
}