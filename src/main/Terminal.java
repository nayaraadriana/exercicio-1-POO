package main;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Terminal {

    private ContaCorrente contaCorrenteFulano;

    public static void main(String[] args) {
        double valorDeposito;
        double valorSaque;
        String nomeCorrentista;

        Banco banco = new Banco("Banco da Newton");
        Agencia agencia = new Agencia("Centro", 2);
        Correntista correntista = new Correntista("José");
        ContaCorrente contaCorrenteFulano = new ContaCorrente(agencia, correntista);

        banco.adicionarContaCorrente(contaCorrenteFulano);

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
                    System.out.println("--------------- ");
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
                case 4:
                    System.out.println("---------------");
                    System.out.println("Opçao atual: Extrato");
                    for (int i = 0; i < contaCorrenteFulano.getSizeExtrato(); i++) {
                        System.out.format( "%d0 - %s \n", i+1, contaCorrenteFulano.getItemDoExtrato(i));
                    }
                    System.out.println("---------------");
                    break;
                case 5:
                    System.out.println("---------------");
                    System.out.println("Opçao atual: Exibir todas as contas correntes");

                    for (Map.Entry<String,ContaCorrente> pair : banco.getContasCorrentes().entrySet()) {
                        System.out.println(pair.getKey());
                        System.out.println(pair.getValue().getNomeCorrentista());

                        System.out.println("-------");
                        System.out.format("ID: %s \n", pair.getKey());
                        System.out.format("Correntista: %s \n", pair.getValue().getNomeCorrentista());
                        System.out.format("Agencia: %d \n", pair.getValue().getCodigoAgencia());
                        System.out.format("Número: %d \n", pair.getValue().getNumero());
                        System.out.format("Saldo: %s \n", pair.getValue().getSaldo());
                        System.out.println("-------");
                    }
                    System.out.println("---------------");
                    break;
                case 6:
                    System.out.println("---------------");
                    System.out.println("Opçao atual: Inserir nova conta");

                    Agencia agenciaBeltrano = new Agencia("Carlos Luz", 3);
                    Correntista correntistaBeltrano = new Correntista("Maria");
                    ContaCorrente contaCorrenteBeltrano= new ContaCorrente(agenciaBeltrano, correntistaBeltrano);
                    banco.adicionarContaCorrente(contaCorrenteBeltrano);
                    break;
                case 7:
                    System.out.println("---------------");
                    System.out.println("Opçao atual: Pesquisar por conta");
                    System.out.println("Digite o código da agencia");
                    Integer codigoContaBusca = in.nextInt();
                    System.out.println("Digite o número da conta");
                    Integer numeroDaConta = in.nextInt();

                    try {
                        ContaCorrente contaBuscada = banco.buscarPorContaCorrente(codigoContaBusca, numeroDaConta);
                        System.out.format("contaBuscada: %s \n", contaBuscada.getNomeCorrentista());
                    } catch(Exception e) {
                        System.out.println("Conta não encontrada");
                    }
                    break;
                case 8:
                    System.out.println("---------------");
                    System.out.println("Opçao atual: Encerrar conta");
                    System.out.println("Digite o código da agencia");
                    Integer codigoContaEncerrar = in.nextInt();
                    System.out.println("Digite o número da conta");
                    Integer numeroDaContaEncerrar = in.nextInt();

                    try {
                        ContaCorrente contaBuscadaParaEncerrar = banco.buscarPorContaCorrente(codigoContaEncerrar, numeroDaContaEncerrar);
                        banco.removerContaCorrente(contaBuscadaParaEncerrar);
                        System.out.format("Conta encerrada: %s \n", contaBuscadaParaEncerrar.getNomeCorrentista());
                    } catch(Exception e) {
                        System.out.println("Conta não encontrada");
                    }
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
        System.out.println("4: Extrato");
        System.out.println("5: Exibir todas as contas correntes");
        System.out.println("6: Inserir nova conta");
        System.out.println("7: Pesquisar por conta");
        System.out.println("8: Encerrar conta");
        System.out.println("9: Encerrar Terminal");
    }
}


