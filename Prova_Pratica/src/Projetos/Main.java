package Projetos;

import javax.swing.JOptionPane;

abstract class Projeto {
    private String nomeProjeto;
    private String descricao;
    private String endereco;
    private String dataInicio;
    private String dataFim;

    public Projeto(String nomeProjeto, String descricao, String endereco, String dataInicio, String dataFim) {
        this.nomeProjeto = nomeProjeto;
        this.descricao = descricao;
        this.endereco = endereco;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public abstract boolean validaProjeto(String nomeProjeto);

    public abstract String imprimeProjeto();
}

class DistribuicaoAlimento extends Projeto {
    private String descAlimento;
    private float qtde;

    public DistribuicaoAlimento(String nomeProjeto, String descricao, String endereco, String dataInicio,
    String dataFim, String descAlimento, float qtde) {
        super(nomeProjeto, descricao, endereco, dataInicio, dataFim);
        this.descAlimento = descAlimento;
        this.qtde = qtde;
    }

    public boolean validaProjeto(String nomeProjeto) {
        return getDataFim().isEmpty();
    }

    public String imprimeProjeto() {
        return "Nome do Projeto: " + getNomeProjeto() + "\nDescrição: " + getDescricao() + "\nData de Início: "
        + getDataInicio() + "\nData de Fim: " + getDataFim() + "\nDescrição do Alimento: " + descAlimento
        + "\nQuantidade: " + qtde;
    }
}

class TrabalhoVoluntario extends Projeto {
    private String tipoTrabalho;
    private int duracaoTrabalho;

    public TrabalhoVoluntario(String nomeProjeto, String descricao, String endereco, String dataInicio,
    String dataFim, String tipoTrabalho, int duracaoTrabalho) {
        super(nomeProjeto, descricao, endereco, dataInicio, dataFim);
        this.tipoTrabalho = tipoTrabalho;
        this.duracaoTrabalho = duracaoTrabalho;
    }

    public boolean validaProjeto(String nomeProjeto) {
        return duracaoTrabalho > 2;
    }

    public String imprimeProjeto() {
        return "Nome do Projeto: " + getNomeProjeto() + "\nDescrição: " + getDescricao() + "\nData de Início: "
        + getDataInicio() + "\nData de Fim: " + getDataFim() + "\nTipo de Trabalho: " + tipoTrabalho
        + "\nDuração do Trabalho (horas): " + duracaoTrabalho;
    }
}

class ProjetoSocial {
    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção:\n1- Distribuição de Alimentos" +
            "\n2- Trabalho Voluntário\n3- Sair"));
            switch (opcao) {
                case 1:
                    DistribuicaoAlimento distribuicaoAlimento = new DistribuicaoAlimento("Alimentação",
                    "Distribuição de alimentos para famílias carentes", "Rua A", "2023-10-05", "", "Comida", 500);

                    boolean valido1 = distribuicaoAlimento.validaProjeto(distribuicaoAlimento.getNomeProjeto());
                    if (valido1) {
                        JOptionPane.showMessageDialog(null, distribuicaoAlimento.imprimeProjeto());
                    } else {
                        JOptionPane.showMessageDialog(null, "Projeto inválido.");
                    }
                    break;
                case 2:
                    TrabalhoVoluntario trabalhoVoluntario = new TrabalhoVoluntario("Voluntariado",
                    "Ajuda em eventos comunitários", "Rua B", "2023-10-10", "", "Assistência Social", 3);

                    boolean valido2 = trabalhoVoluntario.validaProjeto(trabalhoVoluntario.getNomeProjeto());
                    if (valido2) {
                        JOptionPane.showMessageDialog(null, trabalhoVoluntario.imprimeProjeto());
                    } else {
                        JOptionPane.showMessageDialog(null, "Projeto inválido.");
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opcao != 3);
    }
}
