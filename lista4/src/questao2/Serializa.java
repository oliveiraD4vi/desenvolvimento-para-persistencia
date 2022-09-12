package questao2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import questao1.Movie;

public class Serializa {
  public static void main(String[] args) throws Exception {
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

    Movies movies = new Movies(movieList);

    File file = new File("arquivo.xml");
    XmlMapper xm = new XmlMapper();

    xm.enable(SerializationFeature.INDENT_OUTPUT);
    xm.writeValue(file, movies);
  }
}
