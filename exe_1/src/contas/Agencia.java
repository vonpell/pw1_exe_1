package contas;

public class Agencia {
    private String nome;
    private long numero;

    public Agencia() {
    }

    public Agencia(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Nome da Agência: " + nome + "\n" +
               "Número da Agência: " + numero;
    }
}
