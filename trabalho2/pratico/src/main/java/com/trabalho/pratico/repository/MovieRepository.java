package com.trabalho.pratico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trabalho.pratico.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
  
  public Movie findFirstById(Integer id);

  @Query(name = "moviesByYear")
  public List<String> findAllByYear(int year);

  @Query("select m.title from Movie m where m.title LIKE %:str%")
  public List<String> findAllByString(String str);

  @Query("select COUNT(*) from Movie")
  public int countMovies();

  @Query("select ma.name from Movie m left outer join m.actors ma where m.id = :id")
  public List<String> findAllActors(Integer id);
}
