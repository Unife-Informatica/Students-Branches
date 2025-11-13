public class Incrementa{
  public static void main(String[] args){
    CounterDec cd;
    cd = new CounterDec(10);
    cd.reset();
    cd.inc();
    cd.inc();
    System.out.println(cd.getValue());
    cd.dec();
    System.out.println(cd.getValue());
  }
}