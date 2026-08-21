package view;

import controller.Inicializadora;

public class FaturamentoView {
    public static void main(String[] args) throws InterruptedException {
        Inicializadora threads = new Inicializadora();
        threads.processarFaturamento();

        System.out.printf("Faturamento pela Thread 1: R$ %.2f%n", threads.getTotalT1());
        System.out.printf("Faturamento pela Thread 2: R$ %.2f%n", threads.getTotalT2());
        System.out.printf("Faturamento pela Thread 3: R$ %.2f%n", threads.getTotalT3());
        System.out.printf("Faturamento pela Thread 4: R$ %.2f%n", threads.getTotalT4());
        System.out.printf("Faturamento Total do Evento: R$ %.2f%n", threads.getTotalGeral());
    }
}