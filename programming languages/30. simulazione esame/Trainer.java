
public class Trainer extends Dipendente {

    int ore;
    String specialita;

    public Trainer(int codice, String nome, int ore, double costo, String specialita) {
        super(codice, nome, costo);
        this.ore = ore;
        this.costo = costo;
        this.specialita = specialita;
    }

    public int getOre() {
        return ore;
    }

    public String getSpecialita() {
        return specialita;
    }

    @Override
    public String toString() {
        return super.toString() + "trainer" + getOre() + "\t" + getSpecialita() + "\t-\t-\t-\t" + getCosto();
    }
}
