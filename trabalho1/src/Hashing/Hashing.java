package Hashing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Hashing {
  public String getHashSHA1(String filename) throws NoSuchAlgorithmException, IOException {        
    MessageDigest sha1 = MessageDigest.getInstance("SHA1");
    sha1.update(Files.readAllBytes(Paths.get(filename)));
    byte[] digest = sha1.digest();
    String myChecksum = DatatypeConverter.printHexBinary(digest).toUpperCase();

    return myChecksum;
  }
}
