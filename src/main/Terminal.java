package main;

import java.util.Locale;
import java.util.Scanner;

public class Terminal {

    private ContaCorrente contaCorrenteFulano;

    public static void main(String[] args) {
        double valorDeposito;
        double valorSaque;
        Agencia agencia = new Agencia();
        agencia.nome = "Buritis";
        agencia.codigo = 2;

        ContaCorrente contaCorrenteFulano = new ContaCorrente();
        contaCorrenteFulano.agencia = agencia;
        contaCorrenteFulano.numero = 2030;
        contaCorrenteFulano.senha = "123456";

        Terminal.verOpcoesMenu();
        while(true) {
            Scanner in = new Scanner(System.in);
            in.useLocale(Locale.ENGLISH);

            switch (in.nextInt()) {
                case 1:
                    System.out.println("---------------");
                    System.out.println("Opçao atual: Exibir saldo");
                    System.out.format("Saldo atual: %s %n", contaCorrenteFulano.getSaldo());
                    System.out.println("---------------");
                    Terminal.verOpcoesMenu();
                    break;
                case 2:
                    System.out.println("---------------");
                    System.out.println("Opçao atual: depositar");
                    System.out.println("Valor do depósito:");
                    valorDeposito = in.nextDouble();
                    contaCorrenteFulano.depositar(valorDeposito);
                    System.out.println("\n--------------- \n");
                    Terminal.verOpcoesMenu();
                    break;
                case 3:
                    System.out.println("---------------");
                    System.out.println("Opçao atual: Sacar");
                    System.out.println("Valor do saque:");
                    valorSaque = in.nextDouble();
                    try {
                        contaCorrenteFulano.sacar(valorSaque);
                    } catch (Exception e) {
                        System.out.format("Não foi possível realizar o saque. \nMotivo: %s \n", e.getMessage());
                    }
                    System.out.println("---------------");
                    Terminal.verOpcoesMenu();
                    break;
                case 9:
                    System.out.println("Encerrar terminal");
                    return;
                default:
                    System.out.println("Opçao invalida");
                    break;
            }
        }
    }

    private static void verOpcoesMenu() {
        System.out.println("Selecione uma opção:");
        System.out.println("1: Exibir saldo");
        System.out.println("2: Depositar");
        System.out.println("3: Sacar");
    }
}
