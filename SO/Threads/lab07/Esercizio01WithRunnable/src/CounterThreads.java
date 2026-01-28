public class CounterThreads implements Runnable{
    private Accumulatore acc;
    public CounterThreads(Accumulatore acc){
        this.acc=acc;
    }
    @Override    
    public void run(){
        double value=Math.random();
        acc.addValue(value);
        System.out.println(Thread.currentThread()+" Accumulatore:"+acc.getValue());
    }
}
