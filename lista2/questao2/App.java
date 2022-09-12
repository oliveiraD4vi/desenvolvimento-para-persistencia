package questao2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) throws IOException {
    reader(args[0], args[1], args[2]);
  }

  public static void reader(String source1, String source2, String destination) throws IOException {
    try (
      BufferedReader buffRead = new BufferedReader(new FileReader(source1));
    ) {
      String line;
      ArrayList<String> lines = new ArrayList<>();
      while ((line = buffRead.readLine()) != null) lines.add(line);
      buffRead.close();

      writer(destination, lines, false);
    } catch (IOException e) {
      System.out.println("error: no such file or directory");
    }

    try (
      BufferedReader buffRead = new BufferedReader(new FileReader(source2));
    ) {
      String line;
      ArrayList<String> lines = new ArrayList<>();
      while ((line = buffRead.readLine()) != null) lines.add(line);
      buffRead.close();

      writer(destination, lines, true);
    } catch (IOException e) {
      System.out.println("error: no such file or directory");
    }
  }

  public static void writer(String destination, ArrayList<String> lines, Boolean action) throws IOException {
    try (
      PrintWriter writer = new PrintWriter(new FileWriter(destination, action));
    ) {
      for (String line : lines) writer.println(line);
    } catch(IOException e) {
      System.out.println("error: there was a problem writing the file");
    }
  }
}
