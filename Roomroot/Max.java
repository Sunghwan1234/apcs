package Roomroot;

/** For values that need a max. */
public class Max {
  public int max;
  private int v;

  public Max(int max, int v) {
    this.max=max;
    this.v=v;
  }
  public Max(int max) {
    this.max=max;
    this.v=max;
  }
  /** Returns V. */
  public int v() {
    return v;
  }

  public int inc(int i) {
    this.v = Math.max(0, Math.min(this.v + i, this.max));
    return v;
  }
  public int dec(int i) {
    this.v = Math.max(0, Math.min(this.v - i, this.max));
    return v;
  }
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

  public boolean full() {
    return this.v==this.max;
  }

  @Override
  public String toString() {
    return v+"";
  }
}
