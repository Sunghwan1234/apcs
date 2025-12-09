package AP.sign;

public class Sign {
  private String msg;
  private int width = 0;

  public Sign(String m, int w) {
    msg=m; width=w;
  }

  public int numberOfLines() {
    return (int)Math.ceil(((double)msg.length())/width);
  }

  public String getLines() {
    String out = "";
    for (int i = 0; i<numberOfLines(); i++) {
      out+=msg.substring(width*i,Math.clamp(width*(i+1),0,msg.length()));
      if (i<numberOfLines()-1) {
        out += ";";
      }
    }
    return out==""?null:out;
  }
}
