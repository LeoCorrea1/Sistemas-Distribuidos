package Controller;

public class ThreadDeTrabalho extends Thread {
    private final Venda vendaService;
    private final int quantidadeFichas;

    public ThreadDeTrabalho(Venda vendaService, int quantidadeFichas) {
        this.vendaService = vendaService;
        this.quantidadeFichas = quantidadeFichas;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantidadeFichas; i++) {
            vendaService.realizarVenda();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}