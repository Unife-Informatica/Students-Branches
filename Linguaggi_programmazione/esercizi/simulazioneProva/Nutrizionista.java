public class Nutrizionista extends Dipendente{
  private long telefono;
  private boolean medico;
  private int appuntamentiSett;
  private double costoOrarioNutriz;
  
  public Nutrizionista(int codiceDip, String tipoDip, String nomeDip, long telefono, boolean medico,
      int appuntamentiSett, double costoOrarioNutriz) {
    super(codiceDip, tipoDip, nomeDip);
    this.telefono = telefono;
    this.medico = medico;
    this.appuntamentiSett = appuntamentiSett;
    this.costoOrarioNutriz = costoOrarioNutriz;
  }

  public long getTelefono() {
    return telefono;
  }

  public boolean isMedico() {
    return medico;
  }

  public int getAppuntamentiSett() {
    return appuntamentiSett;
  }

  public double getCostoOrarioNutriz() {
    return costoOrarioNutriz;
  }
}
