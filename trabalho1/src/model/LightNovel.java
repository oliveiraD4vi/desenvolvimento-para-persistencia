package model;

public class LightNovel {
  private int id;
  private int capQtd;
  private String title;
  private String sinopse;
  private String release;
  private String editor;
  private String author;
  private String illustrator;
  private Boolean finalized;

  public LightNovel() {
  }

  public LightNovel(int id, int capQtd, String title, String sinopse, String release, String editor, String author,
    String illustrator, Boolean finalized) {
    this.id = id;
    this.capQtd = capQtd;
    this.title = title;
    this.sinopse = sinopse;
    this.release = release;
    this.editor = editor;
    this.author = author;
    this.illustrator = illustrator;
    this.finalized = finalized;
  }
  
  @Override
  public String toString() {
    return "\n--LightNovel: author=" + author + ", capQtd=" + capQtd + ", editor=" + editor + ", finalized=" + finalized
        + ", id=" + id + ", illustrator=" + illustrator + ", release=" + release + ", sinopse=" + sinopse + ", title="
        + title + "--\n";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCapQtd() {
    return capQtd;
  }

  public void setCapQtd(int capQtd) {
    this.capQtd = capQtd;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSinopse() {
    return sinopse;
  }

  public void setSinopse(String sinopse) {
    this.sinopse = sinopse;
  }

  public String getRelease() {
    return release;
  }

  public void setRelease(String release) {
    this.release = release;
  }

  public String getEditor() {
    return editor;
  }

  public void setEditor(String editor) {
    this.editor = editor;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIllustrator() {
    return illustrator;
  }

  public void setIllustrator(String illustrator) {
    this.illustrator = illustrator;
  }

  public Boolean getFinalized() {
    return finalized;
  }

  public void setFinalized(Boolean finalized) {
    this.finalized = finalized;
  }
}
