package com.exercicio.lista9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercicio.lista9.entity.AlunoTurma;

@Repository
public interface AlunoTurmaDAO extends JpaRepository<AlunoTurma, Long> {
  
}
