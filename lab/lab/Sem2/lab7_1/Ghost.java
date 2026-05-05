package lab.lab.Sem2.lab7_1;

public class Ghost extends PacMan {
    Color defaultColor, currentColor;
    boolean attackMode;
    MsPacMan mcPacMan;
    public Ghost(String name, Direction facing, int speed, Color color,boolean isAttackMode, MsPacMan msPacMan) {
        super(name, facing, speed);
        this.defaultColor=color;
        this.currentColor=color;
        this.attackMode=isAttackMode;
        this.mcPacMan=msPacMan;
    }
    public Color getDefaultColor() {
        return defaultColor;
    }
    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }
    public Color getCurrentColor() {
        return currentColor;
    }
    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }
    public boolean getAttackMode() {
        return attackMode;
    }
    public void setAttackMode() {
        if (getMcPacMan().getPowerPellet()) {
            attackMode=false;
        } else {
            attackMode=true;
        }
        setColor();
        reverseFacing();
    }
    public MsPacMan getMcPacMan() {
        return mcPacMan;
    }
    public void setMcPacMan(MsPacMan mcPacMan) {
        this.mcPacMan = mcPacMan;
    }

    private void setColor() {
        if (!attackMode) {
            currentColor=Color.BLUE;
        } else {
            currentColor=defaultColor;
        }
    }
    private void reverseFacing() {
        setFacing(getFacing().opposite);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString()+" Color "+currentColor+" ATT: "+attackMode;
    }
}
