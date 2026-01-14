package AP.HiddenWord;

import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.*;
import javax.net.ssl.*;

/**
 * This class replicates the popular Wordle game using the HiddenWord class from
 * the 2015 AP Test.
 * If the HiddenWord class is completed correctly, the simulator should exactly
 * mimic today's Wordle.
 * 
 * @author Colten Kiehne
 */
public class WordleSimulator {
  public static void main(String[] args) {
    String wordleWord = getTodaysWord();
    HiddenWord hiddenWord = new HiddenWord(wordleWord);
    int guesses = 0;
    String userGuess = "";
    String outputString = "\nGuesses: \n ";

    Scanner input = new Scanner(System.in);
    System.out.println("Complete today's Wordle!");
    System.out.println("Correct letters in the right spot will be shown in " + green("green") + ".");
    System.out.println("Correct letters in the wrong spot will be shown in " + yellow("yellow") + ".\n");

    while (!wordleWord.equals(userGuess) && guesses < 6) {
      userGuess = "";

      while (!isValidWord(userGuess)) {
        System.out.println("(" + (guesses + 1) + ") Please input your guess: ");
        userGuess = input.nextLine().toUpperCase();
      }

      String hint = hiddenWord.getHint(userGuess);

      for (int i = 0; i < 5; i++) {
        if (hint.charAt(i) == '*') {
          outputString += userGuess.charAt(i);
        } else if (hint.charAt(i) == '+') {
          outputString += yellow(userGuess.charAt(i));
        } else {
          outputString += green(userGuess.charAt(i));
        }
      }

      System.out.println(outputString);
      outputString += "\n ";
      guesses++;
    }

    if (userGuess.equals(wordleWord)) {
      System.out.println("Congrats! You solved today's Wordle!");
    } else {
      System.out.println("Oh Drats. You were unable to solve today's Wordle. The word was " + green(wordleWord) + ".");
    }

    input.close();
  }

  /**
   * Get Wordle Word for today
   * 
   * @return Wordle word String
   */
  public static String getTodaysWord() {
    // Don't worry too much about what this is doing, school internet
    // just is dumb sometimes
    disableSslVerification();

    try {
      // Read input from Wordle
      InputStream input = new URL("https://www.nytimes.com/svc/wordle/v2/" + LocalDate.now() + ".json")
          .openStream();

      // Byte by byte reader of the input stream
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      // String builder to allow strings to be built charecter by charecter
      StringBuilder json = new StringBuilder();
      int c;

      while ((c = reader.read()) != -1) {
        json.append((char) c);
      }

      Pattern pattern = Pattern.compile("\"[a-z]{5}\"");
      Matcher matcher = pattern.matcher(json.toString());

      // Run matcher with the regex pattern, basically looking for the string "word"
      // where word is the current wordle word.

      matcher.find();

      return matcher.group().substring(1, 6).toUpperCase();
    } catch (Exception e) {
      System.out.println("Error in fetching today's Wordle word!");
    }

    return null;

  }

  /**
   * Disables SSL verification by making everything allowed.
   * If you ever actually have to do this, please don't, there's much better ways
   * to do it that this,
   * this is just the easisest way to get around school computer stuff
   * 
   * Taken from
   * https://stackoverflow.com/questions/4663147/is-there-a-java-setting-for-disabling-certificate-validation
   */
  private static void disableSslVerification() {
    try {
      // Create a trust manager that does no validation
      TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
          return null;
        }

        // basically make nothing happen when these methods are
        // run so that *everything* will be trusted

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
      }
      };

      // Install the all-trusting trust manager
      SSLContext sc = SSLContext.getInstance("SSL");
      sc.init(null, trustAllCerts, new java.security.SecureRandom());
      HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

      // Create all-trusting host name verifier
      HostnameVerifier allHostsValid = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
          return true;
        }
      };

      // Install the all-trusting host verifier
      HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (KeyManagementException e) {
      e.printStackTrace();
    }
  }

  /**
   * Adds ANSI escape sequence to change the color of the string to green
   * 
   * @param string String to turn green
   * @return String with esccape sequences to change the color of the string
   */
  public static String green(String string) {
    return "\u001B[32m" + string + "\u001B[0m";
  }

  /**
   * Adds ANSI escape sequence to change the color of the 'letter' char to green
   * 
   * @param letter Letter to turn green
   * @return String with esccape sequences to change the color of the letter
   */
  public static String green(char letter) {
    return "\u001B[32m" + letter + "\u001B[0m";
  }

  /**
   * Adds ANSI escape sequence to change the color of the string to green
   * 
   * @param string String to turn green
   * @return String with esccape sequences to change the color of the string
   */
  public static String yellow(String string) {
    return "\u001B[33m" + string + "\u001B[0m";
  }

  /**
   * Adds ANSI escape sequence to change the color of the 'letter' char to yellow
   * 
   * @param letter Letter to turn yellow
   * @return char with esccape sequences to change the color of the letter
   */
  public static String yellow(char letter) {
    return "\u001B[33m" + letter + "\u001B[0m";
  }

  /**
   * Returns whether the word is valid or not.
   * 
   * @param word guess input word
   * @return if the word is valid
   */
  public static boolean isValidWord(String word) {
    // We don't need to check to see if word is valid if it doesn't exist or is
    // too few or many letters
    if (word.length() != 5) {
      return false;
    }

    try {
      URL requestUrl = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/" + word);
      HttpURLConnection http = (HttpURLConnection) requestUrl.openConnection();
      int statusCode = http.getResponseCode();

      // 200 means a valid request and word exists
      return statusCode == 200;
    } catch (Exception e) {
      throw new Error("Unable to check to see if word is valid!");
    }
  }
}
