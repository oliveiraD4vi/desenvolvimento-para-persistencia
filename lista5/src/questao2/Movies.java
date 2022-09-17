package questao2;

import java.util.List;

import questao1.Movie;

public class Movies {
  private List<Movie> movies;

  public Movies() {
  }

  public Movies(List<Movie> movies) {
    this.movies = movies;
  }

  public List<Movie> getMovies() {
    return movies;
  }

  public void setMovies(List<Movie> movies) {
    this.movies = movies;
  }

  @Override
  public String toString() {
    return this.movies.toString();
  }
}
