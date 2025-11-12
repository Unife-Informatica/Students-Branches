public class Guida extends Impiegato {
    String numTel;
    boolean sEnglish;
    int appSett;
    double costOrario;
    public Guida(int codImpiegato, String tipoImpiegato, String nomeCognome, String numTel, boolean sEnglish,
            int appSett, double costOrario) {
        super(codImpiegato, tipoImpiegato, nomeCognome);
        this.numTel = numTel;
        this.sEnglish = sEnglish;
        this.appSett = appSett;
        this.costOrario = costOrario;
    }
    public String getNumTel() {
        return numTel;
    }
    public boolean issEnglish() {
        return sEnglish;
    }
    public int getAppSett() {
        return appSett;
    }
    @Override
    public double getCostOrario() {
        return costOrario;
    }
    
}
