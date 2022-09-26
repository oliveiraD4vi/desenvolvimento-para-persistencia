package Questions.Question2;

import java.io.IOException;
import java.util.Scanner;

import Model.LightNovel;
import Serialization.Serialization;

public class Question2 {
  public static void main(String[] args) throws IOException {
    int count = 1;
    Serialization serialObject = new Serialization();
    Scanner in = new Scanner(System.in);

    System.out.println("\nAtributos da novel");
    System.out.print("Título: ");
    String title = in.nextLine();
    System.out.print("Sinopse: ");
    String sinopse = in.nextLine();
    System.out.print("Ano de lançamento: ");
    String release = in.nextLine();
    System.out.print("Editora: ");
    String editor = in.nextLine();
    System.out.print("Autor(a): ");
    String author = in.nextLine();
    System.out.print("Ilustrador(a): ");
    String illustrator = in.nextLine();
    System.out.print("Quantidade de capítulos: ");
    int capQtd = Integer.parseInt(in.nextLine());
    System.out.print("Finalizado (false para EM PRODUÇÃO e true para FINALIZADO): ");
    Boolean finalized = Boolean.parseBoolean(in.nextLine());

    LightNovel novel = new LightNovel(
      count, capQtd, title, sinopse, release, editor, author, illustrator, finalized
    );

    count++;
    serialObject.addNovel(novel);

    in.close();
  }
}
