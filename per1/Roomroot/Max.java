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
    this.v = Math.clamp(v+=i, 0, max);
    return v;
  }
  public int dec(int i) {
    this.v = Math.clamp(v-=i, 0, max);
    return v;
  }

  public int set(Max i) {
    this.max=i.max;
    this.v=i.v();
    return v;
  }
  public int set(int m) {
    this.max=m;
    this.v=m;
    return v;
  }

  @Override
  public String toString() {
    return v+"";
  }
}
