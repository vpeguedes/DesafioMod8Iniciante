package Mentorama.DesafioMod8Resolvido.Models;

public class ContaSalario extends Conta implements Tributavel{
    private int limiteSaques;
    private int contador;
    private double taxaImposto;

    public ContaSalario(String banco, int numeroAgencia, int numeroConta, double saldo, int limiteSaques, double taxaImposto) {
        super(banco, numeroAgencia, numeroConta, saldo);
        this.limiteSaques = limiteSaques;
        this.taxaImposto = taxaImposto;
    }


        public void sacar(double valor) {
            if(contador < limiteSaques) {
                double novoSaldo = super.saldo - valor;
                super.setSaldo(novoSaldo);
                contador ++;
            } else {
                System.out.println("Limite de saques excedido");
            }
        }

        public void depositar(double valor) {
            double novoSaldo = super.saldo + valor;
            super.setSaldo(novoSaldo);
        }

        public double getSaldo() {
            return this.saldo;
        }

        @Override
        public double getValorImposto() {
            return this.saldo * taxaImposto;
        }

    @Override
    public String toString() {
        return "Conta corrente - Banco: " + super.getBanco() + "\nNumero da agencia: " + super.getNumeroAgencia() +
                "\nNumero da conta: " + super.getNumeroConta() +
                "\nSaldo: " + getSaldo() + "\nLimite de Saques: " + limiteSaques;
    }
    }
