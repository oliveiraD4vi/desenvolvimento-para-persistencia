package com.exercicio.lista9.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "turmas")
@AllArgsConstructor
@NoArgsConstructor
public class Turma {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String periodo;

  @Column(nullable = false)
  private String disciplina;

  public String toString() {
    return (id + " Período: " + periodo + " Disciplina: " + disciplina);
  }
}
