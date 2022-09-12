package questao1;

import java.io.Serializable;

public class Movie implements Serializable {
  private int id;
  private String title;
  private String director;
  private String sinopse;

  public Movie(int id, String title, String director, String sinopse) {
    this.id = id;
    this.title = title;
    this.director = director;
    this.sinopse = sinopse;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  public String getSinopse() {
    return sinopse;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setSinopse(String sinopse) {
    this.sinopse = sinopse;
  }

  @Override
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();

    stringBuffer.append("\nMovie ID: " + getId());
    stringBuffer.append("\nTitle: " + getTitle());
    stringBuffer.append("\nDirector: " + getDirector());
    stringBuffer.append("\nSinopse: " + getSinopse());
    stringBuffer.append("\n");
    
    return stringBuffer.toString();
  }
}
