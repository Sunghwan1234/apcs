package lab.lab5_1;

/**
 * ClassWriter contains class (static) methods to return code that writes
 * instance variables, constructors, and methods automatically.
 */
public class ClassWriter {
  /**
   * Returns the appropriate string to declare and initialize variable with
   * given type and name.
   * 
   * @param type the type of the parameter in the constructor
   * @param name the name of the parameter in the constructor
   * @return a string of code to be used in writing a class
   */
  public static String writeInstanceVariable(String type, String name) 
  {
    String m = "private "+type+" "+name+" = ";
    if (type.equals("int")) {
      m+="-1";
    } else if (type.equals("double")) {
      m+="0.0";
    } else if (type.equals("boolean")) {
      m+="false";
    } else {
      m+="null";
    }
    return m+";";
  }


  /**
   * Returns the appropriate string to construct an object with given name and one
   * instance variable with given type and name.
   * 
   * @param className the name of the class for which the constructor is being
   *                  written
   * @param type      the type of the parameter in the constructor
   * @param name      the name of the parameter in the constructor
   * @return a string of code to be used in writing a class
   */
  public static String writeConstructor(String className, String type, String name) {
    return "public "+className+"("+type+" "+name+") {\n\tthis."+name+" = "+name+";\n}";
  }

  /**
   * Returns the appropriate string to construct an object with given name and two
   * instance variables with given types and names.
   * 
   * @param className the name of the class for which the constructor is being
   *                  written
   * @param type1     the type of the first parameter in the constructor
   * @param name1     the name of the first parameter in the constructor
   * @param type2     the type of the second parameter in the constructor
   * @param name2     the name of the second parameter in the constructor
   * @return a string of code to be used in writing a class
   */
  public static String writeConstructor(String className, String type1, String name1, String type2, String name2) 
  {
    return "public "+className+"("+type1+" "+name1+", "+type2+" "+name2+") {\n\tthis."+name1+" = "+name1+";\n\tthis."+name2+" = "+name2+";\n}";
  }


  /**
   * Returns the appropriate string to write an accessor method for a variable
   * with given type and name.
   * 
   * @param type the type of the variable being accessed through the method
   * @param name the name of the variable being accessed through the method
   * @return a string of code to be used in writing a class
   */
  public static String writeGetterMethod(String type, String name) 
  {
    return "public "+type+" get"+name.substring(0,1).toUpperCase()+name.substring(1)+"() {\n\treturn "+name+";\n}";
  }


  /**
   * Returns the appropriate string to write a mutator method for a variable with
   * given type and name.
   * 
   * @param type the type of the variable being changed through the method
   * @param name the name of the variable being changed through the method
   * @return a string of code to be used in writing a class
   */
  public static String writeSetterMethod(String type, String name) 
  {
    return "public "+type+" set"+name.substring(0,1).toUpperCase()+name.substring(1)+"("+type+" "+name+") {\n\tthis."+name+" = "+name+";\n}";
  }


}
