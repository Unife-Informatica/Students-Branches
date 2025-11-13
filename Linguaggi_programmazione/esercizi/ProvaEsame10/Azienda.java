import java.util.List;

public class Azienda extends Cliente{
  private String ragSociale;
  private float premioCorrTasse;
  
  public Azienda(String tipoClienteString, int codCliente, int codFilialeAtt, List<Integer> listaExFiliali,
      float premioCorrente, String ragSociale, float premioCorrTasse) {
    super(tipoClienteString, codCliente, codFilialeAtt, listaExFiliali, premioCorrente);
    this.ragSociale = ragSociale;
    this.premioCorrTasse = premioCorrTasse;
  }

  public String getRagSociale() {
    return ragSociale;
  }

  public float getPremioCorrTasse() {
    return premioCorrTasse;
  }
}
