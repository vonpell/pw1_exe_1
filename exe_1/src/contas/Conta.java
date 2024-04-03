package contas;

import pessoas.ClientePessoaFisica;

public abstract class Conta {

    private int numero;
    private double saldo;
    private Agencia agencia;

    public Conta(int numero, double saldo, Agencia agencia) {
        this.numero = numero;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public double credita(double valor) {
        return saldo += valor;
    }

    public abstract void debita(double valor);

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Conta: " + numero + "\n" +
               "Saldo: " + saldo +  "\n" +
                agencia.toString();
    }
}
