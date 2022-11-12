package com.trabalho.pratico.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQueries({
  @NamedQuery(name = "moviesByYear", query = "select m.title from Movie m where m.release = :year")
})

@Data
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private int release;

  @ManyToMany
  private List<Actor> actors;

  @Override
  public String toString() {
    return (id + " | Título: " + title + " | Ano: " + release);
  }
}
