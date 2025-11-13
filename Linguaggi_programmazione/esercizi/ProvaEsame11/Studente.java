public class Studente extends Iscritto{
  private float votoMedio;

  public Studente(String nomeCognome, String tipoIscritto, String indirizzo, int codiceIscritto, int eta, Contatto Contatto, float votoMedio) {
    super(nomeCognome, tipoIscritto, indirizzo, codiceIscritto, eta, Contatto);
    this.votoMedio = votoMedio;
  }

  public String getDettaglio(){
    return Float.toString(votoMedio);
  }
}
