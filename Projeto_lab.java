package projeto_labii;

import java.util.Scanner;

public class Projeto_lab {
  public static Scanner informacoes;

  public static void main(String[] args) {
    disciplina materia = new disciplina();
    Scanner informacoes = new Scanner(System.in);
    int quantidade_alunos = 3;
    System.out.println("Insira a matéria:");
    materia.disciplina = informacoes.next();
    String nome[] = new String[quantidade_alunos];
    int i;
    int j;
    int quantidade_notas = 3;
    System.out.println("Insira os nomes dos alunos:");
    for (i = 0; i < nome.length; i++) {
      nome[i] = informacoes.next();
    }
    double notasdosalunos[][] = new double[quantidade_notas][quantidade_alunos];

    for (i = 0; i < nome.length; i++) {
      System.out.println("Insira as notas do aluno " + nome[i] + ":");
      for (j = 0; j < notasdosalunos.length; j++) {
        notasdosalunos[i][j] = informacoes.nextDouble();

      }
    }
    for (i = 0; i < nome.length; i++) {
      System.out.println("Notas do aluno " + nome[i] + ":");
      for (j = 0; j < notasdosalunos.length; j++) {
        System.out.println(notasdosalunos[i][j]);
      }

    }
    double[] media_estudantes = media(notasdosalunos, nome);
    for (i = 0; i < media_estudantes.length; i++) {
      System.out.println("---Média do aluno " + nome[i] + "---");
      System.out.println(media_estudantes[i]);

    }

    aprovacao(media_estudantes, nome, materia);

  }

  public static double[] media(double notasdosalunos[][], String nome[]) {
    int i;
    int j;
    double mediadosalunos[] = new double[3];
    double somatorio = 0;
    for (i = 0; i < nome.length; i++) {
      somatorio = 0;
      for (j = 0; j < notasdosalunos.length; j++) {
        somatorio += notasdosalunos[i][j];
      }
      mediadosalunos[i] = somatorio / mediadosalunos.length;

    }

    return mediadosalunos;
  }

  public static void aprovacao(double media_estudantes[], String nome[], disciplina materia) {
    int i;
    for (i = 0; i < nome.length; i++) {
      if (media_estudantes[i] > 7.0) {
        System.out.println("Situação do aluno " + nome[i] + ":" + "Aluno aprovado na disciplina " + materia.disciplina);
      } else if (media_estudantes[i] < 7.0 && media_estudantes[i] >= 5.0) {
        System.out.println("Situação do aluno " + nome[i] + ":" + "Aluno na final na disciplina " + materia.disciplina);
      } else if (media_estudantes[i] < 5.0) {
        System.out
            .println("Situação do aluno " + nome[i] + ":" + "Aluno reprovado na disciplina " + materia.disciplina);
      }
    }
  }
}
