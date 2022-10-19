package com.jpa.dao;

import java.util.List;

import com.jpa.entity.Aluno;

public interface AlunoDAO {
  void adicionaAluno(Aluno aluno);
  void editarAluno(Aluno aluno);
  void deletarAluno(int id);
  Aluno getAluno(int id);
  List<Aluno> getListaAluno();
}
