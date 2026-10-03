package br.com.fiapride.model;

/**
 * Associa um pacote a um veículo para realizar uma entrega.
 * A associação usa a superclasse Veiculo, permitindo Caminhao, Moto
 * e futuras especializações sem alterar esta classe.
 */
public class Rota {
    private final Pacote pacote;
    private final Veiculo veiculo;

    public Rota(Pacote pacote, Veiculo veiculo) {
        if (pacote == null) {
            throw new IllegalArgumentException("O pacote é obrigatório.");
        }
        if (veiculo == null) {
            throw new IllegalArgumentException("O veículo é obrigatório.");
        }
        this.pacote = pacote;
        this.veiculo = veiculo;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * Inicia a entrega somente quando o veículo suporta o peso do pacote.
     */
    public void iniciarEntrega() {
        if (pacote.getPeso() > veiculo.getCapacidadeCarga()) {
            throw new IllegalStateException("O pacote excede a capacidade de carga do veículo.");
        }

        pacote.atualizarStatus("Em rota");
        System.out.printf("Levando pacote %s no veículo %s%n",
                pacote.getCodigo(), veiculo.getPlaca());
    }
}
