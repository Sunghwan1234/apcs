package Roomroot;

/** For values that need a max. */
public class Max {
  public int max;
  private int v;
  public Max(Max m) {
    this.max=m.max;
    this.v=max;
  }
  public Max(int max, int v) {
    this.max=max;
    this.v=v;
  }
  public Max(int max) {
    this.max=max;
    this.v=max;
  }
  /** Returns V. */
  public int v() {return v;}
  /** Change Value. */
  public int add(int i) {
    this.v = Math.max(0, Math.min(this.v + i, this.max));
    return v;
  }
  public int inc(int i) {return add(i);}
  public int dec(int i) {return add(-i);}
  /** Sets a new maximum & value. */
  public int set(Max i) {
    this.max=i.max;
    this.v=i.v();
    return v;
  }
  /** Sets a new maximum & value */
  public int set(int m) {
    this.max=m;
    this.v=m;
    return v;
  }

  public boolean full() {return this.v==this.max;}
  public boolean empty() {return this.v==0;}



  @Override
  public String toString() {
    return v+"/"+max;
  }
}
