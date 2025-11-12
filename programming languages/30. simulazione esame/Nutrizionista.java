
public class Nutrizionista extends Dipendente {

    int telefono, appuntamenti;
    boolean medico;

    public Nutrizionista(int codice, String nome, int telefono, int appuntamenti, boolean medico, double costo) {
        super(codice, nome, costo);
        this.telefono = telefono;
        this.appuntamenti = appuntamenti;
        this.medico = medico;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getAppuntamenti() {
        return appuntamenti;
    }

    public boolean isMedico() {
        return medico;
    }

    @Override
    public String toString() {
        return super.toString() + "trainer" + "-" + "\t" + "-" + "\t" + getTelefono() + "\t " + isMedico() + "\t" + getAppuntamenti() + "\t" + super.getCosto();
    }
}
