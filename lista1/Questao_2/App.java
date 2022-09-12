/**
 * A classe App é a resolução proposta para o problema apresentado
 * na Questão 2 da Lista 1 de exercícios da disciplina de Desenvolvimento
 * para Persistência.
 * @author Davi Oliveira
 */

package Questao_2;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileWriter;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) throws IOException {
    reader(args[0], args[1], Boolean.parseBoolean(args[2]));
  }

  /**
   * O método reader é o método que lê o arquivo cujo nome foi
   * inserido pelo usuário
   * @param source é o caminho do arquivo original
   * @param destiny é o caminho do arquivo de destino
   * @param action é a ação do FileWriter, true para manter o arquivo,
   * false para reescrever o arquivo
   * @throws IOException é exceção lançada pelo método
   */
  public static void reader(String source, String destiny, boolean action) throws IOException {
    try (
      BufferedReader buffRead = new BufferedReader(new FileReader(source));
    ) {
      String line;
      ArrayList<String> lines = new ArrayList<>();
      while ((line = buffRead.readLine()) != null) {
        lines.add(line);
      }
      writer(destiny, lines, action);
      buffRead.close();
    } catch (IOException e) {
      System.out.println("error: no such file or directory");
    }
  }

  /**
   * O método writer é o método que escreve o arquivo lido em
   * um segundo arquivo denominado pelo usuário
   * @param destiny é o caminho do arquivo de destino
   * @param lines é um ArrayList que contém as linhas do arquivo lido
   * @param action é a ação do FileWriter, true para manter o arquivo,
   * false para reescrever o arquivo
   * @throws IOException é exceção lançada pelo método
   */
  public static void writer(String destiny, ArrayList<String> lines, boolean action) throws IOException {
    try (
      PrintWriter writer = new PrintWriter(new FileWriter(destiny, action));
    ) {
      for(String line : lines) writer.println(line);
    } catch(IOException e) {
      System.out.println("error: there was a problem writing the file");
    }
  }
}
