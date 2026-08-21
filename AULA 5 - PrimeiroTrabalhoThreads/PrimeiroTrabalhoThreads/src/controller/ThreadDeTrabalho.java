package controller;

public class ThreadDeTrabalho extends Thread {
    private final Venda fazerVenda;
    private final int quantidadeFichas;

    public ThreadDeTrabalho(Venda fazerVenda, int quantidadeFichas) {
        this.fazerVenda = fazerVenda;
        this.quantidadeFichas = quantidadeFichas;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantidadeFichas; i++) {
            fazerVenda.realizarVenda();
        }
    }
}
