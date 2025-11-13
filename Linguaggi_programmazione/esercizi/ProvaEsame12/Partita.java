import java.util.List;

public class Partita extends Evento{
  private String sport;

  public Partita(String nomeEvento, String tipo, String struttura, String data, int codiceEvento, int nPosti, float prezzo, String sport, List<Prenotazione> listaPrenotazioni) {
    super(nomeEvento, tipo, struttura, data, codiceEvento, nPosti, prezzo, listaPrenotazioni);
    this.sport = sport;
  }

  public String getDettaglio(){
    return this.sport;
  }
}
