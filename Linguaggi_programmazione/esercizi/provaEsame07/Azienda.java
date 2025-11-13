import java.util.List;

public class Azienda extends Cliente{
  private String ragioneSoc;
  private int fatturato;

  public Azienda(String tipoCliente, int codiceIdentif, String indirizzo, String data, String ragioneSoc, int fatturato, List<Premio> listaPremi){
    super(tipoCliente, codiceIdentif, indirizzo, data, listaPremi);
    this.ragioneSoc=ragioneSoc;
    this.fatturato=fatturato;
  }

  public String getRagioneSoc(){
    return this.ragioneSoc;
  }

  public int getFatturato(){
    return this.fatturato;
  }
}
