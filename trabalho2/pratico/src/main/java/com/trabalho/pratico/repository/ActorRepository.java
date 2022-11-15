package com.trabalho.pratico.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trabalho.pratico.entity.Actor;
import com.trabalho.pratico.entity.Movie;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
 
  public Actor findFirstById(Integer id);

  @Query("select a.name from Actor as a where a.bornAt between :yearInit and :yearFinish")
  public List<String> findAllByYear(Date yearInit, Date yearFinish);

  @Query("select am from Actor a inner join a.movies am where a.id = :id")
  public List<Movie> findAllMovies(Integer id);
}
