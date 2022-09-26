/*
 * Crie uma classe Java que recebe via linha de comando o
 * nome de um arquivo qualquer em formato JSON e o converte para
 * os formatos CSV e XML.
 */

package Questions.Question3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.CSVWriter;

import Model.LightNovel;
import Model.LightNovelList;

public class Question3 {
  public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
    String inputPath = args[0];
    String outputPath = args[1];

    File file = new File(inputPath);
    ObjectMapper jsonFile = new ObjectMapper();
    LightNovelList novels = jsonFile.readValue(file, LightNovelList.class);
    
    try {
      file = new File(outputPath + ".xml");
      XmlMapper xm = new XmlMapper();

      xm.enable(SerializationFeature.INDENT_OUTPUT);
      xm.writeValue(file, novels.getNovels());
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      file = new File(outputPath + ".csv");

      FileWriter outputfile = new FileWriter(file);
      CSVWriter writer = new CSVWriter(outputfile);

      String[] header = { "Id", "Caps", "Title", "Sinopse", "Lançamento", "Editora", "Autor", "Ilustrador", "Finalizado" };
      writer.writeNext(header);

      for (LightNovel item : novels.getNovels()) {
        String[] data = {
          String.valueOf(item.getId()),
          String.valueOf(item.getCapQtd()),
          item.getTitle(),
          item.getSinopse(),
          item.getRelease(),
          item.getEditor(),
          item.getAuthor(),
          item.getIllustrator(),
          String.valueOf(item.getFinalized()),
        };
        writer.writeNext(data);
      }

      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
