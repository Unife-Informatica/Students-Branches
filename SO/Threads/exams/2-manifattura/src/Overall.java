public class Overall {
    private int corretti = 0;
    private int difetti = 0;
    public synchronized void incrementaDifetti(){
        this.difetti++;
    }
    public synchronized void incrementaCorretti(){
        this.corretti++;
    }
    public synchronized int getDifetti(){
        return difetti;
    }
    public synchronized int getCorretti(){
        return corretti;
    }
}
