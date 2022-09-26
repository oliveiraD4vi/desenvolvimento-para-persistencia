package Questions.Question2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.LightNovel;
import Model.LightNovelList;

public class Question2 {
  public static void main(String[] args) throws IOException {
    int input = 1;
    int count = 1;
    Scanner in = new Scanner(System.in);
    List<LightNovel> novelList = new ArrayList<LightNovel>();

    while (input != 0) {
      System.out.println("\n--- MENU ---");
      System.out.println("0. Encerrar interação");
      System.out.println("1. Adicionar novel à lista");
      System.out.print("\nEscolha uma opção: ");
      input = Integer.parseInt(in.nextLine());

      switch (input) {
        case 0:
          System.out.println("Encerrando...");
          break;
        case 1:
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
          novelList.add(novel);
          break;
      
        default:
          System.out.println("Opção inválida!");
          break;
      }
    }

    if (novelList.size() > 0) {
      System.out.print("\nInsira o nome do arquivo destino: ");
      String filepath = in.nextLine();

      serialize(novelList, filepath);
    }

    in.close();
  }

  public static void serialize(List<LightNovel> list, String filepath) {
    try {
      File file = new File(filepath);
      LightNovelList novels = new LightNovelList(list);
      
      ObjectMapper jsonFile = new ObjectMapper();
      jsonFile.writeValue(file, novels);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
