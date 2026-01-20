package AP.Trio;

public class Trio implements MenuItem {
  Sandwich sandwich; Salad salad; Drink drink;

  public Trio(Sandwich sandwich, Salad salad, Drink drink) {
    this.sandwich=sandwich;
    this.salad=salad;
    this.drink=drink;
  }


  @Override
  public String getName() {
    return sandwich.getName()+"/"+salad.getName()+"/"+drink.getName()+" Trio";
  }


  @Override
  public double getPrice() {
    double price=0;
    if (sandwich.getPrice()<=salad.getPrice()) {
      price+=salad.getPrice();
      if (salad.getPrice()<=drink.getPrice()) {
        price+=drink.getPrice();
      } else {
        price+=sandwich.getPrice();
      }
    } else {
      price+=sandwich.getPrice();
      if (sandwich.getPrice()<=drink.getPrice()) {
        price+=drink.getPrice();
      } else {
        price+=salad.getPrice();
      }
    }
    return price;
  }


}
