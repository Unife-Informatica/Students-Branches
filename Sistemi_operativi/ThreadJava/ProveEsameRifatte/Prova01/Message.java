import java.io.Serializable;

public class Message implements Serializable{
  private int nProdotti = 0;
  private float valCasuale = 0.0F;

  public Message(int nProdotti, float valCasuale){
    this.nProdotti = nProdotti;
    this.valCasuale = valCasuale;
  }

  public int getNProdotti(){
    return nProdotti;
  }

  public float getValCasuale(){
    return valCasuale;
  }
}