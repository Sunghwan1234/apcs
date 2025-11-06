package lab.labfrq2;

public class SignedText {
  String fn,ln;
  public SignedText(String f, String l) {
    fn=f; ln=l;
  }
  public String getSignature() {
    return (fn.equals("")?"":fn.charAt(0)+"-")+ln;
  }
  public String addSignature(String inp) {
    String i = inp;
    //System.out.println("!"+i);
    if (i.contains(getSignature())) {
      i=i.replace(getSignature(),"");
      return i+getSignature();
    }
    i=i.replace(ln,"");
    
    //System.out.println("!"+i);
    return i+ln;
  
  }
}
