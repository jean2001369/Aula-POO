import java.util.Scanner;

class Veiculo {
    private String placa;
    private int ano;

    public Veiculo() {
        this.placa = "";
        this.ano = 0;
    }

    public Veiculo(String placa, int ano) {
        this.placa = placa;
        this.ano = ano;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setAno(String ano) {
        this.ano = Integer.parseInt(ano);
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public void exibirDados() {
        System.out.println("Placa: " + placa + " - Ano: " + ano);
    }
}

class Onibus extends Veiculo {
    private int assentos;

    public Onibus(String placa, int ano, int assentos) {
        super(placa, ano);
        this.assentos = assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    public int getAssentos() {
        return assentos;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Assentos: " + assentos);
    }
}

class Caminhao extends Veiculo {
    private int eixos;

    public Caminhao(String placa, int ano, int eixos) {
        super(placa, ano);
        this.eixos = eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }

    public int getEixos() {
        return eixos;
    }

    public void exibirDados() {
        super.exibirDados();
        System.out.println("Numero de eixos: " + eixos);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe os dados do ônibus:");
        System.out.print("Placa: ");
        String placaOnibus = scanner.nextLine();
        System.out.print("Ano: ");
        int anoOnibus = scanner.nextInt();
        System.out.print("Assentos: ");
        int assentosOnibus = scanner.nextInt();

        Onibus onibus = new Onibus(placaOnibus, anoOnibus, assentosOnibus);

        System.out.println("\nInformações do ônibus:");
        onibus.exibirDados();

        System.out.println("\nInforme os dados do caminhão:");
        System.out.print("Placa: ");
        scanner.nextLine(); // Limpar o buffer
        String placaCaminhao = scanner.nextLine();
        System.out.print("Ano: ");
        int anoCaminhao = scanner.nextInt();
        System.out.print("Número de eixos: ");
        int eixosCaminhao = scanner.nextInt();

        Caminhao caminhao = new Caminhao(placaCaminhao, anoCaminhao, eixosCaminhao);

        System.out.println("\nInformações do caminhão:");
        caminhao.exibirDados();

        scanner.close();
    }
}
