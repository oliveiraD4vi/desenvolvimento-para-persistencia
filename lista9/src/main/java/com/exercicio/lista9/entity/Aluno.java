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
@Table(name = "alunos")
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(unique = true, nullable = false)
  private Integer matricula;

  @Column(nullable = false)
  private String nome;

  @Column(unique = true, nullable = false)
  private String cpf;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(unique = true, nullable = true)
  private String phone;

  public String toString() {
    return (id + " Nome: " + nome + " Matrícula: " + matricula + " CPF: " + cpf + " Email: " + email);
  }
}
