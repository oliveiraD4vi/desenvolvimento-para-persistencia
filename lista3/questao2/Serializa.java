package questao2;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import questao1.Movie;

public class Serializa {
  public static void main(String[] args) throws IOException, ClassNotFoundException {    
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

    File file = new File("arquivo.txt");
    try {
      file.delete();
      file.createNewFile();

      ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
      objOutput.writeObject(movieList);
      objOutput.close();
    } catch(IOException erro) {
      System.out.printf("Erro: %s", erro.getMessage());
    }
  }
}
