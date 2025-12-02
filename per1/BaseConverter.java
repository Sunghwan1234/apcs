
public class BaseConverter {
  public static void main(String[] args) {
    final int BASE = 16;
    int[] BASES = {2, 4, 8, 10, 16};
    String input = "17B";
    char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    String[] outs = new String[BASES.length];
    for (int b=0;b<BASES.length;b++) {
      int BASETO = BASES[b];
      String output = "";
      int sum=0;
      for (int i=0;i<input.length();i++) {
        sum+=Math.pow(BASE,input.length()-i-1)*itemOf(chars,input.charAt(i));
      }
      p("Summation: "+sum);
      while (sum>0) {
        p("Sum: "+sum+" Modulo "+BASETO+":\t"+(sum%BASETO));
        output=chars[sum%BASETO]+output;
        sum/=BASETO;
        
      }
      p("Base "+BASETO+": "+output);
      outs[b] = output;
    }
    p("ALL: ");
    for (int i=0;i<outs.length;i++) {
      p("BASE"+BASES[i]+": "+outs[i]);
    }
  }
  public static int itemOf(char[] o, char item) {
    for (int i=0;i<o.length;i++) {
      if (o[i]==item) {
        return i;
      }
    }
    return -1;
  }
  public static void p(Object o) {
    System.out.println(o);
  }
}
