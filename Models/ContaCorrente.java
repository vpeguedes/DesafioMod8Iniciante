package Mentorama.DesafioMod8Resolvido.Models;

public class ContaCorrente extends Conta implements Tributavel{
    private double chequeEspecial;
    private double taxaImposto;

    public ContaCorrente(String banco, int numeroAgencia, int numeroConta, double saldo, double chequeEspecial, double taxaImposto) {
        super(banco, numeroAgencia, numeroConta, saldo);
        this.chequeEspecial = chequeEspecial;
        this.taxaImposto = taxaImposto;
    }

    public void sacar(double valor) {
        if(valor == saldo) {
            processarSaque(valor);
            System.out.println("Você entrou no limite do cheque especial da sua conta");
        } else if (valor == super.saldo + this.chequeEspecial) {
            processarSaque(valor);
            System.out.println("Voce está usando o limite so seu cheque especial");
        } else if(valor < super.saldo + this.chequeEspecial) {
            processarSaque(valor);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void processarSaque(double valor) {
        double novoSaldo = super.saldo - valor;
        super.setSaldo(novoSaldo);
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
                "\nNumero da conta: " + super.getNumeroConta() + "\nSaldo: " + getSaldo() + "\nCheque especial: " +
                chequeEspecial;
    }
}
