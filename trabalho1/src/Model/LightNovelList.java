package Model;

import java.util.List;

public class LightNovelList {
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
