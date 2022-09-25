package serialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import model.LightNovelList;
import model.LightNovel;

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

  public Boolean saveJson(List<LightNovel> list, String fileName) throws IOException {
    File file = new File(fileName + ".json");
    LightNovelList novels = new LightNovelList(list);
    
    ObjectMapper jsonFile = new ObjectMapper();
    jsonFile.writeValue(file, novels);

    return true;
  }

  public List<LightNovel> getNovelList() {
    return novelList;
  }

  public void setNovelList(List<LightNovel> novelList) {
    this.novelList = novelList;
  }
}
