public class FuoriCasa extends Partita{
  private String nomeCittaOspit;

  public FuoriCasa(String tipoPartita, String data, String ora, String risultato, int vittoria, String nomeCittaOspit){
    super(tipoPartita, data, ora, risultato, vittoria);
    this.nomeCittaOspit=nomeCittaOspit;
  }

  public String getDettaglio(){
    return this.nomeCittaOspit;
  }
}
