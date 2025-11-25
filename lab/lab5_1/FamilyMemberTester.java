package lab.lab5_1;

/**
 * FamilyMemberTester contains a main method to test FamilyMember objects.
 * 
 * The tester constructs five FamilyMember objects, invokes the toString method,
 * and prints the results.
 */
public class FamilyMemberTester {
  public static void main(String[] args) {
    Address momsAddress = new Address("135 Margaret Boulevard", "Merrick", "NY", 11566);
    Account momsAccount = new Account(123456, 4612.25);
    FamilyMember mom = new FamilyMember("Debra",  "Barone", momsAddress, momsAccount);
    System.out.println(mom + "\n");
    
    Address dadsAddress = new Address("136 Margaret Boulevard", "Merrick", "NY", 11566);
    Account dadsAccount = new Account(987654, 3216.74);
    FamilyMember dad = new FamilyMember("Ray", "Barone", dadsAddress, dadsAccount);
    System.out.println(dad + "\n");
    
    Address daughtersAddress = new Address("4295 Hempstead Turnpike", "Bethpage", "NY", 11714);
    Account daughtersAccount = new Account(102030, 52.50);
    FamilyMember daughter = new FamilyMember("Ally", "Barone", daughtersAddress, daughtersAccount);
    System.out.println(daughter + "\n");
    
    Address twinSonsAddress = new Address("2201 Hempstead Turnpike", "East Meadow", "NY", 11554);
    FamilyMember twinSon1 = new FamilyMember("Geoffrey", "Barone", twinSonsAddress, null);
    FamilyMember twinSon2 = new FamilyMember("Michael", "Barone", twinSonsAddress, null);
    System.out.println(twinSon1);
    System.out.println(twinSon2);
    System.out.println(daughter);
    System.out.println(dad);
    System.out.println(mom);
  }
}
