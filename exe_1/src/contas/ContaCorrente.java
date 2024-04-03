package contas;

import pessoas.ClientePessoaFisica;

public class ContaCorrente extends Conta {
    private double MIN_SALDO = 100.0;

    public ContaCorrente(int numero, double saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    public double getMIN_SALDO() {
        return MIN_SALDO;
    }

    public void setMIN_SALDO(double MIN_SALDO) {
        this.MIN_SALDO = MIN_SALDO;
    }

    @Override
    public void debita(double valor) {
        if ((getSaldo() - valor) < MIN_SALDO) {
            System.out.println("Saldo Insuficiente.");
        } else {
            setSaldo(getSaldo() - valor);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nSaldo Mínimo: " + MIN_SALDO;
    }
}
