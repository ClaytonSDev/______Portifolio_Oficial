package Minhaagencia.viagens;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Passagem {
    private Passageiro passageiro;
    private String origem;
    private String destino;
    private LocalDate data;
    private double valor;
    private String numeroAssento;
    private LocalDate dataIda;
    private LocalTime horarioIda;

    public Passagem(Passageiro passageiro, String origem, String destino, LocalDate data, String numeroAssento,
                    LocalDate dataIda, LocalTime horarioIda) {
        this.passageiro = passageiro;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.numeroAssento = numeroAssento;
        this.dataIda = dataIda;
        this.horarioIda = horarioIda;
        this.valor = gerarValorAleatorio();
    }

    private double gerarValorAleatorio() {
        Random random = new Random();
        return 500 + (1000 - 500) * random.nextDouble();  // Gera um valor entre 500 e 1000
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getNumeroAssento() {
        return numeroAssento;
    }

    public LocalDate getDataIda() {
        return dataIda;
    }

    public LocalTime getHorarioIda() {
        return horarioIda;
    }
}
