import java.io.Serializable;

public class Message implements Serializable {

    private int val;

    public Message(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
