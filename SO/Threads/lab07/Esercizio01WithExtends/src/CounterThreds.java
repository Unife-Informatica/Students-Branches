

public class CounterThreds extends Thread {
    private Accumulatore acc;

    public CounterThreds(Accumulatore acc){
        this.acc=acc;
    }

    @Override
    public void run(){
        double value = Math.random();
        acc.addValue(value);
        System.out.println(Thread.currentThread()+" accumulatore: "+acc.getValue());

    }
}
