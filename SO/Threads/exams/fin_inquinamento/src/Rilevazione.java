import java.io.Serializable;

public class Rilevazione implements Serializable {
    private int valore = 0;
    private long timeStamp = 0;
    public Rilevazione(int valore, long timeStamp){
        this.valore = valore;
        this.timeStamp = timeStamp;
    }

    public int getValore() {
        return valore;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

}
