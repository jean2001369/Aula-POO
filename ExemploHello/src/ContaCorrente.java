public class ContaCorrente {
    // atributos

    private long numero;

    private String nome;

    private int agencia;

    private double saldo;

    public void cadastrar(long num, String nomePessoa, int ag){

        numero=num;
        nome=nomePessoa;
        agencia=ag;
        saldo=0;

    }

    //metodos

    public void depositar(double valor){

        saldo += valor;
    }
    public void sacar(double valor){
        if(valor<=saldo)
            saldo -= valor;
        else
            System.out.println("Saldo insuficiente");
    }
    public double ConsultaSaldo(){
        return (saldo);
    }
}
