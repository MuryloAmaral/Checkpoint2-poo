package br.com.fiapride.model;

/**
 * Veículo de entrega do tipo moto.
 */
public class Moto extends Veiculo {
    private final boolean possuiBau;

    public Moto(String placa, double capacidadeCarga, boolean possuiBau) {
        super(placa, capacidadeCarga);
        this.possuiBau = possuiBau;
    }

    public boolean isPossuiBau() {
        return possuiBau;
    }
}
