package br.com.fiapride.model;

/**
 * Veículo de entrega do tipo caminhão.
 */
public class Caminhao extends Veiculo {
    private final int quantidadeEixos;

    public Caminhao(String placa, double capacidadeCarga, int quantidadeEixos) {
        super(placa, capacidadeCarga);
        if (quantidadeEixos <= 0) {
            throw new IllegalArgumentException("A quantidade de eixos deve ser maior que zero.");
        }
        this.quantidadeEixos = quantidadeEixos;
    }

    public int getQuantidadeEixos() {
        return quantidadeEixos;
    }
}
