package com.jpa;

import java.util.List;
import java.util.Scanner;

import com.jpa.dao.AlunoDAO;
import com.jpa.dao.AlunoJPA;
import com.jpa.entity.Aluno;

public class App {
  public static void main( String[] args ) {
    AlunoDAO alunoDAO = new AlunoJPA();

    int input = 1;

    Scanner in = new Scanner(System.in);

    while (input != 0) {
      System.out.println();
      System.out.println("--- Menu ---");
      System.out.println("1. Adicionar aluno");
      System.out.println("2. Editar aluno");
      System.out.println("3. Deletar aluno");
      System.out.println("4. Visualizar lista de alunos");
      System.out.println("0. Sair");

      System.out.print("Escolha uma opção: ");
      input = Integer.parseInt(in.nextLine());
      
      switch (input) {
        case 1: adicionarAluno(in, alunoDAO); break;
        case 2: editarAluno(in, alunoDAO); break;
        case 3: deletarAluno(in, alunoDAO); break;
        case 4: listarAlunos(alunoDAO); break;
        case 0: break;

        default:
          System.out.println();
          System.out.println("Opção inválida!");
          break;
      }
    }

    System.out.println();
    System.out.println("Encerrando...");
    in.close();
  }

  public static void adicionarAluno(Scanner in, AlunoDAO alunoDAO) {
    System.out.println("\nPreencha as informações do aluno");
    System.out.print("Matrícula: ");
    String matricula = in.nextLine();
    System.out.print("Nome: ");
    String nome = in.nextLine();
    System.out.print("CPF: ");
    String cpf = in.nextLine();
    System.out.print("Email: ");
    String email = in.nextLine();

    Aluno aluno = new Aluno(null, Integer.parseInt(matricula), nome, cpf, email);

    alunoDAO.adicionaAluno(aluno);
  }

  public static void listarAlunos(AlunoDAO alunoDAO) {
    List<Aluno> alunos = alunoDAO.getListaAluno();

    System.out.println();
    for (Aluno aluno : alunos) {
      System.out.println(aluno.toString());
    }
  }

  public static void deletarAluno(Scanner in, AlunoDAO alunoDAO) {
    listarAlunos(alunoDAO);

    System.out.print("\nDigite o ID do aluno a ser deletado: ");
    alunoDAO.deletarAluno(Integer.parseInt(in.nextLine()));
  }

  public static void editarAluno(Scanner in, AlunoDAO alunoDAO) {
    listarAlunos(alunoDAO);

    System.out.print("\nDigite o ID ao aluno a ser editado: ");
    Aluno aluno = alunoDAO.getAluno(Integer.parseInt(in.nextLine()));

    System.out.println("\nVocê selecionou: \n");
    System.out.println(aluno.getNome());
    System.out.println(aluno.toString());

    Integer matricula = aluno.getMatricula();
    String nome = aluno.getNome();
    String cpf = aluno.getCpf();
    String email = aluno.getEmail();

    Integer input = 1;

    while (input != 0) {
      System.out.println("\nQue informação vc quer editar?");
      System.out.println("1. Editar nome");
      System.out.println("2. Editar CPF");
      System.out.println("3. Editar email");
      System.out.println("4. Editar matrícula");
      System.out.println("0. Finalizar edição");

      System.out.print("> ");
      input = Integer.parseInt(in.nextLine());

      switch (input) {
        case 1:
          System.out.print("\nNovo nome: ");
          nome = in.nextLine();
          break;
        case 2:
          System.out.print("\nNovo CPF: ");
          cpf = in.nextLine();
          break;
        case 3:
          System.out.print("\nNovo email: ");
          email = in.nextLine();
          break;
        case 4:
          System.out.print("\nNova matrícula: ");
          matricula = Integer.parseInt(in.nextLine());
          break;
        case 0: break;

        default:
          System.out.println();
          System.out.println("Opção inválida!");
          break;
      }
    }

    alunoDAO.editarAluno(new Aluno(null, matricula, nome, cpf, email));
  }
}
