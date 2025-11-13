public class Fuoristrada extends Automobile{
  private int numMarce;

  public Fuoristrada(String tipo, String modello, String produttore, int peso, int codice, int numMarce){
    super(tipo, modello, produttore, peso, codice);
    this.numMarce=numMarce;
  }

  public String getDatoExtra(){
    return Integer.toString(this.numMarce);
  }
}