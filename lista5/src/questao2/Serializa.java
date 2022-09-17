package questao2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import questao1.Movie;

public class Serializa {
  public static void main(String[] args) throws JsonProcessingException, IOException {
    List<Movie> movieList = new ArrayList<Movie>();

    movieList.add(
      new Movie(
        1,
        "Winnie The Pooh: Blood and Honey",
        "Rhys Waterfield",
        "Uma releitura de horror do livro de 1926 de A. A. Milne, Winnie-the-Pooh"
      )
    );

    movieList.add(
      new Movie(
        2,
        "The Dark Night",
        "Christopher Nolan",
        "Filme britânico-estadunidense de super-herói."
      )
    );

    movieList.add(
      new Movie(
        3,
        "It",
        "Andy Muschietti",
        "Um grupo de crianças se une para investigar o misterioso desaparecimento de vários jovens em sua cidade."
      )
    );

    File file = new File("arquivo.json");
    Movies movies = new Movies(movieList);
   
    ObjectMapper jsonFile = new ObjectMapper();
    jsonFile.writeValue(file, movies);
  }
}
