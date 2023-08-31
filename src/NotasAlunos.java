import java.util.Locale;
import java.util.Scanner;
public class NotasAlunos {
    class Aluno {
        private String nome;
        private int matricula;
        private double notaAV1;
        private double notaAV2;
        private double notaAE;
        private String curso;
        private int periodo;


        public Aluno(String nome, int matricula, double notaAV1, double notaAV2, String curso, int periodo) {
            this.nome = nome;
            this.matricula = matricula;
            this.notaAV1 = notaAV1;
            this.notaAV2 = notaAV2;
            this.curso = curso;
            this.periodo = periodo;
        }


        public void alteraNotaAV1(double novaNota) {
            this.notaAV1 = novaNota;
        }

        public void alteraNotaAV2(double novaNota) {
            this.notaAV2 = novaNota;
        }

        public void alteraNotaAE(double novaNota) {
            this.notaAE = novaNota;
        }


        public void avaliarAluno() {
            double notaTotal = notaAV1 + notaAV2;
            if (notaTotal >= 60) {
                System.out.println("Situação: Aprovado");
            } else {
                System.out.println("Situação: Recuperação");
            }
        }


        public void avaliarRecuperacao(double notaAE) {
            double notaMedia = (notaAV1 + notaAV2 + notaAE) / 3;
            if (notaMedia >= 60) {
                System.out.println("Situação na recuperação: Aprovado");
            } else {
                System.out.println("Situação na recuperação: Reprovado");
            }
        }

        public static void main(String[] args) {

            Aluno aluno = new Aluno("Maria", 12345, 70, 50, "Engenharia", 3);

            aluno.avaliarAluno();

            aluno.alteraNotaAE(40);

            aluno.avaliarRecuperacao(aluno.notaAE);
        }
    }



}
