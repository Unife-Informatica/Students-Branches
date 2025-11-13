public class Counter{
  private int val;
  public Counter(){
    val = 0;
  }
  public Counter(int x){
    val = x;
  }
  public void reset(){
    val = 0;
  }
  public void inc(){
    val++;
  }
  public void dec(){
    val--;
  }
  public void copy(Counter c){
    val = c.val;
  }
  public int getValue(){
    return val;
  }
}