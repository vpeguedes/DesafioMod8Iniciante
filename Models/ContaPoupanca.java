package Mentorama.DesafioMod8Resolvido.Models;


public class ContaPoupanca extends Conta {

    private double rendimento;

    public ContaPoupanca(String banco, int numeroAgencia, int numeroConta, double saldo, double rendimento) {
        super(banco, numeroAgencia, numeroConta, saldo);
        this.rendimento = rendimento;
    }

    public void sacar(double valor) {
        if (super.saldo > valor) {
            double novoSaldo = super.saldo - valor;
            super.setSaldo(novoSaldo);
        } else {
            System.out.println("Saldo insuficiente");
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
    public String toString() {
        return "Conta corrente - Banco: " + super.getBanco() + "\nNumero da agencia: " + super.getNumeroAgencia() +
                "\nNumero da conta: " + super.getNumeroConta() + "\nSaldo: " + getSaldo();
    }
}
