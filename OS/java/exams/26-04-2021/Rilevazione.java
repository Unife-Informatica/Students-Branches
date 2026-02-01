import java.io.Serializable;

public class Rilevazione implements Serializable {

    private int val;
    private long time;

    public Rilevazione(int val, long time) {
        this.val = val;
        this.time = time;
    }

    public int getVal() {
        return val;
    }

    public long getTime() {
        return time;
    }
}
