public class CounterDec{
  private Counter c;
  public CounterDec(){
    c = new Counter();
  }
  public CounterDec(int x){
    c = new Counter(x);
  }
  public void reset(){
    c.reset();
  }
  public void inc(){
    c.inc();
  }
  public void dec(){
    c.dec();
  }
  public int getValue(){
    return c.getValue();
  }
}