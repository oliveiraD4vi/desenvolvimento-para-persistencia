import java.util.Scanner;

import Model.LightNovel;
import Serialization.Serialization;

public class App {
  public static void main(String[] args) throws Exception {
    int input = 1;
    int counter = 1;

    Serialization serialObject = new Serialization();

    Scanner in = new Scanner(System.in);

    while (input != 0) {
      System.out.println();
      System.out.println("--- Menu ---");
      System.out.println("0. Encerrar");
      System.out.println("1. Adicionar novel na lista");
      System.out.println("2. Visualizar lista");
      if (serialObject.getNovelList().size() > 0) {
        System.out.println("3. Salvar arquivo em JSON");
        System.out.println("4. Salvar arquivo em XML");
        System.out.println("5. Salvar arquivo em CSV");
      }

      System.out.print("Escolha uma opção: ");
      input = Integer.parseInt(in.nextLine());
      
      switch (input) {
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
            counter, capQtd, title, sinopse, release, editor, author, illustrator, finalized
          );

          counter++;
          serialObject.addNovel(novel);
          break;

        case 2:
          if (serialObject.getNovelList().size() > 0) {
            System.out.println();
            System.out.println(serialObject.getNovelList().toString());
          } else {
            System.out.println();
            System.out.println("Não há elementos na lista!");
          }
          break;

        case 3:
          System.out.print("\nInserir pathname: ");
          String pathname3 = in.nextLine();

          if (serialObject.saveJson(serialObject.getNovelList(), pathname3)) {
            System.out.println();
            System.out.println("Arquivo salvo com sucesso!");
          }
          break;
          
        case 4:
          System.out.print("\nInserir pathname: ");
          String pathname4 = in.nextLine();

          if (serialObject.saveXml(serialObject.getNovelList(), pathname4)) {
            System.out.println();
            System.out.println("Arquivo salvo com sucesso!");
          }
          break;

        case 5:
          System.out.print("\nInserir pathname: ");
          String pathname5 = in.nextLine();

          if (serialObject.saveCsv(serialObject.getNovelList(), pathname5)) {
            System.out.println();
            System.out.println("Arquivo salvo com sucesso!");
          }
          break;

        case 0:
          break;

        default:
          System.out.println();
          System.out.println("Opção inválida!");  
          break;
      }
    }

    System.out.println();
    System.out.println("Encerrando...");
    in.close();
  }
}
