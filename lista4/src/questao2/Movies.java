package questao2;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import questao1.Movie;

@JacksonXmlRootElement(localName = "catalog")
public class Movies {
  @JacksonXmlElementWrapper(localName = "movies")
  @JacksonXmlProperty(localName = "movie")
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
