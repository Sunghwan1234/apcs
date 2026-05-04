package lab.lab.Sem2.lab7_1;

public class MsPacMan extends PacMan {
    boolean eatenPowerPallet;
    int points;

    public MsPacMan(String name, Direction facing, int speed, boolean eatenPowerPallet, int points) {
        super(name, facing, speed);
        this.eatenPowerPallet=eatenPowerPallet;
        this.points=points;
    }
    public boolean getPowerPellet() {
        return eatenPowerPallet;
    }
    public int getPoints() {
        return points;
    }
    public void setPowerPellet(boolean eatenPowerPallet) {
        this.eatenPowerPallet = eatenPowerPallet;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return super.toString()+", eaten: "+eatenPowerPallet+", points: "+points;
    }
}
