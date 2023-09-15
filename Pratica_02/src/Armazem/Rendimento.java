import java.text.NumberFormat;

public class Rendimento_01 {
    private double investInicial;
    private double taxaRendimento;
    private int numMeses;

    public Rendimento_01(double investInicial, double taxaRendimento, int numMeses) {
        this.investInicial = investInicial;
        this.taxaRendimento = taxaRendimento;
        this.numMeses = numMeses;
    }

    public double getInvestInicial() {
        return investInicial;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public int getNumMeses() {
        return numMeses;
    }

    public void calculaRendimento() {
        double rendimentoMes;
        rendimentoMes = getInvestInicial();
        System.out.println("Valor Inicial: " + NumberFormat.getCurrencyInstance().format(getInvestInicial()));
        System.out.println("Taxa de Juros: " + NumberFormat.getPercentInstance().format(getTaxaRendimento()/100));
        for (int i=0;i<getNumMeses();i++)
        {
            rendimentoMes = rendimentoMes * getTaxaRendimento()/100+rendimentoMes;
            System.out.println("Mês " + (i+1) + ": " + NumberFormat.getCurrencyInstance().format(rendimentoMes));
        }
    }
}
