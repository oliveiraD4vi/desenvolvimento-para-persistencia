package Questions.Question3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Question3 {
  public static void main(String[] args) throws IOException {
    String arqentry = args[0];
    String arqoutput = args[1];

    int cont;
    byte[] data = new byte[4096];

    try {
      File file = new File(arqentry);
      ZipEntry entry = new ZipEntry(file.getName());
      FileInputStream inputStream = new FileInputStream(file);

      FileOutputStream destiny = new FileOutputStream(new File(arqoutput));
      BufferedInputStream origin = new BufferedInputStream(inputStream, 4096);
      ZipOutputStream output = new ZipOutputStream(new BufferedOutputStream(destiny));

      output.putNextEntry(entry);

      while((cont = origin.read(data, 0, 4096)) != -1) {
        output.write(data, 0, cont);
      }

      origin.close();
      output.close();
    } catch(IOException e) {
      throw new IOException(e.getMessage());
    }
  }
}
