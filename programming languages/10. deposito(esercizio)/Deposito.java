public class Deposito {
  private float soldi;
  public Deposito() { this.soldi = 0; }
  public Deposito(float soldi) { this.soldi = soldi; }
  /*
   * Quando stampo un puntatore alla classe Deposito il 
   * System.out.println() richiamerà in automatico la funzione
   * toString() e quindi verrà stampato Soldi: 0.0
   */
  public String toString() {
    return "Soldi: " + soldi;
  }
}
