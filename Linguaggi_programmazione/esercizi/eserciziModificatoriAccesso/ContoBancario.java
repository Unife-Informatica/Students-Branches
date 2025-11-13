public class ContoBancario {
  private double saldo;

  public ContoBancario(){
  }

  public void deposita(double cifra){
    this.saldo+=cifra;
    System.out.println("Saldo aggiornato: " + this.saldo);
  }
}
