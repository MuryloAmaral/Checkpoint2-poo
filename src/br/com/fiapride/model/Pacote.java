package br.com.fiapride.model;

/**
 * Representa um pacote transportado pelo FiapDelivery.
 */
public class Pacote {
    private final String codigo;
    private final double peso;
    private String status;

    public Pacote(String codigo, double peso, String statusInicial) {
        this.codigo = validarTextoObrigatorio(codigo, "O código do pacote não pode ficar vazio.");
        this.peso = validarPeso(peso);
        this.status = validarTextoObrigatorio(statusInicial, "O status do pacote não pode ficar vazio.");
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Altera o status do pacote por meio de uma operação de negócio.
     */
    public void atualizarStatus(String novoStatus) {
        this.status = validarTextoObrigatorio(novoStatus, "O status do pacote não pode ficar vazio.");
    }

    private static String validarTextoObrigatorio(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
        return valor.trim();
    }

    private static double validarPeso(double peso) {
        if (!Double.isFinite(peso) || peso <= 0) {
            throw new IllegalArgumentException("O peso do pacote deve ser finito e maior que zero.");
        }
        return peso;
    }
}
