package questao1;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class App {
  public static void main(String[] args) throws IOException {
    reader(args[0], args[1]);
  }

  public static void reader(String path, String subString) throws IOException {
    try (
      BufferedReader buffRead = new BufferedReader(new FileReader(path));
    ) {
      while (true) {
        String line = buffRead.readLine();
        if (line != null && line.toLowerCase().contains(subString)) {
          System.out.println(line);
        } else {
          break;
        }
      }
      buffRead.close();
    } catch (IOException e) {
      System.out.println("error: no such file or directory");
    }
  }
}
