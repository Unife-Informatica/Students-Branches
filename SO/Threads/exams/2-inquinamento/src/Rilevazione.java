
import java.io.Serializable;

public class Rilevazione implements Serializable{
    private int valore=0;
    private long timestamp=0L;

    public void setValore(int valore){
        this.valore=valore;
    }
    public int getValore(){
        return valore;
    }

    public void setTimestamp(long timestamp){
        this.timestamp=timestamp;
    }
    public long getTimestamp(){
        return timestamp;
    }
}