import java.util.List;

public class Contatto {
  private int codiceIscrittoCont;
  private List<Integer> listaCodici;
  
  public Contatto(int codiceIscrittoCont, List<Integer> listaCodici) {
    this.codiceIscrittoCont = codiceIscrittoCont;
    this.listaCodici = listaCodici;
  }

  public int getCodiceIscrittoCont() {
    return codiceIscrittoCont;
  }

  public List<Integer> getListaCodici() {
    return listaCodici;
  }
}
