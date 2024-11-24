package Compradepassagens;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PassagemController {
    private List<Passagem> passagens;
    private boolean[] assentosDisponiveis;
    private double totalVendas;

    public PassagemController() {
        passagens = new ArrayList<>();
        assentosDisponiveis = new boolean[46];  // 46 assentos disponíveis
        totalVendas = 0.0;
        for (int i = 0; i < assentosDisponiveis.length; i++) {
            assentosDisponiveis[i] = true;  // Todos os assentos começam como disponíveis
        }
    }

    public boolean verificarDisponibilidadeAssento(int numeroAssento, LocalDate dataIda, LocalTime horarioIda) {
        for (Passagem passagem : passagens) {
            if (passagem.getNumeroAssento().equals(String.valueOf(numeroAssento)) &&
                    passagem.getDataIda().equals(dataIda) &&
                    passagem.getHorarioIda().equals(horarioIda)) {
                return false;
            }
        }
        return true;
    }

    public void reservarAssento(int numeroAssento) {
        assentosDisponiveis[numeroAssento - 1] = false;
    }

    public void adicionarPassagem(Passagem passagem) {
        int numeroAssento = Integer.parseInt(passagem.getNumeroAssento());
        if (verificarDisponibilidadeAssento(numeroAssento, passagem.getDataIda(), passagem.getHorarioIda())) {
            passagens.add(passagem);
            reservarAssento(numeroAssento);
            totalVendas += passagem.getValor();
            System.out.println("Compradepassagens.Passagem adicionada com sucesso!");
        } else {
            System.out.println("Assento " + numeroAssento + " já está ocupado na data e horário selecionados.");
            mostrarAssentosDisponiveis();
        }
    }

    public void listarPassagens() {
        if (passagens.isEmpty()) {
            System.out.println("Nenhuma passagem disponível.");
        } else {
            for (Passagem p : passagens) {
                System.out.println("Compradepassagens.Passageiro: " + p.getPassageiro().getNome());
                System.out.println("CPF: " + p.getPassageiro().getCpf());
                System.out.println("Origem: " + p.getOrigem());
                System.out.println("Destino: " + p.getDestino());
                System.out.println("Data: " + p.getData());
                System.out.println("Valor: " + p.getValor());
                System.out.println("Número do Assento: " + p.getNumeroAssento());
                System.out.println("Data Ida: " + p.getDataIda());
                System.out.println("Horário Ida: " + p.getHorarioIda());
                System.out.println("------------------------");
            }
            System.out.println("Total de Vendas: R$ " + totalVendas);
        }
    }

    public void mostrarAssentosDisponiveis() {
        System.out.println("Assentos disponíveis: ");
        for (int i = 0; i < assentosDisponiveis.length; i++) {
            if (assentosDisponiveis[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    public double getTotalVendas() {
        return totalVendas;
    }
}
