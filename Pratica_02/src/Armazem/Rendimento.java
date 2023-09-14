package Armazem;

import java.util.Scanner;

public class Rendimento {
    private double investimentoInicial;
    private double taxaMensal;
    private int numeroMeses;

    public Rendimento(double investimentoInicial, double taxaMensal, int numeroMeses) {
        this.investimentoInicial = investimentoInicial;
        this.taxaMensal = taxaMensal;
        this.numeroMeses = numeroMeses;
    }

    public void Rendimento() {
        double rendimento = investimentoInicial;
        for (int i = 0; i < numeroMeses; i++) {
            rendimento += rendimento * (taxaMensal / 100); // Calcula o rendimento mensal
        }
        System.out.println("O rendimento após " + numeroMeses + " meses será de: " + rendimento);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o valor do investimento inicial: ");
        double investimentoInicial = scanner.nextDouble();

        System.out.print("Informe a taxa mensal de rendimento (%): ");
        double taxaMensal = scanner.nextDouble();

        System.out.print("Informe o número de meses: ");
        int numeroMeses = scanner.nextInt();

        Rendimento calculadora = new Rendimento(investimentoInicial, taxaMensal, numeroMeses);

        calculadora.Rendimento();

        scanner.close();
    }
}

