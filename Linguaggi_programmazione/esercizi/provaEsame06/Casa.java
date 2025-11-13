public class Casa extends Partita{
  private String nomePalazzetto;

  public Casa(String tipoPartita, String data, String ora, String risultato, int vittoria, String nomePalazzetto){
    super(tipoPartita, data, ora, risultato, vittoria);
    this.nomePalazzetto=nomePalazzetto;
  }

  public String getDettaglio(){
    return this.nomePalazzetto;
  }
}
