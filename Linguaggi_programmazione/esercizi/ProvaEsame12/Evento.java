import java.util.List;

public abstract class Evento {
  protected String nomeEvento, tipo, struttura, data;
  protected int codiceEvento, nPosti;
  protected float prezzo;
  protected List<Prenotazione> listaPrenotazioni;

  public Evento(String nomeEvento, String tipo, String struttura, String data, int codiceEvento, int nPosti, float prezzo, List<Prenotazione> listaPrenotazioni) {
    this.nomeEvento = nomeEvento;
    this.tipo = tipo;
    this.struttura = struttura;
    this.data = data;
    this.codiceEvento = codiceEvento;
    this.nPosti = nPosti;
    this.prezzo = prezzo;
    this.listaPrenotazioni = listaPrenotazioni;
  }

  public String getNomeEvento() {
    return nomeEvento;
  }

  public String getTipo() {
    return tipo;
  }

  public String getStruttura() {
    return struttura;
  }

  public String getData() {
    return data;
  }

  public int getCodiceEvento() {
    return codiceEvento;
  }

  public int getnPosti() {
    return nPosti;
  }

  public float getPrezzo() {
    return prezzo;
  }

  public List<Prenotazione> getListaPrenotazioni(){
    return this.listaPrenotazioni;
  }

  public abstract String getDettaglio();
}
