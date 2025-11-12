package LP.Esercizi_iniziali;
public class CounterDec {
    private Counter c;
    public CounterDec(){
        c = new Counter();
    }
    public CounterDec(int v){
        c = new Counter(v);
    }
    public void reset(){
        c.reset();
    }
    public void inc(){
        c.inc();
    }
    public int getValue(){
        return c.getValue();
    }
    public void dec(){
        c.dec();
    }



}
