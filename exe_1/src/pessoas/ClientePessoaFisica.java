package pessoas;

import contas.Conta;
import documentos.Cpf;

public class ClientePessoaFisica {
    private Cpf cpf;
    private String nome;
    private Conta conta;
    private int contador = 0;

    public ClientePessoaFisica() {
        this(null, null, null);
    }

    public ClientePessoaFisica(String nome, Cpf cpf, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
        this.contador += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getContador() {
        return contador;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Nome do Cliente: " + nome + "\n" + cpf.toString() + "\n" + conta.toString();
    }
}
