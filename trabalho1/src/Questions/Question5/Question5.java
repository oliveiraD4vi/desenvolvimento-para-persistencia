/*
 * Crie uma classe Java que recebe via linha de comando
 * o nome de um arquivo qualquer e exibe no console o hash
 * SHA1 desse arquivo.
 */

package Questions.Question5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Question5 {
  public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
    String filename = args[0];

    MessageDigest sha1 = MessageDigest.getInstance("SHA1");
    sha1.update(Files.readAllBytes(Paths.get(filename)));
    byte[] digest = sha1.digest();

    System.out.println(DatatypeConverter.printHexBinary(digest).toUpperCase());
  }
}
