public class Film extends Spettacolo{
  private int duarata;

  public Film(String titolo, String tipo, String produttore, int codice, int anno, int duarata) {
    super(titolo, tipo, produttore, codice, anno);
    this.duarata = duarata;
  }

  public int getDuarata() {
    return duarata;
  }
}
