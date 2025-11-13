public class Trainer extends Dipendente{
  private int oreSett;
  private double costoOrarioTrainer;
  private String specialita;
  
  public Trainer(int codiceDip, String tipoDip, String nomeDip, int oreSett, double costoOrarioTrainer,
      String specialita) {
    super(codiceDip, tipoDip, nomeDip);
    this.oreSett = oreSett;
    this.costoOrarioTrainer = costoOrarioTrainer;
    this.specialita = specialita;
  }

  public int getOreSett() {
    return oreSett;
  }

  public double getCostoOrarioTrainer() {
    return costoOrarioTrainer;
  }

  public String getSpecialita() {
    return specialita;
  }
}
