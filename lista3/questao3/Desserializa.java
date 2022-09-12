package questao3;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import questao1.Movie;

public class Desserializa {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    try {
      File file = new File("arquivo.txt");
      if (file.exists()) {
        ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
        List<Movie> movieList = (ArrayList<Movie>)objInput.readObject();
        objInput.close();

        System.out.println(movieList);
      }
    } catch(IOException erro1) {
      System.out.printf("Erro: %s", erro1.getMessage());
    } catch(ClassNotFoundException erro2) {
      System.out.printf("Erro: %s", erro2.getMessage());
    }
  }
}
