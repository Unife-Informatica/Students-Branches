public class Counter {
  private int val;
  public Counter() { val = 0; }
  public Counter(int initial) { val = initial; } // constructor with initial value defined with Counter(initial_value)
  public void reset() { val = 0; }
  public void inc() { val++; }
  public int getValue() { return val; }
  public void copy(Counter other) { this.val = other.val; }
}
