package com.trabalho.pratico.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "actors")
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Date bornAt;

  @ManyToMany(mappedBy = "actors")
  private List<Movie> movies;

  @Override
  public String toString() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String date = dateFormat.format(bornAt);

    return (id + " | Name: " + name + " | Birthday: " + date);
  }
}
