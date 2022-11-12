package com.exercicio.lista9.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "alunoTurma")
@AllArgsConstructor
@NoArgsConstructor
public class AlunoTurma {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private float nota_final;

  @Column(nullable = false)
  private int faltas;

  @ManyToOne
  private Turma turma;

  @ManyToOne
  private Aluno aluno;

  public String toString() {
    return (
      id + "\nTurma: " + turma + "\nAluno: " + aluno + "\nNota final: " + nota_final + " Faltas: " + faltas
    );
  }
}
