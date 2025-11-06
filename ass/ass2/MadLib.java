import java.util.Scanner;

public class MadLib {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      String[] in = new String[10];
      String[] questions = {"RELATIVE","ADJECTIVE","ADJECTIVE","ADJECTIVE","NAME","ADJECTIVE","ADJECTIVE","VERB ENDING IN \"ING\"","TYPE OF RELATIVE (brother, aunt, etc.)","YOUR NAME"};

      for (int i=0;i<in.length;i++) {
        in[i] = ask(scanner, questions[i]);
      }
        String[] out = {
          "Dear _ [word1] _,",
          "I am having a(n) _ [word2] _ time at camp. The counselor is _ [word3] _ and the food",
          "is _ [word4] _. I met _ [word5] _ and we became _ [word6] _ friends. Unfortunately,",
          "_ [word5] _ is _ [word7] _ so we couldn't go _ [word8] _ like everybody else.",
          "Your _ [word9] _,",
          " _ [word10] _"
        };
        
        String in1 = in[0];
        String in2 = in[1];
        String in3 = in[2];
        String in4 = in[3];
        String in5 = in[4];
        String in6 = in[5];
        String in7 = in[6];
        String in8 = in[7];
        String in9 = in[8];
        String in10 = in[9];
        
        in = new String[]{in1,in2,in3,in4,in5,in6,in7,in8,in9,in10};

        for (int i = 0; i < out.length; i++) {
          for (int j = 0; j < in.length; j++) {
            out[i] = out[i].replace("_ [word"+(j+1)+"] _",in[j]);
            //System.out.println(out[i]);
          }
        }

        System.out.println();
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }
    public static void pl(String p) {
      System.out.println(p);
    }
    public static void printOut(String[] out) {
      for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }
    public static String ask(Scanner scanner, String askString) {
      System.out.print(askString+": ");
      String out = scanner.next();
      System.out.println();
      return out;
    }
}