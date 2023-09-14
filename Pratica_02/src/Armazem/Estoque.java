package Armazem;

public class Estoque {
    private boolean Mostra;
    private String nome;
    private int qtdAtual;
    private int qtdMinima;

    public Estoque() {
        nome = "";
        qtdAtual = 0;
        qtdMinima = 0;
    }


    public Estoque(String nome, int qtdAtual, int qtdMinima) {
        this.nome = nome;
        this.qtdAtual = qtdAtual;
        this.qtdMinima = qtdMinima;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }


    public void darBaixa(int qtde) {
        if (qtde <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
        } else if (qtdAtual >= qtde) {
            qtdAtual -= qtde;
            System.out.println("Baixa de " + qtde + " unidades de " + nome + " realizada.");
        } else {
            System.out.println("Não há estoque suficiente de " + nome + " para dar baixa.");
        }
    }


    public String mostra() {
        return "Produto: " + nome + ", Quantidade Atual: " + qtdAtual + ", Quantidade Mínima: " + qtdMinima;
    }


    public boolean precisaRepor() {
        return qtdAtual < qtdMinima;
    }

    public boolean isMostra() {
        return Mostra;
    }

    public void setMostra(boolean mostra) {
        Mostra = mostra;
    }
}
