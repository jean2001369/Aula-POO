package Carnaval;

import java.util.Scanner;

class Ingresso {
    private double valor;

    public Ingresso(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

class Normal extends Ingresso {
    public Normal(double valor) {
        super(valor);
    }

    public void imprimeValor() {
        System.out.println("Carnaval.Ingresso Carnaval.Normal - Valor: R$" + getValor());
    }
}

class VIP extends Ingresso {
    private double valorAdicional;

    public VIP(double valor, double valorAdicional) {
        super(valor);
        this.valorAdicional = valorAdicional;
    }

    public void imprimeValor() {
        double valorTotal = getValor() + valorAdicional;
        System.out.println("Carnaval.Ingresso Carnaval.VIP - Valor: R$" + valorTotal);
    }
}

class Camarote extends Ingresso {
    private String localizacao;
    private double valorAdicional;

    public Camarote(double valor, double valorAdicional, String localizacao) {
        super(valor);
        this.valorAdicional = valorAdicional;
        this.localizacao = localizacao;
    }

    public void imprimeValor() {
        double valorTotal = getValor() + valorAdicional;
        System.out.println("Carnaval.Ingresso Carnaval.Camarote - Localização: " + localizacao + " - Valor: R$" + valorTotal);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("(1) Carnaval.Ingresso Carnaval.Normal");
        System.out.println("(2) Carnaval.Ingresso Carnaval.VIP");
        System.out.println("(3) Carnaval.Ingresso Carnaval.Camarote");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.print("Digite o valor do ingresso normal: R$");
                double valorNormal = scanner.nextDouble();
                Normal ingressoNormal = new Normal(valorNormal);
                ingressoNormal.imprimeValor();
                break;
            case 2:
                System.out.print("Digite o valor do ingresso Carnaval.VIP: R$");
                double valorVIP = scanner.nextDouble();
                System.out.print("Digite o valor adicional do Carnaval.VIP: R$");
                double valorAdicionalVIP = scanner.nextDouble();
                VIP ingressoVIP = new VIP(valorVIP, valorAdicionalVIP);
                ingressoVIP.imprimeValor();
                break;
            case 3:
                System.out.print("Digite o valor do ingresso camarote: R$");
                double valorCamarote = scanner.nextDouble();
                System.out.print("Digite a localização do camarote: ");
                String localizacaoCamarote = scanner.next();
                System.out.print("Digite o valor adicional do camarote: R$");
                double valorAdicionalCamarote = scanner.nextDouble();
                Camarote ingressoCamarote = new Camarote(valorCamarote, valorAdicionalCamarote, localizacaoCamarote);
                ingressoCamarote.imprimeValor();
                break;
            default:
                System.out.println("Opção inválida");
        }

        scanner.close();
    }
}
