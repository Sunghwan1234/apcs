package lab.lab4_3;

public class Netflix {
  private String title;
  private double rating;

  public Netflix(String title) {
    this.title=title;
  }
  public String getTitle() {return title;}
  public void setTitle(String t) {this.title=t;}

  public double getRating() {return rating;}
  public void setRating() {rating=4;}
  public void setRating(double r) {rating=r;}

  public boolean isPopular() {return rating>=4;}
  public boolean isPopular(boolean promoting) {return (promoting&&rating>2)||isPopular();}

  public String toString() {return title+" Rating: "+rating;}
}
