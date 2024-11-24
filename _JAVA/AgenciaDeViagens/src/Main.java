import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassagemController controller = new PassagemController();

        while (true) {
            System.out.print("Digite o seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o seu CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Digite a origem: ");
            String origem = scanner.nextLine();
            System.out.print("Digite o destino: ");
            String destino = scanner.nextLine();

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

