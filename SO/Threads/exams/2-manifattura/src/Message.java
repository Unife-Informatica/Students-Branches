
import java.io.Serializable;

public class Message implements Serializable{

    private int contP = 0;
    private float valCasuale = 0;
    public Message(int contP, float valCasuale) {
        this.contP = contP;
        this.valCasuale = valCasuale;
    }
    public int getContP() {
        return contP;
    }
    public float getValCasuale() {
        return valCasuale;
    }
    
}