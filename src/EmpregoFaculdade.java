import java.util.Locale;
import java.util.Scanner;
public class EmpregadoFaculdade {
    class EmpregadoDaFaculdade {
        private String nome;
        private double salario;
        private int horasAula;

        // Construtor da classe
        public EmpregadoDaFaculdade(String nome, double salario, int horasAula) {
            this.nome = nome;
            this.salario = salario;
            this.horasAula = horasAula;
        }

        double getGastos() {
            // Agora somamos o bônus de R$ 40 por hora/aula ao salário
            return this.salario + (40 * this.horasAula);
        }

        String getInfo() {
            // Retornamos a informação com o valor atualizado (salário + bônus)
            return "nome: " + this.nome + " com salário: " + getGastos();
        }

        public static void main(String[] args) {
            // Criando um objeto EmpregadoDaFaculdade
            EmpregadoDaFaculdade empregado = new EmpregadoDaFaculdade("João", 2000, 10);

            // Exibindo os resultados dos métodos
            System.out.println("Gastos: " + empregado.getGastos());
            System.out.println("Informações: " + empregado.getInfo());
        }
    }
}