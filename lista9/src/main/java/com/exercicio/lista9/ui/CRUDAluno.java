package com.exercicio.lista9.ui;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.exercicio.lista9.entity.Aluno;
import com.exercicio.lista9.repository.AlunoDAO;

@ComponentScan("com.exercicio.lista9")
public class CRUDAluno {

  @Autowired
  private AlunoDAO alunoRepository;

  public void run(String... args) throws Exception {
    String menu = "Escolha uma opção:\n1 - Inserir aluno\n2 - Atualizar aluno\n3 - Remover aluno\n4 - Listar alunos\n0 - Sair";
		char input;
  
    do {
      Aluno aluno;
      input = JOptionPane.showInputDialog(menu).charAt(0);

      switch (input) {
        case '1':
          aluno = getAluno();
          alunoRepository.save(aluno);
          break;

        case '2':
          listAlunos(alunoRepository.findAll());
          Integer aluno_id = Integer.parseInt(JOptionPane.showInputDialog("Selecione o ID do aluno que quer editar: ").toString());
          aluno = alunoRepository.findById;
					aluno = getAluno();
					baseClientes.save(cl);
          break;

        case '3': break;

        case '4':
          listAlunos(alunoRepository.findAll());
          break;

        case '0': break;
      
        default:
          JOptionPane.showInputDialog("\nOpção inválida!");
          break;
      }
    } while (input != '0');
  }

  public static Aluno getAluno() {
    Integer matricula = Integer.parseInt(JOptionPane.showInputDialog("Matrícula: ").toString());
    String nome = JOptionPane.showInputDialog("Nome: ").toString();
    String cpf = JOptionPane.showInputDialog("CPF: ").toString();
    String email = JOptionPane.showInputDialog("Email: ").toString();
    String phone = JOptionPane.showInputDialog("Ṕhone: ").toString();

    Aluno aluno = new Aluno(null, matricula, nome, cpf, email, phone);

    return aluno;
  }

  public static void listAlunos(List<Aluno> alunos) {
		StringBuilder listagem = new StringBuilder();

		for(Aluno aluno : alunos) {
			listagem.append(aluno).append("\n");
		}

		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum cliente encontrado" : listagem);
	}

}
