import java.util.List;

public class Visualizzazione {
  private int codice;
  private String nome, cognome;
  private List<Integer> listaCodiciSpettacoli;
  
  public Visualizzazione(int codice, String nome, String cognome, List<Integer> listaCodiciSpettacoli) {
    this.codice = codice;
    this.nome = nome;
    this.cognome = cognome;
    this.listaCodiciSpettacoli = listaCodiciSpettacoli;
  }

  public int getCodice() {
    return codice;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public List<Integer> getListaCodiciSpettacoli() {
    return listaCodiciSpettacoli;
  }
}
