package br.com.fiapride.main;

import br.com.fiapride.model.Caminhao;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Pacote;
import br.com.fiapride.model.Rota;
import br.com.fiapride.model.Veiculo;

/**
 * Demonstra a solução refatorada com diferentes tipos de veículo
 * e também um cenário inválido de capacidade de carga.
 */
public class Principal {
    public static void main(String[] args) {
        executarEntregaComCaminhao();
        executarEntregaComMoto();
        testarPacoteAcimaDaCapacidade();
    }

    private static void executarEntregaComCaminhao() {
        Veiculo caminhao = new Caminhao("ABC1234", 1500.0, 4);
        Pacote pacote = new Pacote("BR999", 10.5, "Pendente");
        Rota rota = new Rota(pacote, caminhao);

        rota.iniciarEntrega();
        System.out.println("Status: " + pacote.getStatus());
    }

    private static void executarEntregaComMoto() {
        Veiculo moto = new Moto("MOT2026", 40.0, true);
        Pacote pacote = new Pacote("BR1000", 5.0, "Pendente");
        Rota rota = new Rota(pacote, moto);

        rota.iniciarEntrega();
        System.out.println("Status: " + pacote.getStatus());
    }

    private static void testarPacoteAcimaDaCapacidade() {
        try {
            Veiculo moto = new Moto("MOT0001", 20.0, true);
            Pacote pacotePesado = new Pacote("BR2000", 30.0, "Pendente");
            new Rota(pacotePesado, moto).iniciarEntrega();
        } catch (IllegalStateException e) {
            System.out.println("Validação funcionando: " + e.getMessage());
        }
    }
}
