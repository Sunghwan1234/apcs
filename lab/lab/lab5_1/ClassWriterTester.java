package lab5_1;

/**
 * ClassWriterTester contains a main method to test ClassWriter class (static) methods.
 * 
 * The tester invokes the writeInstanceVariable, writeConstructor, overloaded writeConstructor,
 * writeGetterMethod, and writeSetterMethod methods, and prints the results.
 */
public class ClassWriterTester {
  public static void main(String[] args) {
    // tests instance variable method written in part (a)
    String OneVarClassOutput = ClassWriter.writeInstanceVariable("String", "word") + "\n\n";
    
    // tests constructor written in part (c)
    OneVarClassOutput += ClassWriter.writeConstructor("OneVarClass", "String", "word") + "\n\n";
  
    // tests methods written in part (b)
    OneVarClassOutput += ClassWriter.writeGetterMethod("String", "word") + "\n\n";
    OneVarClassOutput += ClassWriter.writeSetterMethod("String", "word");
    System.out.println(OneVarClassOutput  + "\n\n--------------------\n");
    
    // tests instance variable method written in part (a)
    String TwoVarClassOutput = ClassWriter.writeInstanceVariable("boolean", "isInPlay") + "\n";
    TwoVarClassOutput += ClassWriter.writeInstanceVariable("double", "num") + "\n\n";
    
    // tests constructor written in part (c)
    TwoVarClassOutput += ClassWriter.writeConstructor("TwoVarClass", "boolean", "isInPlay", "double", "num") + "\n\n";
  
    // tests methods written in part (b)
    TwoVarClassOutput += ClassWriter.writeGetterMethod("boolean", "isInPlay") + "\n\n";
    TwoVarClassOutput += ClassWriter.writeSetterMethod("boolean", "isInPlay") + "\n\n";
    TwoVarClassOutput += ClassWriter.writeGetterMethod("double", "num") + "\n\n";
    TwoVarClassOutput += ClassWriter.writeSetterMethod("double", "num");
    System.out.println(TwoVarClassOutput);
  }
}
