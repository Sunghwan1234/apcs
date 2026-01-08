

public class StringStuff
{
  public static void main (String[] args)
  {
    // Replace the name variable with your full name.
    String name = "Sunghwan In";
    System.out.println("My name is " + name + ".");
    System.out.println("Including spaces, my name is " + name.length() + " characters long.");
    System.out.println("Excluding spaces, my name is " + name.replaceAll(" ","").length() + " characters long.");
    System.out.println();
    
    // Use the indexOf method to find the beginning of index of each of your names.
    System.out.println(name.indexOf("Sung"));
    System.out.println(name.indexOf("hwan"));
    System.out.println(name.indexOf("In"));
    System.out.println();
    
    // Use the substring method (with two parameters) to print your first name.
    System.out.println("My first name is " + name.substring(0, 8) + ".");
    System.out.println();
    
    // Use the substring method (with two parameters) to print your middle name.
    System.out.println("My mid name is " + name.substring(4, 8) + ".");
    System.out.println();
    
    // Use the substring method (with one parameter) to print your last name.
    System.out.println("My last name is " + name.substring(9, 11) + ".");
    System.out.println();
    
    // Finally, use the toUpperCase and toLowerCase to write your name in all upper case and all lowercase.
    System.out.println("My name is " + name.toUpperCase() + ".");
    System.out.println("My name is " + name.toLowerCase() + ".");
    System.out.println();  
  }
}