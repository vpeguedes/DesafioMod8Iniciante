package Mentorama.DesafioMod8Resolvido;

import Mentorama.DesafioMod8Resolvido.DB.ContasDB;
import Mentorama.DesafioMod8Resolvido.Models.Conta;
import Mentorama.DesafioMod8Resolvido.Models.ContaCorrente;
import Mentorama.DesafioMod8Resolvido.Models.ContaPoupanca;
import Mentorama.DesafioMod8Resolvido.Models.ContaSalario;

import java.text.ParseException;
import java.util.Scanner;

public class TestaConta {

    static ContasDB contasDB = new ContasDB();

    public static void main(String[] args) throws Exception {

        int opcao;

        do{
            System.out.println("1 - Cadastrar Conta Corrente");
            System.out.println("2 - Cadastrar Conta Poupança");
            System.out.println("3 - Cadastrar Conta Salario");
            System.out.println("4 - Lista de Contas");
            System.out.println("5 - Transferencia de Saldo");
            System.out.println("6 - Exibir saldo total do banco");
            System.out.println("0 - Sair");

            System.out.print("\nSelecione uma opção: ");

            Scanner entrada = new Scanner(System.in);
            opcao = entrada.nextInt();

            processar(opcao);
        } while (opcao != 0);
    }

    private static void processar(int opcao) throws ParseException {
        switch (opcao) {
            case 1: {
                System.out.println("\n---------------------------");
                System.out.println("Cadastro de Conta Corrente");
                Scanner entrada = new Scanner(System.in);
                System.out.print("Nome do banco: ");
                String banco = entrada.next();
                System.out.print("Numero da agencia: ");
                int numeroAgencia = entrada.nextInt();
                System.out.print("Numero da conta: ");
                int numeroConta = entrada.nextInt();
                System.out.print("Saldo inicial: ");
                double saldo = entrada.nextDouble();
                System.out.print("Limite disponivel: ");
                double chequeEspecial = entrada.nextDouble();
                System.out.print("Taxa da conta: ");
                double taxaConta = entrada.nextDouble();
                System.out.println("\n----------------------------");

                Conta contaCorrente = new ContaCorrente(banco, numeroAgencia, numeroConta, saldo, chequeEspecial, taxaConta);
                contasDB.addNovaConta(contaCorrente);

                break;
            }

            case 2: {
                System.out.println("\n---------------------------");
                System.out.println("Cadastro de Conta Poupança");
                Scanner entrada = new Scanner(System.in);
                System.out.print("Nome do banco: ");
                String banco = entrada.next();
                System.out.print("Numero da agencia: ");
                int numeroAgencia = entrada.nextInt();
                System.out.print("Numero da conta: ");
                int numeroConta = entrada.nextInt();
                System.out.print("Saldo inicial: ");
                double saldo = entrada.nextDouble();
                System.out.print("Rendimento da conta: ");
                double rendimento = entrada.nextDouble();
                System.out.println("\n---------------------------");

                Conta contaPoupanca = new ContaPoupanca(banco, numeroAgencia, numeroConta, saldo, rendimento);
                contasDB.addNovaConta(contaPoupanca);

                break;
            }

            case 3: {
                System.out.println("\n---------------------------");
                System.out.println("Cadastro de Conta Salario");
                Scanner entrada = new Scanner(System.in);
                System.out.print("Nome do banco: ");
                String banco = entrada.next();
                System.out.print("Numero da agencia: ");
                int numeroAgencia = entrada.nextInt();
                System.out.print("Numero da conta: ");
                int numeroConta = entrada.nextInt();
                System.out.print("Saldo inicial: ");
                double saldo = entrada.nextDouble();
                System.out.print("Limite de saques: ");
                int limiteSaques = entrada.nextInt();
                System.out.print("Taxa da conta: ");
                double taxaConta = entrada.nextDouble();
                System.out.println("\n---------------------------");

                Conta contaSalario = new ContaSalario(banco, numeroAgencia, numeroConta, saldo, limiteSaques, taxaConta);
                contasDB.addNovaConta(contaSalario);

                break;
            }

            case 4: {
                System.out.println("\n---------------------------");
                System.out.println("----- Lista de contas cadastradas -----");

                for(Conta conta : contasDB.getContas())
                    System.out.println(conta.toString());
                    System.out.println("\n---------------------------------------");

                break;
            }

            case 5: {
                System.out.println("\n---------------------------");
                System.out.println("Transferencia de saldo entre contas");

                Scanner entrada = new Scanner(System.in);

                System.out.print("Valor da transferência: ");
                double valor = entrada.nextDouble();
                System.out.print("Numero da conta de destino: ");
                int transferenciaDestino = entrada.nextInt();
                System.out.print("Numero da conta de origem: ");
                int transferenciaOrigem = entrada.nextInt();
                System.out.println("---------------------------");

                Conta contaOrigem = contasDB.getContaPorNumero(transferenciaOrigem);
                Conta contaDestino = contasDB.getContaPorNumero(transferenciaDestino);

                contaOrigem.transferir(contaOrigem, contaDestino, valor);
                System.out.println("-----------------------------------");
                System.out.println("Saldo da conta de orgiem: " + contaOrigem.getNumeroConta() + " " + contaOrigem.getSaldo());
                System.out.println("Saldo da conta de destino: " + contaDestino.getNumeroConta() + " " + contaDestino.getSaldo());
                System.out.println("\n-----------------------------------");

                break;
                }

            case 6: {
                System.out.println("\n---------------------------");
                System.out.println("Saldo total do banco");
                double saldoTotal = 0;

                for(Conta conta : contasDB.getContas()){
                    saldoTotal += conta.getSaldo();
                }

                System.out.println("Valor total das contas no banco é: " + saldoTotal);
                System.out.println("---------------------------");
                System.out.println("\n");

                break;
            }
        }
    }
}
