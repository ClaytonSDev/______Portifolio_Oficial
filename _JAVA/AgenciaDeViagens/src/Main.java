import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassagemController controller = new PassagemController();

        String[] destinos = {"Rio de Janeiro", "Arraial do Cabo-RJ", "Belo Horizonte-MG", "Goiania-GO"};

        while (true) {
            System.out.print("Digite o seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o seu CPF: ");
            String cpf = scanner.nextLine();

            // Solicitar origem ao passageiro
            System.out.print("Digite a cidade de origem: ");
            String origem = scanner.nextLine();

            // Mostrar opções de destinos
            System.out.println("Escolha um destino:");
            for (int i = 0; i < destinos.length; i++) {
                System.out.println((i + 1) + ". " + destinos[i]);
            }
            System.out.print("Digite o número do destino escolhido: ");
            int escolhaDestino = scanner.nextInt();
            String destino = destinos[escolhaDestino - 1];

            int numeroAssento;
            LocalDate dataIda;
            LocalTime horarioIda;
            boolean assentoDisponivel;

            do {
                System.out.print("Digite o número do assento (1-46): ");
                numeroAssento = scanner.nextInt();
                System.out.print("Digite a data de ida (yyyy-mm-dd): ");
                dataIda = LocalDate.parse(scanner.next());
                System.out.print("Digite o horário de ida (HH:MM): ");
                horarioIda = LocalTime.parse(scanner.next());
                System.out.println("Obrigado por nos escolher, tenha uma otima viagem ");

                assentoDisponivel = controller.verificarDisponibilidadeAssento(numeroAssento, dataIda, horarioIda);

                if (!assentoDisponivel) {
                    System.out.println("Assento " + numeroAssento + " já está ocupado na data e horário selecionados. Por favor, escolha outra poltrona.");
                    controller.mostrarAssentosDisponiveis();
                }
            } while (!assentoDisponivel);

            // Criar objetos de Passageiro e Passagem
            Passageiro passageiro = new Passageiro(nome, cpf);
            Passagem passagem = new Passagem(passageiro, origem, destino, LocalDate.now(),
                    String.valueOf(numeroAssento), dataIda, horarioIda);

            // Adicionar a passagem
            controller.adicionarPassagem(passagem);

            // Mostrar passagens e assentos disponíveis
            controller.listarPassagens();
            controller.mostrarAssentosDisponiveis();

            System.out.println("Obrigado por nos escolher, tenha uma otima viagem ");
            System.out.println("Valor da Passagem: R$ " + passagem.getValor());
            System.out.println("Total a Pagar: R$ " + controller.getTotalVendas());

            System.out.print("Deseja adicionar outra passagem? (s/n): ");
            String continuar = scanner.next();
            if (continuar.equalsIgnoreCase("n")) {
                break;
            }
            scanner.nextLine(); // Consumir nova linha
        }

        scanner.close();
    }
}


