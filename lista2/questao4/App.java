package questao4;

import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    Properties prop = getProp();

		String file = prop.getProperty("prop.file");
    String n1 = prop.getProperty("prop.line.first");
    String n2 = prop.getProperty("prop.line.last");

    reader(file, Integer.parseInt(n1), Integer.parseInt(n2));
  }

  public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./questao4/config.properties");
		props.load(file);
		return props;
	}

  public static void reader(String path, Integer n1, Integer n2) throws IOException {
    try (
      BufferedReader buffRead = new BufferedReader(new FileReader(path));
    ) {
      int lineCounter = 0;

      while (true) {
        String line = buffRead.readLine();
        lineCounter++;

        if (line != null && lineCounter >= n1 && lineCounter <= n2)
          System.out.println(line);
        else break;
      }
      buffRead.close();
    } catch (IOException e) {
      System.out.println("error: no such file or directory");
    }
  }
}
