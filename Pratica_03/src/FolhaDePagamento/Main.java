package FolhaDePagamento;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a matrícula do funcionário:");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.println("Digite o nome do funcionário:");
        String nome = scanner.nextLine();

        System.out.println("Digite o salário fixo do funcionário:");
        double salario = scanner.nextDouble();

        System.out.println("Escolha o tipo de funcionário:");
        System.out.println("1 - Funcionário Padrão");
        System.out.println("2 - Funcionário de Produtividade");
        System.out.println("3 - Funcionário Comissionado");
        int tipoFuncionario = scanner.nextInt();

        Funcionario funcionario;

        switch (tipoFuncionario) {
            case 1:
                funcionario = new Funcionario(matricula, nome, salario);
                break;
            case 2:
                System.out.println("Digite o valor por unidade produzida:");
                double valorProdutividade = scanner.nextDouble();
                System.out.println("Digite a quantidade de unidades produzidas:");
                int producao = scanner.nextInt();
                funcionario = new Produtividade(matricula, nome, salario, valorProdutividade, producao);
                break;
            case 3:
                System.out.println("Digite o percentual de comissão:");
                double percentualComissao = scanner.nextDouble();
                System.out.println("Digite o valor das vendas:");
                double vendas = scanner.nextDouble();
                funcionario = new Comissao(matricula, nome, salario, percentualComissao, vendas);
                break;
            default:
                System.out.println("Tipo de funcionário inválido");
                return;
        }

        double proventos = funcionario.calcularProventos();
        System.out.println("Proventos de " + funcionario.getNome() + ": R$" + proventos);

    }
}
class Funcionario {
    private int matricula;
    private String nome;
    private double salario;

    public Funcionario(int matricula, String nome, double salario) {
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double calcularProventos() {
    }
}

class Comissao extends Funcionario {
    private double percentual;
    private double vendas;

    public Comissao(int matricula, String nome, double salario, double percentual, double vendas) {
        super(matricula, nome, salario);
        this.percentual = percentual;
        this.vendas = vendas;
    }

    public double getPercentual() {
        return percentual;
    }

    public double getVendas() {
        return vendas;
    }

    public double calcularProventos() {
        return getSalario() + (percentual / 100) * vendas;
    }
}

class Produtividade extends Funcionario {
    private double valor;
    private int producao;

    public Produtividade(int matricula, String nome, double salario, double valor, int producao) {
        super(matricula, nome, salario);
        this.valor = valor;
        this.producao = producao;
    }

    public double getValor() {
        return valor;
    }

    public int getProducao() {
        return producao;
    }

    public double calcularProventos() {
        return getSalario() + valor * producao;
      }
}