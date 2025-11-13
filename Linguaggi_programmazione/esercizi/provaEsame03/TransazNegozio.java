import java.util.List;

public class TransazNegozio extends Transazione{
  private String citta;

  public TransazNegozio(String tipoTr, int id, String data, List<Libro> listaLibri, String citta){
    super(tipoTr, id, data, listaLibri);
    this.citta=citta;
  }

  public String getDatoExtra(){
    return this.citta;
  }
}
