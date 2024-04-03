package documentos;

public final class Cpf {
    private int ddd;
    private long numero;

    public Cpf() {
    }

    public Cpf(long numero, int ddd) {
        this.numero = numero;
        this.ddd = ddd;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "CPF: " + numero + "-" + ddd;
    }
}
