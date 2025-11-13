import java.util.List;

public abstract class Cliente {
  protected String tipoCliente, indirizzo, data;
  protected int codiceIdentif;
  protected List<Premio> listaPremi;

  public Cliente(String tipoCliente, int codiceIdentif, String indirizzo, String data, List<Premio> listaPremi){
    this.tipoCliente=tipoCliente;
    this.codiceIdentif=codiceIdentif;
    this.indirizzo=indirizzo;
    this.data=data;
    this.listaPremi=listaPremi;
  }

  public String getTipoCliente(){
    return this.tipoCliente;
  }

  public int getCodiceIdentif(){
    return this.codiceIdentif;
  }

  public String getIndirizzo(){
    return this.indirizzo;
  }

  public String getData(){
    return this.data;
  }
  
  public List<Premio> getListaPremi(){
    return this.listaPremi;
  }
}
