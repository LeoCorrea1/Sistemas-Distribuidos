package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Filial {
    private List<Double> vendas = new ArrayList<>();

    public Filial(int quantidade) {
        Random random = new Random();
        for (int i = 0; i < quantidade; i++) {
            vendas.add(1 + random.nextDouble() * 10.0);;
        }
    }

    public List<Double> getVendas() {
        return vendas;
    }
}