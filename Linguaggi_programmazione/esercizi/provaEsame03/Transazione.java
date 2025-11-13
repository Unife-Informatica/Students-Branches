import java.util.List;

public abstract class Transazione {
  protected String tipoTr, data;
  protected int id;
  protected List<Libro> libri;

  public Transazione(String tipoTr, int id, String data, List<Libro> listaLibri){
    this.tipoTr=tipoTr;
    this.id=id;
    this.data=data;
    this.libri=listaLibri;
  }

  public String getTipoTr(){
    return this.tipoTr;
  }

  public int getId(){
    return this.id;
  }

  public String getData(){
    return this.data;
  }

  public int getPrezzoTotale(){
    int tot = 0;
    for(Libro l : libri){
      tot+=l.getPrezzo();
    }
    return tot;
  }

  public List<Libro> getListaLibri(){
    return this.libri;
  }

  public abstract String getDatoExtra();
}
