public class Trainer extends Dipendente {
    private int oreSettimanali;
    private double costoOrario;
    private String specialita;
    public Trainer(int codDipendente, String tipoDipendente, String nomeCognome, int oreSettimanali, double costoOrario,
            String specialita) {
        super(codDipendente, tipoDipendente, nomeCognome);
        this.oreSettimanali = oreSettimanali;
        this.costoOrario = costoOrario;
        this.specialita = specialita;
    }
    public int getOreSettimanali() {
        return oreSettimanali;
    }
    public String getSpecialita() {
        return specialita;
    }
    @Override
    public double getCostoOrario() {
        return costoOrario;
    }
    
}
