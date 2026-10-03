package br.com.fiapride.model;

/**
 * Representa um veículo utilizado nas entregas do FiapDelivery.
 * Centraliza os atributos comuns de caminhões e motos.
 */
public abstract class Veiculo {
    private final String placa;
    private final double capacidadeCarga;

    protected Veiculo(String placa, double capacidadeCarga) {
        this.placa = validarTextoObrigatorio(placa, "A placa não pode ficar vazia.");
        this.capacidadeCarga = validarValorPositivo(capacidadeCarga,
                "A capacidade de carga deve ser finita e maior que zero.");
    }

    public String getPlaca() {
        return placa;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    protected static String validarTextoObrigatorio(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
        return valor.trim();
    }

    protected static double validarValorPositivo(double valor, String mensagem) {
        if (!Double.isFinite(valor) || valor <= 0) {
            throw new IllegalArgumentException(mensagem);
        }
        return valor;
    }
}
