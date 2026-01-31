import java.io.Serializable;

public class Rilevazione implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int val;
    private final long timestamp;

    public Rilevazione(int val, long timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }

    public int getVal() {
        return val;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
