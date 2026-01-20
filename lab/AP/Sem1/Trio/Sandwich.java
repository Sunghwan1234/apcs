package AP.Trio;

public class Sandwich implements MenuItem {
  String name;
  double price;

  public Sandwich(String name, double price) {
    this.name=name;
    this.price=price;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getPrice() {
    return price;
  }
  
}
