package Questions.Question4;

import java.io.IOException;
import java.util.Scanner;

import Compressing.Compressing;

public class Question4 {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);

    System.out.println();
    System.out.print("Inserir filepath do arquivo: ");
    String fileToCompress = in.nextLine();
    System.out.print("Inserir filepath do destino: ");
    String destinyFile = in.nextLine();

    Compressing compressing = new Compressing();
    compressing.compressToZip(destinyFile + ".zip", fileToCompress);

    in.close();
  }
}
