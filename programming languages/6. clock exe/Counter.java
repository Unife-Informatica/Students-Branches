public class Counter {
  private int val;

  public Counter() {
    val = 0;
  }

  public Counter(int initial) {
    val = initial;
  }

  public void inc() {
    val++;
  }

  public void reset() {
    val = 0;
  }
}
