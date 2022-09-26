package Model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "novelsList")
public class LightNovelList {
  @JacksonXmlElementWrapper(localName = "novels")
  @JacksonXmlProperty(localName = "novel")

  private List<LightNovel> novels;

  public LightNovelList() {
  }

  public LightNovelList(List<LightNovel> novels) {
    this.novels = novels;
  }

  public List<LightNovel> getNovels() {
    return novels;
  }

  public void setNovels(List<LightNovel> novels) {
    this.novels = novels;
  }

  @Override
  public String toString() {
    return "LightNovelList novels:\n" + novels;
  }
}
