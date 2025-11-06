package lab.apline;

public class APLine {
    double a,b,c;
    public APLine(double ia, double ib, double ic) {
        a=ia; b=ib; c=ic;
    }
    public double getSlope() {
        return -a/b;
    }
    public boolean isOnLine(double x, double y) {
        return a*x + b*y==-c;
    }
}
