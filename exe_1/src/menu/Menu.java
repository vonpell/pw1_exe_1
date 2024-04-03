package menu;

import contas.Agencia;
import contas.ContaCorrente;
import contas.ContaEspecial;
import documentos.Cpf;
import pessoas.ClientePessoaFisica;

import javax.swing.*;
import java.util.ArrayList;

public class Menu {

    public static void main(String[] args) {
        ArrayList<Agencia> agencias = new ArrayList<Agencia>();
        ArrayList<ClientePessoaFisica> listaClientes = new ArrayList<>();
        Agencia ag1 = new Agencia("Agência Azenha", 400);
        Agencia ag2 = new Agencia("Agência Menino Deus", 401);
        Agencia ag3 = new Agencia("Agência Cidade Baixa", 402);
        agencias.add(ag1);
        agencias.add(ag2);
        agencias.add(ag3);

        String aux = "";
        for (Enum_Menu enum_menu : Enum_Menu.values()) {
            aux += enum_menu.getValor() + " - " + enum_menu.getDescricao() + '\n';
        }

        while (true) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, aux));
            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Informe o nome: ");
                    long numCpf = Long.parseLong(JOptionPane.showInputDialog("Informe o número do CPF: "));
                    int digitoCpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o dígito do CPF: "));
                    int opcao2 = 3;
                    while (opcao2 != 1 && opcao2 != 2) {
                        opcao2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite 1 para conta corrente ou 2 para conta especial: "));
                        switch (opcao2) {
                            case 1:
                                int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
                                double saldo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do saldo: "));
                                int agAux1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da Agência: "));
                                Agencia agenciaAux = new Agencia();
                                for (Agencia agencia : agencias) {
                                    if (agAux1 == agencia.getNumero()) {
                                        agenciaAux = agencia;
                                    }
                                }
                                ClientePessoaFisica cli = new ClientePessoaFisica(nome, new Cpf(numCpf, digitoCpf), new ContaCorrente(numero, saldo, agenciaAux));
                                listaClientes.add(cli);
                                System.out.println(cli);
                                break;
                            case 2:
                                int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
                                double saldo2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do saldo: "));
                                int agAux2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da Agência: "));
                                Agencia agenciaAux2 = new Agencia();
                                for (Agencia agencia : agencias) {
                                    if (agAux2 == agencia.getNumero()) {
                                        agenciaAux2 = agencia;
                                    }
                                }
                                double limite = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do limite: "));
                                ClientePessoaFisica cli2 = new ClientePessoaFisica(nome, new Cpf(numCpf, digitoCpf), new ContaEspecial(numero2, saldo2, agenciaAux2, limite));
                                listaClientes.add(cli2);
                                System.out.println(cli2);
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida.");
                        }
                    }
                    break;

                case 2:
                    String pesquisaNome = JOptionPane.showInputDialog("Informe o nome a ser pesquisado: ");
                    boolean flag = false;
                    for (ClientePessoaFisica clientePessoaFisica : listaClientes) {
                        if (clientePessoaFisica != null) {
                            if (clientePessoaFisica.getNome().equals(pesquisaNome)) {
                                JOptionPane.showMessageDialog(null, pesquisaNome + " encontrado.");
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (!flag) {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                    break;

                case 3:
                    long procuraNumCpf = Long.parseLong(JOptionPane.showInputDialog("Informe o número do CPF: "));
                    int procuraDigitoCpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o dígito do CPF: "));
                    flag = false;
                    for (ClientePessoaFisica clientePessoaFisica : listaClientes) {
                        if (clientePessoaFisica != null) {
                            System.out.println(clientePessoaFisica.getCpf());
                            if (new Cpf(procuraNumCpf, procuraDigitoCpf).equals(clientePessoaFisica.getCpf())) {
                                flag = true;
                                JOptionPane.showMessageDialog(null, "CPF encontrado, pertence a: " +
                                        clientePessoaFisica.getNome());
                            }
                        }
                    }
                    if (!flag) {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                    break;

                case 4:
                    int procuraConta = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
                    flag = false;
                    for (ClientePessoaFisica clientePessoaFisica : listaClientes) {
                        if (clientePessoaFisica != null) {
                            if (clientePessoaFisica.getConta().getNumero() == procuraConta) {
                                flag = true;
                                JOptionPane.showMessageDialog(null, "Conta encontrada, pertence a: " +
                                        clientePessoaFisica.getNome());
                            }
                        }
                    }
                    if (!flag) {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada.");
                    }
                    break;

                case 5:
                    int procuraAgencia = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da agência: "));
                    String auxClienteAgencia = "";
                    flag = false;
                    for (ClientePessoaFisica clientePessoaFisica : listaClientes) {
                        if (clientePessoaFisica != null) {
                            if (clientePessoaFisica.getConta().getAgencia().getNumero() == procuraAgencia) {
                                flag = true;
                                auxClienteAgencia += clientePessoaFisica.toString() + "\n";
                            }
                        }
                    }
                    if (flag) {
                        System.out.println(auxClienteAgencia);
                    } else {
                        JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado nesta agência.");
                    }
                    break;

                case 6:
                    for (ClientePessoaFisica clientePessoaFisica : listaClientes) {
                        if (clientePessoaFisica != null) {
                            JOptionPane.showMessageDialog(null, clientePessoaFisica.toString());
                        }
                    }
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }
}
