package contas;

import pessoas.ClientePessoaFisica;

public class ContaEspecial extends Conta {
    private double limite;
    private double MIN_SALDO = 200.0;

    public ContaEspecial(int numero, double saldo, Agencia agencia, double limite) {
        super(numero, saldo, agencia);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getMIN_SALDO() {
        return MIN_SALDO;
    }

    public void setMIN_SALDO(double MIN_SALDO) {
        this.MIN_SALDO = MIN_SALDO;
    }

    @Override
    public void debita(double valor) {
        if ((getSaldo() + limite - valor) < MIN_SALDO) {
            System.out.println("Saldo Insuficiente.");
        } else {
            setSaldo(getSaldo() - valor);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Limite: " + limite + "\n" +
                "Saldo Mínimo: " + MIN_SALDO;
    }
}
