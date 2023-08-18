public class Main {
    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente(); // Cria um objeto do  tipo "c1" chamado ContaCorrente

        // Dados mocados

        c1.cadastrar(123,"Ana",789);
        c1.depositar(1000);

        System.out.println("Saldo da conta: " + c1.ConsultaSaldo());
        c1.sacar(900);
        System.out.println("Saldo da conta: " + c1.ConsultaSaldo());
    }
}