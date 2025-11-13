public class Auto extends Veicolo{
  private String modello;

  public Auto(String marca, String modello) {
    super(marca);
    this.modello = modello;
  }

  public void mostraModello() {
    System.out.println("Modello: " + modello);
  }
}
