import java.io.Serializable;

public class Message implements Serializable{
  private int contProd = 0;
  private float valCasuale = 0.0F;

  public Message(int contProd, float valCasuale){
    this.contProd = contProd;
    this.valCasuale = valCasuale;
  }

  public int getContProd() {
    return contProd;
  }

  public float getValCasuale() {
    return valCasuale;
  }
}