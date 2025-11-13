public class Berlina extends Automobile{
  private double dimBagaglio;

  public Berlina(String tipo, String modello, String produttore, int peso, int codice, double dimBagaglio){
    super(tipo, modello, produttore, peso, codice);
    this.dimBagaglio=dimBagaglio;
  }

  public String getDatoExtra(){
    return Double.toString(this.dimBagaglio);
  }
}
