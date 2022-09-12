/**
 * A classe App é a resolução proposta para o problema apresentado
 * na Questão 1 da Lista 1 de exercícios da disciplina de Desenvolvimento
 * para Persistência.
 * @author Davi Oliveira
 */

package Questao_1;

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class App {
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);

    System.out.print("\nInsert filepath: ");
    String path = input.nextLine();

    reader(path);
    input.close();
  }

  /**
   * O método reader lê o arquivo proposto e também recebe
   * do usuário a linha de onde deve começar a imprimir e
   * onde deve parar.
   * @param path é o caminho do arquivo a ser lido
   * @throws IOException é a exceção lançada pelo método
   */
  public static void reader(String path) throws IOException {
    try (
      BufferedReader buffRead = new BufferedReader(new FileReader(path));
    ) {
      Scanner input = new Scanner(System.in);
      int lineCounter = 0;
      String line = "";

      System.out.print("Insert first line: ");
      String n1 = input.nextLine();
      System.out.print("Insert last line: ");
      String n2 = input.nextLine();

      while (true) {
        line = buffRead.readLine();
        lineCounter++;

        if (Integer.parseInt(n1) > Integer.parseInt(n2) || line == null) {
          System.out.println("error: cannot read with the passed args");
          break;
        } else {
          if (n1.equals("") && n2.equals("")) {
            System.out.println(line);
          } else if (n1.equals("") && !n2.equals("")) {
            if (lineCounter <= Integer.parseInt(n2))
              System.out.println(line);
          } else if (!n1.equals("") && n2.equals("")) {
            if (lineCounter >= Integer.parseInt(n1))
              System.out.println(line);
          } else if (lineCounter >= Integer.parseInt(n1) && lineCounter <= Integer.parseInt(n2)) {
            System.out.println(line);
          }
        }
      }

      input.close();
      buffRead.close();
    } catch (IOException e) {
      System.out.println("error: no such file or directory");
    }
	}
}
