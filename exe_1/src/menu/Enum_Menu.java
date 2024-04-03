package menu;

public enum Enum_Menu {
    CADASTRAR(1, "Cadastrar Cliente Pessoa Física"),
    PESQUISAR_NOME(2, "Pesquisar Cliente Pessoa Física pelo nome"),
    PESQUISAR_CFP(3, "Pesquisar Cliente Pessoa Física pelo CPF"),
    PESQUISAR_NUM_CONTA(4, "Pesquisar Cliente Pessoa Física pelo número da conta"),
    LISTAR_CLIENTES_AGENCIA(5, "Listar todos os clientes de uma mesma agência"),
    LISTAR_TODOS_CLIENTES(6, "Listar todos os clientes"),
    SAIR(7, "Sair");

    private final int valor;
    private final String descricao;

    Enum_Menu(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
