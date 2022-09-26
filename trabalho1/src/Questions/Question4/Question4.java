package Questions.Question4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Question4 {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);

    System.out.println();
    System.out.print("Inserir filepath do arquivo: ");
    String fileToCompress = in.nextLine();
    System.out.print("Inserir filepath do destino: ");
    String destinyFile = in.nextLine();

    int cont;
    byte[] data = new byte[4096];

    try {
      File file = new File(fileToCompress);
      ZipEntry entry = new ZipEntry(file.getName());
      FileInputStream inputStream = new FileInputStream(file);

      FileOutputStream destiny = new FileOutputStream(new File(destinyFile));
      BufferedInputStream origin = new BufferedInputStream(inputStream, 4096);
      ZipOutputStream output = new ZipOutputStream(new BufferedOutputStream(destiny));

      output.putNextEntry(entry);

      while((cont = origin.read(data, 0, 4096)) != -1) {
        output.write(data, 0, cont);
      }

      origin.close();
      output.close();
    } catch(IOException e) {
      e.printStackTrace();
    }

    in.close();
  }
}
