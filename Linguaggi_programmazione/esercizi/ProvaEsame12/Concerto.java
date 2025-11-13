import java.util.List;

public class Concerto extends Evento{
  private int duarataConcerto;

  public Concerto(String nomeEvento, String tipo, String struttura, String data, int codiceEvento, int nPosti, float prezzo, int duarataConcerto, List<Prenotazione> listaPrenotazioni) {
    super(nomeEvento, tipo, struttura, data, codiceEvento, nPosti, prezzo, listaPrenotazioni);
    this.duarataConcerto = duarataConcerto;
  }

  public String getDettaglio(){
    return Float.toString(duarataConcerto);
  }
}
