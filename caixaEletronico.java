package exercicios;

import java.util.Scanner;

public class caixaEletronico {

    public static void main(String[] args) {

        double saldo = 2000;
        int opcaoUsuario = 0;

        while (true) {

            System.out.println("===== Caixa Eletrônico =====");

            System.out.println("1. Saldo");
            System.out.println("2. Saque");
            System.out.println("3. Depósito");
            System.out.println("4. Transferência");
            System.out.println("5. Sair\n");

            System.out.print("Selecione uma opção do menu: ");

            Scanner scanner = new Scanner (System.in);

            opcaoUsuario = scanner.nextInt();

            while (opcaoUsuario < 1 || opcaoUsuario > 5) {

                System.out.println("Opção inválida!");
                System.out.print("Selecione uma opção do menu: ");
                opcaoUsuario = scanner.nextInt();
            }


            if (opcaoUsuario == 1) {

                mostrarSaldo(saldo);

            } else if (opcaoUsuario == 2) {

                saldo = sacarSaldo(saldo, scanner);
                System.out.println(saldo);

            } else if (opcaoUsuario == 3) {

                saldo = depositarSaldo(saldo, scanner);
                System.out.println("Depósito realizado com sucesso");
                System.out.println("Seu novo saldo é: R$" + saldo);

            } else if (opcaoUsuario == 4) {

                saldo = transferirSaldo(saldo, scanner);

            } else {

                System.out.println("Encerrando o programa Caixa Eletrônico...");
                System.exit(0);

                }






            }
        }



        public static void mostrarSaldo(double saldo) {

            System.out.println("Seu saldo é de: R$" + saldo);

    }

        public static double sacarSaldo(double saldo, Scanner scanner) {

            System.out.print("Valor a ser sacado: ");
            double valorSacado = scanner.nextInt();

            if (valorSacado <= saldo) {

                saldo = saldo - valorSacado;
                System.out.println("Saque de R$ " + valorSacado + " realizado com sucesso");
                System.out.println("Seu novo saldo é R$" + saldo);


            } else {

                System.out.println("Saldo insuficiente.");

            }

            return saldo;
        }

        public static double depositarSaldo(double saldo, Scanner scanner) {

            System.out.print("Valor do depósito: ");
            double valorDepositado = scanner.nextInt();
            saldo = saldo + valorDepositado;

            return saldo;
        }

        public static double transferirSaldo(double saldo, Scanner scanner) {

            System.out.print("Valor a ser transferido: ");
            double valorTransferido = scanner.nextInt();

            if (valorTransferido > saldo) {

                System.out.println("Seu saldo é insuficiente para realizar essa transferência");

                return saldo;
            }

            System.out.print("Conta de destino: ");
            String contaDestino = scanner.next();
            System.out.println("Transferência de R$ " + valorTransferido + " realizada para a conta " + contaDestino);

            saldo = saldo  - valorTransferido;

            System.out.println("Seu novo saldo é: R$" + saldo);

            return saldo;
        }
}
