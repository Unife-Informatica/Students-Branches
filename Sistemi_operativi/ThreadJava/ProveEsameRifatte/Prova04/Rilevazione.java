import java.io.Serializable;

public class Rilevazione implements Serializable{
  private int valore = 0;
  private long timeStamp = 0;

  public Rilevazione(int valore, long timestamp){
    this.valore = valore;
    this.timeStamp = timestamp;
  }

  public int getValore(){
    return this.valore;
  }

  public long getTimestamp(){
    return this.timeStamp;
  }
}