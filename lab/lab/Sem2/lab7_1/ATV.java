package lab.lab.Sem2.lab7_1;

public class ATV extends RecVehicle {
    String transmission;
    public ATV(String name, double cost, int inventory,String transmission) {
        super(name,cost,inventory);
        this.transmission=transmission;
    }
    public String getTransmission() {
        return transmission;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return super.toString()+", transmission: "+transmission;
    }
}
