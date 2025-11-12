public class Nutrizionista extends Dipendente {
    private String telefono;
    private Boolean medico;
    private int appuntamenti;
    private double costoOrario;
    public Nutrizionista(int codDipendente, String tipoDipendente, String nomeCognome, String telefono, Boolean medico,
            int appuntamenti, double costoOrario) {
        super(codDipendente, tipoDipendente, nomeCognome);
        this.telefono = telefono;
        this.medico = medico;
        this.appuntamenti = appuntamenti;
        this.costoOrario = costoOrario;
    }
    public String getTelefono() {
        return telefono;
    }
    public Boolean getMedico() {
        return medico;
    }
    public int getAppuntamenti() {
        return appuntamenti;
    }
    @Override
    public double getCostoOrario() {
        return costoOrario;
    }
    
}
