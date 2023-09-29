package CbInterface;

public class Main {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente();
        cc.depositar(1200.20);
        cc.sacar(300);

        ContaPoupanca cp = new ContaPoupanca();
        cp.depositar(500.50); 
        cp.sacar(25);

        GeradorExtrato gerador = new GeradorExtrato();
        gerador.geradorConta(cc);
        gerador.geradorConta(cp);
    }
}
