package Deserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.LightNovelList;

public class Deserialization {
  public Deserialization() {
  }

  public static LightNovelList readJson(String pathname) throws StreamReadException, DatabindException, IOException {
    File file = new File(pathname + ".json");
    ObjectMapper jsonFile = new ObjectMapper();
    LightNovelList novels = jsonFile.readValue(file, LightNovelList.class);

    return novels;
  }
}
