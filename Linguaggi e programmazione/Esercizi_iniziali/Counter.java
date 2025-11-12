package LP.Esercizi_iniziali;

public class Counter {
    private int val;
    public Counter(){
        val=0;
    }
    public Counter(int x){
        val=x;
    }
    public void reset(){
        val=0;
    }
    public void inc(){
        val++;
    }
    public void dec(){
        val--;
    }
    public int getValue(){
        return val;
    }
    public void copy(int x){
        val=x;
    }


}
