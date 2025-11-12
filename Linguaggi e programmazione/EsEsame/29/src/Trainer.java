public class Trainer extends Dipendente {
    int oreSettimanali;
    double costoOrario;
    String specialita;
    public Trainer(int codDipendente, String tipoDipendente, String nomeDipendente, int oreSettimanali,
            double costoOrario, String specialita) {
        super(codDipendente, tipoDipendente, nomeDipendente);
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
    public double getCosto(){
        return costoOrario;
    }
    
}
