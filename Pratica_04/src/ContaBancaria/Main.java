package ContaBancaria;

import java.text.SimpleDateFormat;
import java.util.Date;
class Conta {
    private double saldo;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimeExtrato() // Método abstrato sem conteúdo
    {

    }
}

class ContaPoupanca extends Conta {

    public void imprimeExtrato() {
        System.out.println("### Extrato da Conta ###");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("Saldo: R$" + getSaldo());
        System.out.println("Data: " + sdf.format(date));
    }
}


class Main {
    public static void main(String[] args) {
        Conta cp = new ContaPoupanca();
        cp.setSaldo(2121);
        cp.imprimeExtrato();
    }
}
