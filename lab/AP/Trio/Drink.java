package AP.Trio;

public class Drink implements MenuItem {
  String name;
  double price;

  public Drink(String name, double price) {
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
