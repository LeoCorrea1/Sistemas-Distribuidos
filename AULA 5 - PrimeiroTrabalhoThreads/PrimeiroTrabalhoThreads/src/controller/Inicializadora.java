package controller;

public class Inicializadora {
    private Venda caixaCentral;

    public void processarVendas() throws InterruptedException {
        caixaCentral = new Venda();

        Thread t1 = new ThreadDeTrabalho(caixaCentral, 1000);
        Thread t2 = new ThreadDeTrabalho(caixaCentral, 1000);
        Thread t3 = new ThreadDeTrabalho(caixaCentral, 1000);
        Thread t4 = new ThreadDeTrabalho(caixaCentral, 1000);
        Thread t5 = new ThreadDeTrabalho(caixaCentral, 1000);

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
    }

    public Object getSaldoFinal() {
        return caixaCentral.getSaldoCentral().getSaldoCentral();
    }
}