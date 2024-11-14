import java.util.Scanner;

public class SimuladorBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("********************************************");
        System.out.println("\nInformações do Cliente:");

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        String tipoConta = "";
        while (!tipoConta.equalsIgnoreCase("Corrente") && !tipoConta.equalsIgnoreCase("Poupança")) {
            System.out.println("Tipo de Conta (Corrente/Poupança): ");
            tipoConta = scanner.nextLine();
            if (!tipoConta.equalsIgnoreCase("Corrente") && !tipoConta.equalsIgnoreCase("Poupança")) {
                System.out.println("Tipo de Conta inválido. Por favor, insira 'Corrente' ou 'Poupança'.");
            }
        }

        double saldoAtual;
        while (true) {
            System.out.println("Saldo Atual: R$");
            saldoAtual = scanner.nextDouble();
            if (saldoAtual >= 0) {
                break;
            } else {
                System.out.println("O Saldo não pode ser negativo. Tente novamente.");
            }
        }

        System.out.println("********************************************");

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\nSERVIÇOS");
            System.out.println("\n1- Consultar Saldos");
            System.out.println("2- Receber Valor");
            System.out.println("3- Transferir Valor");
            System.out.println("4- Sair");
            System.out.println("\nDigite a opção desejada: ");

            // Validar se a opção digitada é um número válido
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Consumir o valor inválido
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Seu Saldo Atual é R$" + saldoAtual);
                    break;
                case 2:
                    System.out.println("Informe o Valor a receber: ");
                    double valorRecebido = scanner.nextDouble();
                    saldoAtual += valorRecebido;
                    System.out.println("Saldo Atualizado: R$" + saldoAtual);
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Informe o Valor que deseja transferir: ");
                    double valorTransferido = scanner.nextDouble();
                    if (valorTransferido <= saldoAtual) {
                        saldoAtual -= valorTransferido;
                        System.out.println("Saldo Atualizado: R$" + saldoAtual);
                    } else {
                        System.out.println("Saldo insuficiente! Não é possível transferir esse valor.");
                    }
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Sessão encerrada. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}