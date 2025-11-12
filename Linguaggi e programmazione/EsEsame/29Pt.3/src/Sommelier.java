public class Sommelier extends Impiegato {
    private int oreSettimanali;
    private double costOrario;
    private String specialita;
    public Sommelier(int codImpiegato, String tipoImpiegato, String nomeCognome, int oreSettimanali, double costOrario,
            String specialita) {
        super(codImpiegato, tipoImpiegato, nomeCognome);
        this.oreSettimanali = oreSettimanali;
        this.costOrario = costOrario;
        this.specialita = specialita;
    }
    public int getOreSettimanali() {
        return oreSettimanali;
    }
    @Override
    public double getCostOrario() {
        return costOrario;
    }
    public String getSpecialita() {
        return specialita;
    }

}
