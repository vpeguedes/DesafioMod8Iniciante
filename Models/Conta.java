package Mentorama.DesafioMod8Resolvido.Models;

public abstract class Conta {

    private String banco;
    private int numeroAgencia;
    private int numeroConta;
    protected double saldo;

    public Conta(String banco, int numeroAgencia, int numeroConta, double saldo) {
        this.banco = banco;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public abstract void sacar(double valor);

    public abstract void depositar(double valor);

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public abstract double getSaldo();

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
        contaOrigem.setSaldo(contaOrigem.saldo - valor);
        contaDestino.setSaldo(contaDestino.saldo + valor);
    }
}
