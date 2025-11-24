import java.time.LocalDate;

public class Transazione {
  private String tipo;
  private LocalDate data;
  private double importo;
  
  public Transazione(String tipo, LocalDate data, double importo) {
    this.tipo = tipo;
    this.data = data;
    this.importo = importo;
  }

  public String getTipo() {
    return tipo;
  }

  public LocalDate getData() {
    return data;
  }

  public double getImporto() {
    return importo;
  }

  @Override
  public String toString(){
    return data + " " + importo + " " + tipo;
  }
}
