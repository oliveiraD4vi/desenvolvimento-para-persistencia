package Serialization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.opencsv.CSVWriter;

import Model.LightNovel;
import Model.LightNovelList;

import java.util.ArrayList;

public class Serialization {
  private List<LightNovel> novelList = new ArrayList<LightNovel>();

  public Serialization() {
  }

  public Serialization(List<LightNovel> novelList) {
    this.novelList = novelList;
  }

  public List<LightNovel> addNovel(LightNovel novel) throws IOException {
    novelList.add(novel);

    return novelList;
  }

  public Boolean saveJson(List<LightNovel> list, String filepath) throws IOException {
    try {
      File file = new File(filepath + ".json");
      LightNovelList novels = new LightNovelList(list);
      
      ObjectMapper jsonFile = new ObjectMapper();
      jsonFile.writeValue(file, novels);

      return true;
    } catch (Exception e) {
      e.printStackTrace();

      return false;
    }
  }

  public Boolean saveXml(List<LightNovel> list, String filepath) throws StreamWriteException, DatabindException, IOException {
    try {
      LightNovelList novelList = new LightNovelList(list);

      File file = new File(filepath + ".xml");
      XmlMapper xm = new XmlMapper();

      xm.enable(SerializationFeature.INDENT_OUTPUT);
      xm.writeValue(file, novelList);

      return true;
    } catch (Exception e) {
      e.printStackTrace();

      return false;
    }
  }

  public Boolean saveCsv(List<LightNovel> list, String filepath) {    
    try {
      File file = new File(filepath + ".csv");

      FileWriter outputfile = new FileWriter(file);
      CSVWriter writer = new CSVWriter(outputfile);

      String[] header = { "Id", "Caps", "Title", "Sinopse", "Lançamento", "Editora", "Autor", "Ilustrador", "Finalizado" };
      writer.writeNext(header);

      for (LightNovel item : list) {
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

      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public List<LightNovel> getNovelList() {
    return novelList;
  }

  public void setNovelList(List<LightNovel> novelList) {
    this.novelList = novelList;
  }
}
