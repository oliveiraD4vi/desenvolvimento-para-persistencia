package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.jpa.entity.Aluno;

public class AlunoJPA implements AlunoDAO {

  @Override
  public void adicionaAluno(Aluno aluno) {
    EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();

    try {
      em.getTransaction().begin();
      em.persist(aluno);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      em.getTransaction().rollback();
    }

    em.close();
  }

  @Override
  public List<Aluno> getListaAluno() {
    EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
    List<Aluno> resultList = em.createNamedQuery("Aluno.findAll", Aluno.class).getResultList();
    em.close();

    return resultList;
  }

  @Override
  public void deletarAluno(int id) {
    EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
    
    try {
      em.getTransaction().begin();
      Aluno aluno = em.find(Aluno.class, id);

      em.remove(aluno);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      em.getTransaction().rollback();
    }

    em.close();
  }

  @Override
  public void editarAluno(Aluno aluno) {
    EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();

    try {
      em.getTransaction().begin();
      em.merge(aluno);
      em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      em.getTransaction().rollback();
    }
  }

  @Override
  public Aluno getAluno(int id) {
    EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
    Aluno aluno = new Aluno();

    try {
      aluno = em.find(Aluno.class, id);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return aluno;
  }
}
