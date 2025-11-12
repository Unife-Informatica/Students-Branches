interface CostiRitardi {
  public static final double PENALE_AZIONE = 3.0;
  public static final double PENALE_COMMEDIA = 2.50;
  public static final double PENALE_DRAMMA = 2.0;
}

public class Noleggio implements CostiRitardi {
  private Film filmNolegiato;
  private String codiceCliente;
  private int giorniRitardo;
  private double penaleBase, penaleDaPagare;
  
  public Noleggio(Film filmNoleggiato, String codiceCliente, int giorniRitardo, double penaleBase, double penaleDaPagare){
    this.filmNolegiato = filmNoleggiato;
    this.codiceCliente = codiceCliente;
    this.giorniRitardo = giorniRitardo;
    this.penaleBase = calcolaPenaleBase();
    this.penaleDaPagare = calcolaPenaleTot();
  }

  public double calcolaPenaleTot(){
    double penaleTot = 0;
    switch (filmNolegiato.getGenere().toLowerCase()) {
      case "azione":
        for(int i = 1; i <= this.giorniRitardo; i++ ){
          if(i <= 3){
            penaleTot += PENALE_AZIONE;
          }else{
            penaleTot += 4;
          }
        }
        break;

      case "commedia":
        if(this.giorniRitardo == 1){
          penaleTot = PENALE_COMMEDIA/2;
        }else{
          penaleTot = PENALE_COMMEDIA*giorniRitardo;
        }
        break;

      case "dramma":
        penaleTot = PENALE_DRAMMA*giorniRitardo;
        break;
    
      default:
        break;
    }
    return penaleTot;
  }

  public double calcolaPenaleBase(){
    double p = 0.0;
    switch (filmNolegiato.getGenere().toLowerCase()) {
      case "azione":
        p = PENALE_AZIONE;
        break;

      case "commedia":
        p = PENALE_COMMEDIA;
        break;

      case "dramma":
        p = PENALE_DRAMMA;
        break;
    
      default:
        break;
    }
    return p;
  }

  public String getCodice(){
    return filmNolegiato.getCodice();
  }

  public String getTitolo(){
    return filmNolegiato.getTitolo();
  }

  public double getPenaleBase(){
    return this.penaleBase;
  }

  public double getPenaleDaPagare(){
    return this.penaleDaPagare;
  }

  public String getCodiceCliente(){
    return this.codiceCliente;
  }

  public int getGiorniRitardo(){
    return this.giorniRitardo;
  }
}
