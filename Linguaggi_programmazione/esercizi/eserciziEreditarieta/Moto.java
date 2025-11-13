public class Moto extends Veicolo{
  private int cilindrata;

  public Moto(String marca, int cilindrata){
    super(marca);
    this.cilindrata=cilindrata;
  }

  public void mostraCilindrata() {
    System.out.println("Cilindrata: " + cilindrata + "cc");
  }
}
