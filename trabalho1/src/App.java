import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import Compressing.Compressing;
import Deserialization.Deserialization;
import Hashing.Hashing;
import Model.LightNovel;
import Model.LightNovelList;
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
      System.out.println("6. Comprimir arquivo em Zip");
      System.out.println("7. Verificar hashcode");
      System.out.println("8. Converter JSON em XML e CSV");

      System.out.print("Escolha uma opção: ");
      input = Integer.parseInt(in.nextLine());
      
      switch (input) {
        case 1: insertNovel(counter, in, serialObject); break;
        case 2: viewList(serialObject); break;
        case 3: saveFile(serialObject, in, "JSON"); break;
        case 4: saveFile(serialObject, in, "XML"); break;
        case 5: saveFile(serialObject, in, "CSV"); break;
        case 6: compress(in); break;
        case 7: hash(in); break;
        case 8: convert(in); break;
        case 0: break;

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

  public static void insertNovel(int count, Scanner in, Serialization serialObject) throws IOException {
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
  }

  public static void viewList(Serialization serialObject) {
    if (serialObject.getNovelList().size() > 0) {
      System.out.println();
      System.out.println(serialObject.getNovelList().toString());
    } else {
      System.out.println();
      System.out.println("Não há elementos na lista!");
    }
  }

  public static void saveFile(Serialization serialObject, Scanner in, String method) throws IOException {
    if (serialObject.getNovelList().size() > 0) {
      System.out.print("\nInserir pathname: ");
      String pathname = in.nextLine();

      switch (method) {
        case "JSON":
          if (serialObject.saveJson(serialObject.getNovelList(), pathname)) {
            System.out.println();
            System.out.println("Arquivo salvo com sucesso!");
          }
          break;

        case "XML":
          if (serialObject.saveXml(serialObject.getNovelList(), pathname)) {
            System.out.println();
            System.out.println("Arquivo salvo com sucesso!");
          }
          break;

        case "CSV":
          if (serialObject.saveCsv(serialObject.getNovelList(), pathname)) {
            System.out.println();
            System.out.println("Arquivo salvo com sucesso!");
          }
          break;
      
        default:
          break;
      }
    } else {
      System.out.println();
      System.out.println("Não há elementos na lista!");
    }
  }

  public static void compress(Scanner in) throws IOException {
    System.out.println();
    System.out.print("Inserir filepath do arquivo: ");
    String fileToCompress = in.nextLine();
    System.out.print("Inserir filepath do destino: ");
    String destinyFile = in.nextLine();

    Compressing compressing = new Compressing();
    compressing.compressToZip(destinyFile + ".zip", fileToCompress);
  }

  public static void hash(Scanner in) throws NoSuchAlgorithmException, IOException {
    System.out.println();
    System.out.print("Inserir filepath do arquivo: ");
    String fileToHash = in.nextLine();

    Hashing hashing = new Hashing();
    System.out.println("\nSHA1: " + hashing.getHashSHA1(fileToHash));
  }

  public static void convert(Scanner in) throws StreamReadException, DatabindException, IOException {
    Deserialization deserialization = new Deserialization();
    Serialization serialization = new Serialization();

    System.out.println();
    System.out.print("Inserir filepath do arquivo: ");
    String pathname = in.nextLine();

    LightNovelList list = deserialization.readJson(pathname);

    System.out.print("Inserir filepath dos arquivos de destino: ");
    pathname = in.nextLine();
    
    if (serialization.saveCsv(list.getNovels(), pathname) && serialization.saveXml(list.getNovels(), pathname)) {
      System.out.println("Arquivo convertido com sucesso!");
    }
  }
}
